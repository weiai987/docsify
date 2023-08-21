# 学习目标

```
1、能够说出Map集合特点
2、掌握多种集合的遍历方式
3、掌握Collections工具类的使用 
4、了解HashMap和Hashtable的区别和联系
5、掌握集合中泛型的使用
6、能够理解泛型上下限
7、能够阐述泛型通配符的作用
```



# 第1章 Map接口

## 1.1 概述

​		前面学习的`List`跟`Set`主要用来存储单个实体的元素，但在生活中，很多时候我们会遇到这种集合：老公跟老婆、个人与身份证号等成对的数据组合，显然用`List`跟`Set`就显得力不从心了。对于这种数据就可以使用`Map`来完成。

​		`Map`中的集合，元素是成对存在的。每个元素由键与值两部分组成，通过键可以找对所对应的值。成为双列集合。其中键(Key)不能重复，值(Value)可以重复，每个键对应一个值。简称键值(K-V)对。

​		`Map`常用子类有`HashMap`、`TreeMap`。



## 1.2 常见API

Map接口中定义了很多方法，常用的如下：

* `public V put(K key, V value)`:  把指定的键与指定的值添加到Map集合中。
* `public V remove(Object key)`: 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
* `public V get(Object key)` 根据指定的键，在Map集合中获取对应的值。
* `boolean containsKey(Object key)  ` 判断集合中是否包含指定的键。
* `public Set<K> keySet()`: 获取Map集合中所有的键，存储到Set集合中。
* `public Set<Map.Entry<K,V>> entrySet()`: 获取到Map集合中所有的键值对对象的集合(Set集合)。

 

# 第2章 HashMap类

## 	2.1 API的使用

​	`HashMap`是使用最频繁的一个Map接口的子类。底层结构在JDK1.8主要采用数组+链表+红黑树实现。 

​	我们看下`HashMap`的基本用法：

```java
//三国时期，刘备派关羽守樊城，张飞守新野，赵子龙守徐州，他自己坐镇荆州。
public static void main(String[] args) { 
        //创建 map对象
        HashMap<String, String> map = new HashMap<String, String>();

        //添加元素到集合
        map.put("关羽", "樊城");
        map.put("张飞", "新野");
        map.put("赵子龙", "徐州");
        map.put("刘备", "荆州");
        System.out.println(map);

//        删除赵子龙
        System.out.println(map.remove("赵子龙"));
        System.out.println(map);

        // 想要查看刘备守哪座城？
        System.out.println(map.get("刘备"));
    }

```

​	

​		那如果存储的键改为自定义类呢？

**代码演示**

三国时期，刘备派关羽守樊城，张飞守新野，赵子龙守徐州，他自己坐镇荆州。使用`HashMap`来实现，并打印输出，张飞守的是那座城?

```java
public class Demo08HashMap {

    public static void main(String[] args) {
        //创建 map对象
        HashMap<Hero, String> map = new HashMap<Hero, String>();

        //添加元素到集合
        map.put(new Hero("关羽"), "樊城");
        map.put(new Hero("张飞"), "新野");
        map.put(new Hero("赵子龙"), "徐州");
        map.put(new Hero("刘备"), "荆州");
        map.put(new Hero("刘备"), "荆州");

        System.out.println(map);
// {Hero{name='张飞'}=新野, Hero{name='刘备'}=荆州, Hero{name='刘备'}=荆州, Hero{name='关羽'}=樊城, Hero{name='赵子龙'}=徐州}
    }
}

class Hero{

    private String name ;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

​		这里通过Map的输出可以看到刘备的Hero重复显示了，但是前面我们说了`Map`有个特性，`Key`不能重复。那这里为什么重复了呢？主要原因是对于自定义类型是如何判断这个Key是否是重复的呢？对于`HashMap`而言，主要是通过对象的`hashcode`跟`equals`方法来决定的。

- equals()相等的两个对象他们的hashCode()肯定相等。
- hashCode()相等的两个对象他们的equals()不一定相等。



**修改后的代码演示**

```java
class Hero{

