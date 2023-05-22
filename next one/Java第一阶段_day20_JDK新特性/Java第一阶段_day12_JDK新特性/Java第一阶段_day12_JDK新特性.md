# 学习目标

```
1、掌握Lambda表达式的基本用法以及省略模式
2、掌握接口中新增的静态方法跟默认方法的使用
3、掌握函数接口的用法
4、掌握方法引用的使用
5、掌握Stream流在集合中的使用
6、掌握JDK8对日期时间类的增强
7、掌握JDK8重复注解跟类型注解的使用
```



# 第1章 Lambda表达式

## 1.1 概述

​		Lambda 表达式（lambda expression）是一个匿名函数。主要用来优化匿名内部类的结构。我们先看下传统的匿名内部类的使用方式。

```java
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("有一个线程即将执行。");
    }
}).start();
```

​	    这是一个开启线程的案例，在这个案例中，这个`Runnable`的匿名实现类中，我们关注的其实只有里面的实现逻辑`System.out.println("有一个线程即将执行。")`，但整体代码显得非常繁琐跟冗余。JDK8提供了Lambda表达式来简化匿名内部类的写法，语法更加简洁，如下

```java
new Thread(()->System.out.println("有一个线程即将执行。")).start();
```



## 1.2 标准格式

Lambda表达式的语法为：

```
([参数列表]) ->{
	代码体;
}
```

**无参的代码演示**

```java
public class Demo02Lambda {

    public static void main(String[] args) {
        Drinkable drinkable = ()->{
            System.out.println("大口的喝...");
        };

        drinkable.drink();
    }
}

interface Drinkable{
    void drink();
}
```



**有参的代码演示**

```java
public class Demo03Lambda {

    public static void main(String[] args) {
        Eatable eatable = (food)->{
            System.out.println("大口的吃"+food);
            return "吃饱了";
        };

        String result = eatable.eat("牛肉");
        System.out.println(result);

    }
}

interface Eatable{
    String eat(String food);
}
```

## 1.3 省略模式

​	在lambda标准格式的基础上，可以使用省略写法的规则：

- 参数类型可以省略

- 如果参数有且仅有一个，则小括号可以省略

- 如果方法体中有且仅有一句代码，可以同时省略大括号、return关键字以及分号。

  如常规表达式为

  ```java
  (i)->{
      return i+i; 
  }
  ```

  省略模式后为

  ```java
  i->i+i 
  ```



## 1.4 使用限制

lambda表达式使用有几个条件需要特别注意：

- lambda表达式是针对接口才能使用
- 接口中必须有且仅有一个抽象方法，能被`@FunctionalInterface`注解修饰的方法



## 1.5 常用的内置函数接口

​	lambda表达式是针对接口的，有且仅有一个抽象方法，这种接口称为函数接口。lambda表达式使用时不关心接口名、抽象方法名，只关心抽象方法的参数列表和返回类型。因此JDK8提供了大量的常用的函数式接口。

​	这些函数接口都在`java.util.function`包下，常用接口有Supplier接口、Consumer接口、Function接口、Predicate接口。

### 1.5.1 Supplier接口

`java.util.function.Supplier<T>`接口，它表示”供给“，对应的lambda表达式需要对外提供一个符合泛型类型的对象数据。

```java
@FunctionalInterface
public interface Supplier<T> { 
    T get();
}
```

**代码演示**

```java
public class Demo04FunctionReference {

    public static void main(String[] args) {
        Supplier<Integer> supplier = ()->{
          return new Random().nextInt();
        };

        Integer result = supplier.get();
        System.out.println("随机产生一个整数： "+result);
    }
}
```



### 1.5.2 Consumer接口

`java.util.function.Consumer<T> `接口用来表示“消费”一个数据，数据类型有泛型决定。

```java
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```

**代码演示**

```java
//      小写字符串转成大写字符串
Consumer<String> consumer = (s)->{
    System.out.println(s.toUpperCase());
};
consumer.accept("hello blb!");
```



### 1.5.3 Function接口

`java.util.function.Function<T, R> `接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件，后者称为后置条件，有参数有返回。

```java
@FunctionalInterface
public interface Function<T, R> {
 
    R apply(T t);
}
```

**代码演示**

```java
//       将字符串转成数字
Function<String,Integer> function = (s)->{
    return Integer.parseInt(s);
};
System.out.println(function.apply("123"));
```



### 1.5.4 Predicate接口

`java.util.function.Predicate<T> `接口用来对某种类型的数据进行判断，从而得到一个boolean类型的结果。

