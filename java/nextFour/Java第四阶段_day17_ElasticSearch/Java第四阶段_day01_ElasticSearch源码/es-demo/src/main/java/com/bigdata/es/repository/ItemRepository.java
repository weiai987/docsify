package com.bigdata.es.repository;

import com.bigdata.es.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ItemRepository extends ElasticsearchRepository<Item,Long>{

     /**
      * 根据价格区间查询
      * @param begin
      * @param end
      * @return
      */
     List<Item> findByPriceBetween(Double begin, Double end);


}
