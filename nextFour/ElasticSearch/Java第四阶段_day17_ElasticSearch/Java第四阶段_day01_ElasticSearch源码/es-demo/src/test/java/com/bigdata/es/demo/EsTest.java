package com.bigdata.es.demo;
import com.bigdata.EsApplication;
import org.elasticsearch.search.aggregations.*;
import com.bigdata.es.pojo.Item;
import com.bigdata.es.repository.ItemRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)//让测试在Spring容器环境下执行
@SpringBootTest(classes = EsApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//配置文件属性的读取
public class EsTest {

    @Autowired
    public ElasticsearchTemplate template;

    @Autowired
    public ItemRepository itemRepository;

    @Test
    public void  testCreate(){
        // 创建索引，会根据Item类的@Document注解信息来创建
        template.createIndex(Item.class);
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        template.putMapping(Item.class);

    }

    @Test
    public void deleteIndex() {
        //template.deleteIndex(Item.class);
        template.deleteIndex("big");
    }

    @Test
    public void index() {
        Item item = new Item(1L, "小米手机7", " 手机",
                "小米", 3499.00, "http://image.bigdata.com/13123.jpg");
        itemRepository.save(item);
    }
    @Test
    public void indexList() {
        List<Item> list = new ArrayList<>();
        //list.add(new Item(1L, "小米手机7", "手机", "小米", 3299.00, "http://image.bigdata.com/13123.jpg"));
        list.add(new Item(2L, "坚果手机R1", "手机", "锤子", 3699.00, "http://image.bigdata.com/13123.jpg"));
        list.add(new Item(3L, "华为META10", "手机", "华为", 4499.00, "http://image.bigdata.com/13123.jpg"));
        list.add(new Item(4L, "小米Mix2S", "手机", "小米", 4299.00, "http://image.bigdata.com/13123.jpg"));
        list.add(new Item(5L, "荣耀V10", "手机", "华为", 2799.00, "http://image.bigdata.com/13123.jpg"));
        // 接收对象集合，实现批量新增
        itemRepository.saveAll(list);
    }

    @Test
    public  void delete(){
        itemRepository.deleteById(2L);
    }

    @Test
    public  void  testFind(){
        Iterable<Item> all=itemRepository.findAll();
        for (Item item:all){
            System.out.println("item="+item);
        }
    }

    @Test
    public void query(){
        // 查询全部，并按照价格降序排序
        Iterable<Item> items = this.itemRepository.findAll(Sort.by("price").descending());
        for (Item item : items) {
            System.out.println("item = " + item);
        }
    }
    @Test
    public  void testFindBy(){
       List<Item> items=this.itemRepository.findByPriceBetween(2000d,4000d);
        for (Item item : items) {
            System.out.println("item = " + item);
        }
    }

    @Test
    public void search(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title", "小米手机"));
        // 搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();
        System.out.println("total = " + total);
        for (Item item : items) {
            System.out.println(item);
        }
    }


    @Test
    public void searchByPage(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("category", "手机"));
        // 分页：从0开始
        int page = 0;
        int size = 5;
        queryBuilder.withPageable(PageRequest.of(page,size));

        // 搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 总条数
        System.out.println("总条数 = " + items.getTotalElements());
        // 总页数
        System.out.println("总页数 = " + items.getTotalPages());
        // 当前页
        System.out.println("当前页：" + items.getNumber());
        // 每页大小
        System.out.println("每页大小：" + items.getSize());

        for (Item item : items) {
            System.out.println(item);
        }
    }


    @Test
    public void searchAndSort(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("category", "手机"));

        // 排序
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.ASC));

        // 搜索，获取结果
        Page<Item> items = this.itemRepository.search(queryBuilder.build());
        // 总条数
        long total = items.getTotalElements();
        System.out.println("总条数 = " + total);

        for (Item item : items) {
            System.out.println(item);
        }
    }

    @Test
    public void testAgg(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 0、不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));
        // 1、添加一个新的聚合，聚合类型为terms，聚合名称为brands，聚合字段为brand
        queryBuilder.addAggregation(AggregationBuilders.terms("brands").field("brand"));
        // 2、查询,需要把结果强转为AggregatedPage类型
        AggregatedPage<Item> aggPage = (AggregatedPage<Item>) this.itemRepository.search(queryBuilder.build());
        // 3、解析
        // 3.1、从结果中取出名为brands的那个聚合，
        // 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        StringTerms agg = (StringTerms) aggPage.getAggregation("brands");
        // 3.2、获取桶
        List<StringTerms.Bucket> buckets = agg.getBuckets();
        // 3.3、遍历
        for (StringTerms.Bucket bucket : buckets) {
            // 3.4、获取桶中的key，即品牌名称
            System.out.println(bucket.getKeyAsString());
            // 3.5、获取桶中的文档数量
            System.out.println(bucket.getDocCount());
        }

    }


}