```java
@FunctionalInterface
public interface Predicate<T> {
 
    boolean test(T t);
}
```

**代码演示**

```java
//      判断一个整数是否是偶数
Predicate<Integer> predicate = (i)->{
    return i%2==0;
};
System.out.println("是否是整数："+predicate.test(18));
```



# 第2章 接口的增强

## 2.1 概述

​	在JDK8以前的接口中，只能定义静态常量跟抽象方法，这对接口的扩展不太友好，比如List接口有很多实现类，当需要给List扩展一个方法时，所有实现类都必须实现这个扩展的方法，即使所有的实现都是相同的逻辑。

​	JDK8中对接口进行了增强，除了可以定义静态常量跟抽象方法外，还可以定义**默认方法**跟**静态方法**。



## 2.2 默认方法

​	接口中可以通过关键字`default`定义默认方法，实现类如果不想要默认方法的实现逻辑可以根据需求重新定义。

**代码演示**

```java
public class Demo05InterfaceEnhance {

    public static void main(String[] args) {
        Bird bird = new Chicken();
        bird.fly();
    }
}

interface Bird{

    default void fly(){
        System.out.println("展翅高飞");
    }

}

class Chicken implements Bird{

    @Override
    public void fly() {
        System.out.println("想飞却飞不高……");
    }
}
```



## 2.3 静态方法

​	JDK8中接口还可以定义静态方法，语法如下

```
interface 接口名{
	修饰符 static 返回值类型 方法名(){
		方法体;
	}
}
```

**代码演示**

```java
public class Demo06InterfaceEnhance {

    public static void main(String[] args) {
        Swimmable.swimming();
    }
}

interface Swimmable{

    public static void swimming(){
        System.out.println("游泳");
    }
}
```

tips：

- 接口中的静态方法，只能通过接口名调用，不能通过对象调用
- 静态方法不能在实现类中重写



> 默认方法跟静态方法的区别

- 默认方法通过实例调用，静态方法通过接口名调用
- 默认方法可以被继承，实现类可以直接使用接口默认方法，也可以重写默认方法
- 静态方法不能被继承，实现类不能重写接口的静态方法，只能通过接口名调用



# 第3章 方法引用

## 3.1 概述

​	**方法引用**是用来直接访问类或者实例的已经存在的方法或者构造方法。方法引用提供了一种引用而不执行方法的方式，它需要由兼容的函数式接口构成的目标类型上下文。计算时，方法引用会创建函数式接口的一个实例。

​	当Lambda表达式中只是执行一个方法调用时，不用Lambda表达式，直接通过方法引用的形式可读性更高一些。方法引用是一种更简洁易懂的Lambda表达式。

​	注意方法引用是一个Lambda表达式，其中方法引用的操作符是双冒号"::"。



**代码演示**

```java
public static void main(String[] args) {
    //  选择合适的函数接口，使它拥有跟System.out对象的println方法一样的功能。
    Consumer<String> consumer = System.out::println;
    consumer.accept("斗转星移");
}
```

​		方法引用分为4种：对象名引用成员方法、类名引用静态方法、类名引用实例方法、引用构造方法。



## 3.2 对象名引用成员方法

引用一个对象名的成员方法，语法如下

```
对象名::成员方法名;
```

**代码演示**

```java
// 定义函数接口，引用System.out对象的println方法
public void testMethod1(){
    Consumer<Object> c = System.out::println;
    c.accept("bailiban");
    c.accept(123);
}
```



## 3.3 类名引用静态方法

引用一个类名的静态方法，语法如下

```
类名::静态方法名;
```

**代码演示**

```java
// 定义函数接口，引用String类的valueOf静态方法
public void testMethod2(){
    Function<Integer, String> function = String::valueOf ;
    System.out.println(function.apply(123));
}
```



## 3.4 类名引用实例方法

引用一个类名的实例方法，语法如下

```
类名::成员方法名;
```

**代码演示**

```java
// 定义函数接口，引用String类的length方法
public static void testMethod3(){
    Function<String,Integer> function = String::length;
    System.out.println(function.apply("bailiban"));
}
```

tip：String类的length方法是没有参数的，但是Function函数是有一个参数的，这个参数表示是String类的任意对象。



## 3.5 引用构造方法

还可以引用一个类的构造器，语法如下

```
类名::new;
```

**代码演示**