    private String name ;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;
        Hero hero = (Hero) o;
        return Objects.equals(name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                '}';
    }
}



public class Demo08HashMap {



    public static void main(String[] args) {
        //创建 map对象
        HashMap<Hero, String> map = new HashMap<Hero, String>();

        //添加元素到集合
        map.put(new Hero("关羽"), "樊城");
        map.put(new Hero("张飞"), "新野");
        map.put(new Hero("赵子龙"), "徐州");
        map.put(new Hero("刘备"), "荆州");
        map.put(new Hero("刘备"), "荆州");

        System.out.println(map);
       // {Hero{name='张飞'}=新野, Hero{name='关羽'}=樊城, Hero{name='赵子龙'}=徐州, Hero{name='刘备'}=荆州}

    }
}
```

​		这里我们可以通过结果看到重复的刘备Hero没有重复显示了。

 

## 2.2 遍历

### 	2.2.1 方式1

​	通过map的keySet方法可以获取装所有的key的set，然后遍历再获取value。

**代码演示**

```java
 //创建 map对象
        HashMap<String, String> map = new HashMap<String, String>();

        //添加元素到集合
        map.put("关羽", "樊城");
        map.put("张飞", "新野");
        map.put("赵子龙", "徐州");
        map.put("刘备", "荆州"); 

        Set<String> keys = map.keySet();
        for (String name : keys) {
            System.out.println(name + " " + map.get(name));
        }
```

tips： 如果只想获取所有的值的话，可以通过map的values方法。

```java
 Collection<String> values = map.values();
for (String value : map.values()) {
    System.out.println("Value = " + value);
}
```

方式1使用比较简单，但是效率比较低。



### 2.2.2 方式2

`HashMap`将所有的Key跟所有的Value重新包装成`Map.Entry`类了，并且通过`entrySet`方法返回所有数据对应`的Map.Entry`集合。

**代码演示**

```java
 public static void main(String[] args) {
        //创建 map对象
        HashMap<String, String> map = new HashMap<String, String>();

        //添加元素到集合
        map.put("关羽", "樊城");
        map.put("张飞", "新野");
        map.put("赵子龙", "徐州");
        map.put("刘备", "荆州");
 

//        方式2
     Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

 }
