package com.blb;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo10Stream {

//    获取Stream流对象
    @Test
    public void testStream01(){
//        List获取Stream
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

//        Set获取Stream
        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

//        Map获取Stream
        Map<String, String> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<String> valueStream = map.values().stream();
        Stream<Map.Entry<String, String>> entryStream = map.entrySet().stream();

//       of静态方法获取Stream流
        Stream<String> stringStream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
    }

//    foreach
    @Test
    public void testStream02(){
        Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
//        stream.forEach(s->{
//            System.out.println(s);
//        });

        stream.forEach(System.out::println);
    }

//   count
    @Test
    public void testStream03(){
        Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
        System.out.println(stream.count());
    }

    //   filter
    @Test
    public void testStream04(){
        Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
       stream.filter(s-> s.startsWith("黄")).forEach(System.out::println);
    }

    //   limit
    @Test
    public void testStream05(){
        Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
        stream.limit(3).forEach(System.out::println);
    }

//   skip
    @Test
    public void testStream06(){
        Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
        stream.skip(3).forEach(System.out::println);
    }

//    map
    @Test
    public void testStream07(){
        Stream<String> stream = Stream.of("1","2","3","4","5","6");
        stream.map(s->Integer.parseInt(s)).forEach(System.out::println);
    }

//    sorted
    @Test
    public void testStream08(){
        Stream<Integer> stream = Stream.of(9,4,1,2,8);
//        stream.sorted().forEach(System.out::println);
        stream.sorted((o1,o2)->o2-o1).forEach(System.out::println);

    }

    //distanct
    @Test
    public void testStream09(){
        Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","张飞","赵云");
        stream.distinct().forEach(System.out::println);
    }

    @Test
    public void testStream10(){
        Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","张飞","赵云");
//      用List集合来收集
//        List<String> list = stream.collect(Collectors.toList());
//      用Set集合来收集
//        Set<String> set = stream.collect(Collectors.toSet());
//        System.out.println(set);

//      用ArrayList集合来收集
        ArrayList<String> arrayList = stream.collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList);
    }
}