```java
// 定义函数接口，引用Student类的构造器方法
public class Demo08FunctionReference {    

    @Test
    public void testMethod4(){
        Function<String,Student> function = Student::new;
        Student blb = function.apply("blb");
        System.out.println(blb);
    }

}

class Student {

    private String name ;

    public Student(String name){
        this.name = name ;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

 

# 第4章 Stream流

## 4.1 概述

​	在使用集合相关的操作中，比如过滤、匹配、遍历、排序等操作时总是需要循环来遍历所有元素，从而来得到需要的结果，但我们更关注的是实现需求的逻辑，而不是如何循环。

​	Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。Stream API可以极大提高Java程序员的生产力，让程序员写出高效率、干净、简洁的代码。这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。

​	Stream流不是一种数据结构，不保存数据，它只是在原数据集上定义了一组操作。



**代码演示**

```java
public class Demo09Stream {

    public static void main(String[] args) {
//      创建集合并添加元素
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
//       通过流过滤姓名以“黄”开头的元素，然后遍历
        list.stream().filter((s)->{
           return s.startsWith("黄");
        }).forEach((s)->{
            System.out.println(s);
        });

    }
}
```



## 4.2 Stream对象

`java.util.stream.Stream<T> `是Java 8新加入的最常用的流接口。

获取一个流非常简单，主要有2种常用的方式： 

- 所有的 Collection 集合都可以通过 stream 默认方法获取流

**代码演示**

```java
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
}
```



- Stream中的静态of方法

**代码演示**

```java
Stream<String> stringStream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
```



## 4.3 常用API

​	Stream流模型的操作很丰富，这里介绍一些常用的API。这些方法可以被分成两种： 



- **终结方法**：返回值类型不再是 Stream 类型的方法，因此不再支持链式调用。主要有包括 count 和 forEach 方法。 

- **非终结方法**：返回值类型仍然是 Stream 类型的方法，因此支持链式调用。

|  方法名  |  方法作用  | 返回值类型 | 方法种类 |
| :------: | :--------: | :--------: | :------: |
|  count   |  统计个数  |    long    |   终结   |
| foreach  |    遍历    |    void    |   终结   |
|  filter  |    过滤    |   Stream   |  非终结  |
|  limit   | 限定前几个 |   Stream   |  非终结  |
|   skip   | 跳过前几个 |   Stream   |  非终结  |
|   map    |    映射    |   Stream   |  非终结  |
|  sorted  |    排序    |   Stream   |  非终结  |
| distinct |    去重    |   Stream   |  非终结  |



**使用规则**

- Stream只能操作一次

- Stream方法返回的是新的流

- Stream不调用终结方法，中间的操作不会执行


#### 4.3.1 forEach

`void forEach(Consumer<? super T> action)`该方法接收一个 Consumer 接口函数，会将每一个流元素交给该函数进行处理。 

**代码演示**

```java
@Test
public void testStream02(){
    Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
    //        stream.forEach(s->{
    //            System.out.println(s);
    //        });

    stream.forEach(System.out::println);
}
```



#### 4.3.2 count

`long count()`,Stream流提供count方法来统计其中的元素个数。

**代码演示**

```java
@Test
public void testStream03(){
    Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
    System.out.println(stream.count());
}
```





#### 4.3.3 filter

`Stream<T> filter(Predicate<? super T> predicate)`可以通过 filter 方法将一个流转换成另一个子集流。该方法将会产生一个boolean值结果，代表指定的条件是否满足。如果结果为true，那么Stream流的 filter 方法将会留用元素；如果结果为false，那么 filter 方法将会舍弃元素。 

**代码演示**

```java
@Test
public void testStream04(){
    Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
    stream.filter(s-> s.startsWith("黄")).forEach(System.out::println);
}
```



#### 4.3.4 limit

`Stream<T> limit(long maxSize)` `limit `方法可以对流进行截取，只取用前n个。

**代码演示**

```java
@Test
public void testStream05(){
    Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
    stream.limit(3).forEach(System.out::println);
}
```



#### 4.3.5 skip

`Stream<T> skip(long n);`如果流的当前长度大于n，则跳过前n个。

**代码演示**

```java
@Test
public void testStream06(){
    Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","黄忠","黄月英");
    stream.skip(3).forEach(System.out::println);
}
```



#### 4.3.6 map

`<R> Stream<R> map(Function<? super T, ? extends R> mapper); `如果需要将流中的元素映射到另一个流中，可以使用 map 方法。

**代码演示**

```java
@Test
public void testStream07(){
    Stream<String> stream = Stream.of("1","2","3","4","5","6");
    stream.map(s->Integer.parseInt(s)).forEach(System.out::println);
}
```



#### 4.3.7 sorted

​	可以需要将数据进行排序，可以使用Stream的sorted方法排序。

```
Stream<T> sorted();
Stream<T> sorted(Comparator<? super T> comparator);
```

**代码演示**

```java
@Test
public void testStream08(){
    Stream<Integer> stream = Stream.of(9,4,1,2,8);
    //        stream.sorted().forEach(System.out::println);
    stream.sorted((o1,o2)->o2-o1).forEach(System.out::println);
}
```



#### 4.3.8 distinct

如果数据需要去掉重复元素可以使用distinct方法

```
Stream<T> distinct();
```

**代码演示**

```java
@Test
public void testStream09(){
    Stream<String> stream = Stream.of("刘备","张飞","赵云","诸葛亮","张飞","赵云");
    stream.distinct().forEach(System.out::println);
}
```



#### 4.3.9 Collector

​	对流操作完成以后，如果需要将数据保存到数组或者集合中，可以收集流中的数据。

```java
  <R, A> R collect(Collector<? super T, A, R> collector);