```



### 2.2.3 方式3

```java
public static void main(String[] args) {
    //创建 map对象
    HashMap<String, String> map = new HashMap<String, String>();

    //添加元素到集合
    map.put("关羽", "樊城");
    map.put("张飞", "新野");
    map.put("赵子龙", "徐州");
    map.put("刘备", "荆州");

    //方式3 推荐
    for(Map.Entry<String, String> entry : map.entrySet()) {
        System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
    }


}
```

tips： 这种方式简单好用又高效，推荐使用。



# 第3章 Collections类 

​		JDK提供了一个工具类`java.utils.Collections`，可以用来对集合进行操作。	



## 3.1 常用API

- `public static <T> boolean addAll(Collection<T> c, T... elements)  `:往集合中添加一些元素。

  ```java
  @Test
  public  void testAddAll() {
      ArrayList<String> list = new ArrayList<String>();
      //      往集合中添加元素
      Collections.addAll(list,"关羽","张飞","赵子龙","刘备");
      System.out.println(list);
  }
  ```

  

- `public static void shuffle(List<?> list) 打乱顺序`:打乱集合顺序。

  ```java
  @Test
  public  void testShuffle() {
      ArrayList<String> list = new ArrayList<String>();
      //      往集合中添加元素
      Collections.addAll(list,"关羽","张飞","赵子龙","刘备");
      System.out.println(list);
  
      //     随机打乱这个集合中的元素
      Collections.shuffle(list);
      System.out.println(list);
  }
  ```

  

- `public static <T> void sort(List<T> list)`:将集合中元素按照默认规则排序。

- `public static <T> void sort(List<T> list，Comparator<? super T> )`:将集合中元素按照指定规则排序。

  ```java
  @Test
      public  void testSort() {
          ArrayList<Integer> list = new ArrayList<Integer>();
  
  //      往集合中添加元素
          Collections.addAll(list,3,9,6,4,1,5);
          System.out.println(list);
  
  //      用默认的比较器对集合中的元素排序
          Collections.sort(list);
          System.out.println(list);
  
          Collections.sort(list, new Comparator<Integer>() {
              @Override
              public int compare(Integer o1, Integer o2) {
                  return o2-o1;
              }
          });
          System.out.println(list);
      }
  ```

  

- public static void reverse(List<?> list) : 反转指定列表中元素的顺序。

  ```java
      @Test
      public  void testReverse() {
          ArrayList<String> list = new ArrayList<String>();
          Collections.addAll(list,"关羽","张飞","赵子龙","刘备");
  //      往集合中所有元素反转
          Collections.reverse(list);
          System.out.println(list);
      }
  ```



- public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll)：根据其元素的自然顺序返回给定集合的最小元素。

- public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)：根据其元素的自然顺序返回给定集合的最大元素。

  ```java
      @Test
      public  void testMinAndMax() {
          ArrayList<Integer> list = new ArrayList<Integer>();
          Collections.addAll(list,3,9,6,4,1,5);
          System.out.println(Collections.min(list));
          System.out.println(Collections.max(list));
      }
  ```



public static void swap(List<?> list, int i, int j) : 交换指定列表中指定位置的元素。

```java
    @Test
    public  void testSwap() {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"关羽","张飞","赵子龙","刘备");
//      往集合中的元素进行互换
        Collections.swap(list,0,2);
        System.out.println(list);
    }
```



- public static <T> int binarySearch(List<? extends Comparable<? super T>> list,T key)：使用二叉搜索算法搜索指定对象的指定列表。**必须具有有序性**。

  ```java
  @Test
  public  void testBinarySearc() {
      ArrayList<Integer> list = new ArrayList<Integer>();
      Collections.addAll(list,1,2,3,4,5,6,7,8,9);
      System.out.println(Collections.binarySearch(list, 4));
  }
  ```



- public static <T> boolean replaceAll(List<T> list,T oldVal,T newVal): 将列表中一个指定值的所有出现替换为另一个。

  ```java
  @Test
  public  void testReplaceAll() {
      ArrayList<String> list = new ArrayList<String>();
      Collections.addAll(list,"关羽","张飞","赵子龙","刘备");
      Collections.replaceAll(list,"刘备","马超");
      System.out.println(list);
  }
  ```

  



# 第4章 泛型

## 4.1 概述

​		在集合存放数据时，我们可以存入任意类型，但通常为了严谨，我们更希望集合中的所有数据具有相同类型，比如书柜里面全是书，酒柜里面全是酒，衣柜里面全是衣服……

​		此时我们可以通过泛型来规范集合的所有元素的类型，能够使API更简洁，也能得到编译期间的语法检查，将运行期的类型不一致的问题调整到编译期的编译错误。

​		泛型，用来灵活地将数据类型应用到不同的类、方法、接口当中。将数据类型作为参数进行传递。

**代码演示**

```java
public static void main(String[] args) {
//        指定了泛型，决定了这个集合中的元素只能放入String类型
    List<String> list = new ArrayList<>();
    list.add("唐僧");
    list.add("孙悟空");
    list.add("猪八戒");
    list.add("沙僧");
//        list.add(1);// 编译错误，因为不是String类型
}
```

​		泛型是数据类型的一部分，我们将类名与泛型合并一起看做数据类型。



## 4.2 泛型类

- 定义


```
修饰符 class 类名<泛型> {
...
}
```

查看ArrayList的API

```java
class ArrayList<E>{ 
    
    public boolean add(E e){ }

    public E get(int index){ }
    