```

**代码演示**

```java
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
```



# 第5章 日期跟时间

​	JDK8之前的日期存在一些问题，比如API过时、线程安全问题、时区处理麻烦等问题。在JDK8中引入了新的日期时间相关的API。

​	JDK8引入了LocalDate、LocalTime、LocalDateTime类，这些类在`java.time`包下，并且它们的实例是不可变对象。分别使用表示ISO-8601日历系统的日期、时间、日期时间。



## 5.1 日期

​	日期包含年月日信息，日期的操作的常用API如下

**代码演示**

```java
 @Test
    public void dateTime01(){
//      获取当前对应的日期
        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate date = LocalDate.of(2020, 12, 13);
        System.out.println(date);
//      获取年份
        System.out.println(now.getYear());
//       获取月份，英文
        System.out.println(now.getMonth());
//       获取月份值
        System.out.println(now.getMonthValue());
//        获取当月中的第几天，也就是几号
        System.out.println(now.getDayOfMonth());
//        获取当周中的第几天，也就是星期
        System.out.println(now.getDayOfWeek());
//        获取年中的第几天
        System.out.println(now.getDayOfYear());
//        修改年份为2019
        System.out.println(now.withYear(2019));
//        修改月份为2
        System.out.println(now.withMonth(2));
//        修改日期为3号
        System.out.println(now.withDayOfMonth(3));
    }