   	....
}
```

在创建对象的时候`ArrayList<String> list = new ArrayList<String>();`就自动将泛型确定下来，用定义的`String`替换定义中的`E`。

```java
class ArrayList<String>{ 
     public boolean add(String e){ }

     public String get(int index){  }
     ...
}
```



- 自定义泛型类

  ```java
  // 仿照ArrayList自定义泛型类
  class MyGeneric<E> {
      private  E e ;
  
      public void set(E e){
          this.e = e ;
      }
  
      public E get(){
          return e ;
      }
  
  }
  
  
  public class Demo12 {
  
      public static void main(String[] args) {
          // 泛型类确定为String
          MyGeneric<String> g1 = new MyGeneric<String>();
          g1.set("blb");
          System.out.println(g1.get());
         // 泛型类确定为Integer
          MyGeneric<Integer> g2 = new MyGeneric<Integer>();
          g2.set(9);
          System.out.println(g2.get());
  
      }
  }
  ```



## 4.3 泛型方法

- 定义

  ```
  修饰符 <泛型> 返回值类型 方法名(参数){  }
  ```



**代码演示**

```java
class GenericMethod  {

    public <E>  void show(E e){
        System.out.println(e);
    }

}

public class Demo13 {

    public static void main(String[] args) {
        GenericMethod gm = new GenericMethod();
//        泛型方法的类型确定为字符串
        gm.show("blb");
//        泛型方法的类型确定为Integer
        gm.show(99);
    }
}
```

tips：泛型方法中的泛型是在方法被调用的时候被确定下来。



## 4.4 泛型接口

- 定义

  ```
  修饰符 interface接口名<泛型> {  }
  ```

**代码演示**

```java
interface GenericInterface<E>{
    public abstract void set(E e);
    public abstract E get();
}
```

实现泛型接口并使用

```java
//此时泛型接口中的泛型确定为String
class GenericImpl implements GenericInterface<String>{
    private String data ;

    @Override
    public void set(String s) {
        this.data = s ;
    }

    @Override
    public String get() {
        return data;
    }
}

public class Demo14 {

    public static void main(String[] args) {
        GenericInterface gi = new GenericImpl() ;
        gi.set("blb");
        System.out.println(gi.get());
    }
}
```

tips: 泛型接口中的泛型是在创建实现类的时候确定的。



## 4.5 通配符泛型

​		当使用泛型类跟泛型接口传递参数的时候，泛型类型不确定的时候可以使用通配符<?>来表示任意泛型类。

​		一旦使用泛型的通配符后，带泛型参数的API就不能使用了。



**代码演示**

```java
 public static void main(String[] args) {
//        定义泛型为String
        List<String> list1 = new ArrayList<String>();
        show(list1);
//        定义泛型为Integer
        List<Integer> list2 = new ArrayList<Integer>();
        show(list2);


    }

    public static void show(List<?> list){
//        list.add(); //不能调用add方法
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
```



- 受限泛型

  ​	刚刚可以使用<?>来传递任意泛型，我们还可以指定一个泛型的**上限**和**下限**。

  

**泛型的上限**：

* **格式**： `类型名称 <? extends 类 > 对象名称`
* **意义**： `只能接收该类型及其子类`

**泛型的下限**：

- **格式**： `类型名称 <? super 类 > 对象名称`
- **意义**： `只能接收该类型及其父类型`



**代码演示**

​	现已知Object类，String 类，Number类，Integer类，其中Number是Integer的父类。

```java
public class Demo16Generic {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<String> list2 = new ArrayList<String>();
        List<Number> list3 = new ArrayList<Number>();
        List<Object> list4 = new ArrayList<Object>();

        show1(list1);
//        show1(list2);//报错
        show1(list3);
//        show1(list4);//报错

//        show2(list1);//报错
//        show2(list2);//报错
        show2(list3);
        show2(list4);
    }

    public static void show1(List<? extends Number> list){
    }

    public static void show2(List<? super Number> list){
    }
    
```




