```



## 5.2 时间

时间包含时分秒信息，时间操作常用的API如下

**代码演示**

```java
@Test
public void dateTime02(){
    LocalTime time = LocalTime.of(11,12,13);
    System.out.println(time);
    //      获取当前时间
    LocalTime now = LocalTime.now();
    //       获取小时
    System.out.println(now.getHour());
    //       获取分
    System.out.println(now.getMinute());
    //       获取秒
    System.out.println(now.getSecond());
    //       获取纳秒
    System.out.println(now.getNano());
    //      修改小时为12
    System.out.println(now.withHour(12));
    //       修改分钟为22
    System.out.println(now.withMinute(22));
    //        修改秒为33
    System.out.println(now.withSecond(33));
}
```



## 5.3 日期时间

​	日期时间包含年月日时分秒信息，常用API如下

**代码演示**

```java
@Test
public void dateTime03(){
    LocalDateTime time = LocalDateTime.of(2020,12,11,10,11,12);
    System.out.println(time);

    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);

    //      获取年份
    System.out.println(now.getYear());
    //       获取月份，英文
    System.out.println(now.getMonth());
    //       获取月份值
    System.out.println(now.getMonthValue());
    //        获取当月中的第几天，也就是几号
    System.out.println(now.getDayOfMonth());
    //        获取当周中的第几天，也就是星期
    System.out.println(now.getDayOfWeek());
    //        获取年中的第几天
    System.out.println(now.getDayOfYear());
    //       获取小时
    System.out.println(now.getHour());
    //       获取分
    System.out.println(now.getMinute());
    //       获取秒
    System.out.println(now.getSecond());
    //       获取纳秒
    System.out.println(now.getNano());
    //        修改年份为2019
    System.out.println(now.withYear(2019));
    //        修改月份为2
    System.out.println(now.withMonth(2));
    //        修改日期为3号
    System.out.println(now.withDayOfMonth(3));
    //      修改小时为12
    System.out.println(now.withHour(12));
    //       修改分钟为22
    System.out.println(now.withMinute(22));
    //        修改秒为33
    System.out.println(now.withSecond(33));
}
```

tip：

​	时间跟日期的修改都是返回一个新的日期时间对象，原来的日期时间对象不改变。



## 5.4 格式化

 可以通过`java.time.format.DateTimeFormatter`类可以进行日期时间的解析与格式化。

**代码演示**

```java
@Test
public void dateTime04(){
    //      日期转成格式化字符串
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
    String formatNow = now.format(dtf);
    System.out.println(formatNow);

    //       格式化字符串转成日期
    LocalDateTime parse = LocalDateTime.parse("2021年01月28日 04时14分43秒", dtf);
    System.out.println(parse);
}
```



## 5.5 日期时间差

​		JDK8中通过`Duration `用于计算两个“时间”间隔。通过`Period`用于计算两个“日期”间隔的类。

**Duration代码演示**

```java
@Test
public void dateTime05(){
    LocalTime now = LocalTime.now();
    System.out.println(now);
    LocalTime time = LocalTime.of(17,48,12);
    System.out.println(time);

    Duration duration = Duration.between(now,time);
    //      时间差转成小时
    System.out.println(duration.toHours());
    //      时间差转成分钟
    System.out.println(duration.toMinutes());
    //      时间差转成秒
    System.out.println(duration.getSeconds());
    //      时间差转成纳秒
    System.out.println(duration.toNanos());

}
```



**Period代码演示**

```java
@Test
public void dateTime06(){
    LocalDate now = LocalDate.now();
    LocalDate date = LocalDate.of(2030,4,30);
    Period period = Period.between(now,date);
    //      获取年份差
    System.out.println(period.getYears());
    //      获取月份差
    System.out.println(period.getMonths());
    //       获取日期差
    System.out.println(period.getDays());
}
```



## 5.6 时间校正器

​	有时候我们需要将日期或者时间进行校正，比如设置为“下个月的第1天”等，可以通过时间校正器进行。

- TemporalAdjuster：时间校正器。

- TemporalAdjusters：通过静态方法提供大量的常用的TemporalAdjuster实现。

  ```java
  @Test
  public void dateTime07(){
      LocalDateTime now = LocalDateTime.now();
      //      设置下月1号的校正器
      TemporalAdjuster firstDayOfNextMonth = temporal -> {
          LocalDateTime time = (LocalDateTime) temporal;
          return time.plusMonths(1).withDayOfMonth(1);
      };
      //      通过校正器调节now的值
      System.out.println(now.with(firstDayOfNextMonth));
  
      //       TemporalAdjusters获取下一年的第1天的校正器
      System.out.println(now.with(TemporalAdjusters.firstDayOfNextYear()));
  
  }
  ```




# 第6章 重复注解与类型注解

## 6.1 重复注解

自从JAVA5引入注解以来，注解开始变得非常流行，在各个框架中被广泛使用。但是有一个限制就是同一个地方同一个注解只能使用一次。JDK8引入了重复注解的机制，可以在一个地方同一个注解定义多次。

**代码演示**

```java
// 重复注解
@MyAnnotation("hello")
@MyAnnotation("world")
public class Demo12Annotation {

    public static void main(String[] args) {
        MyAnnotation[] annotations = Demo12.class.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation anno : annotations){
            System.out.println(anno.value());
        }
    }
}

//定义注解容器
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotations{
    MyAnnotation [] value() ;
}

// 定义注解内容
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyAnnotations.class)
@interface MyAnnotation{
    String  value() default  "blb" ;
}
```

tips:

- `getAnnotationsByType`是新的API，获取定义的所有的重复的注解。
- `@Repeatable`用来指定重复注解的容器



## 6.2 类型注解

​	JDK8为@`Target`元注解新增了2个枚举值：`TYPE_PARAMETER`、`TYPE_USE`。

`TYPE_PARAMETER`: 表示该注解能写在类型参数的声明语句中，也就是泛型。

`TYPE_USE`：表示注解可以写在任何用到类型的地方。

**代码演示**

```java
// 修饰泛型类
public class Demo13Annotation< @TypeParam T> {
//   在任意使用类型的地方使用，包括基本数据类型
    public @TypeUse  int i = 1 ;

    // 修饰泛型方法
    public < @TypeParam E> void testTypeParameter(){
        //   在任意使用类型的地方使用，包括局部变量
        @TypeUse int i ;
    }
}

//定义泛型为TYPE_USE
@Target(ElementType.TYPE_USE)
@interface TypeUse{
    String value() default "blb";
}

//定义泛型为TYPE_PARAMETER
@Target(ElementType.TYPE_PARAMETER)
@interface TypeParam{
    String value() default "blb";
}
```







