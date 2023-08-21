# 学习目标

```
1、掌握Object类的相关用法
2、掌握==跟equals的区别
3、掌握Math类的常用方法
3、掌握Random类的基本方法 
4、掌握日期类和字符串类的转换方式
5、掌握日期和日历类的转换方式
```



# 第1章 Object类

## 1.1 概述

​	`java.lang.Object`在Java中是万类之祖，即所有类的父类。Java中的继承是单继承的，如果一个类没有定义任何父类则这个类默认继承`java.lang.Object`，故其中定义的方法可以被任意引用类型使用，前提是拥有足够的权限。

​	根据JDK的API文档，我们可以发现Object类当中包含的方法有11个。今天我们主要学习其中的2个：

- `public String toString()`：返回该对象的字符串表示。
- `public boolean equals(Object obj)` ：指示其他某个对象是否与此对象“相等”。
- `protected native Object clone()` ： 创建并返回此对象的一个副本。
- `protected void finalize()`： 当垃圾回收器确定不存在对该对象的更多引用时，由对象的垃圾回收器调用此方法。




## 1.2 toString方法

​	当我们在直接输出打印一个引用类型的对象时发现输出结果为"类型+@+内存地址值"。这个结果其实就是调用了这个对象的toString方法的结果。我们可以通过Object的toString源码得到验证：

```java
public String toString() {
     return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

​	由于toString方法返回的结果是内存地址，而在实际开发中，我们更多的是需要显示对象的属性特征，故我们一般都会重写这个方法。

```java
public class Person {  
    
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
 
}
```

​	在IntelliJ IDEA中，可以点击`Code`菜单中的`Generate...`，也可以使用快捷键`alt+insert`，点击`toString()`选项来快速生成这个方法的重写。



## 1.3 equals方法

 		`equals`方法指示其他某个对象是否与此对象“相等”。这个“相等”用上引号是以为它并不是数学意义上的相等，而是业务逻辑中的逻辑意义上的"相等"，其判断的结果应该由我们业务逻辑来确定。

​		但Ojbect类并不知道其子类需要定义什么业务逻辑，故在Object中的默认实现逻辑就是判断是否是同一个对象，等效于`==`，一般我们会根据业务逻辑来重写。

​		由于我们经常需要重写这个方法，我们可以通过`Code`菜单中的`Generate...`，也可以使用快捷键`alt+insert`，点击`equals()`选项来快速生成这个方法的重写。

​		假设我们定义人的姓名相同的2个Person对象就相等，否则就不相等。

```java
public class Person {
// 姓名
    private String name;
// 年龄
    private int age;

    @Override
    public boolean equals(Object o) {
//        如果要比较的2个对象是同一个对象，则直接返回true
        if (this == o) return true;
//        如果要比较的2个对象的类型不一致，则直接返回false
        if (!(o instanceof Person)) return false;
//        将要比较的对象转成当前类型，并比较姓名是否相同
        Person person = (Person) o;
        return name.equals(person.name);
    }
}
```

​	`hashcode`方法通常需要跟`equals`方法一起重写，作用跟用法我们今后学习。



## 1.4 clone方法

​		此方法创建并返回当前对象的一个副本。clone的对象跟母体拥有相同的属性值，是另一种创建对象的方式。Object中的此方法是`protected`，故我们需要在子类中重写，将访问权限提升至`public`。

​		所有想使用clone方法的类都需要实现标识接口`java.lang.Cloneable`。

```java
// 需要实现Cloneable接口。
public class Person implements Cloneable {
// 姓名
    private String name;
// 年龄
    private int age;

    // setter and getter


    // 访问权限提升为public，逻辑使用父类的逻辑即可。
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```



## 1.5 finalize方法

​		`finalize`方法是一个回调方法，不是我们主动调用，是由虚拟机在回收对象时会自动调用这个方法逻辑。如果我们需要在回收前做一些比如释放资源等操作，则可以重写此方法。

​		我们一般不需要重写此方法，只需了解其调用的时机，会出现在面试题中。



# 第2章 Math类

## 2.1 概述

​	`Math` 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。 `math`中的所有方法都为`static`类型的，故我们只需通过`Math`类来使用这些方法，而不需要先创建对象。

​	此类大部分方法都属于数学领域的，我们一般只需用到其中比较常用的方法：

- `static double PI` ： 比任何其他值都更接近 *pi*（即圆的周长与直径之比）的 `double` 值。

- `static double abs(double a)`：返回 `double` 值的绝对值。

- `static float abs(float a)`：返回 `double` 值的绝对值。

- `static int abs(int a)`：返回 `double` 值的绝对值。

- `static long abs(long a)`：返回 `double` 值的绝对值。

- `static double ceil(double a)`： 返回最小的（最接近负无穷大）`double` 值，该值大于等于参数，并等于某个整数。

- `static double floor(double a)`： 返回最大的（最接近正无穷大）`double` 值，该值小于等于参数，并等于某个整数。

- `static long round(double a)`： 返回最接近参数的 `long`。

- `static int round(float a)`： 返回最接近参数的 `int`。

- `static long pow(double a, double b)`： 返回第一个参数的第二个参数次幂的值。

- `static double random()`： 返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。

  

## 2.2 API

​	`Math` 类中的方法都比较简单，我们一起看下其使用方法：

```java
   public static void main(String[] args) {
        System.out.println(Math.PI);//3.141592653589793
        System.out.println(Math.abs(-3.5));//3.5
        System.out.println(Math.ceil(-3.5));//-3.0
        System.out.println(Math.floor(3.5));//3.0
        System.out.println(Math.round(3.5));//4
        System.out.println(Math.round(-3.5));//-3
        System.out.println(Math.pow(3,4));//81.0
        System.out.println(Math.random());// [0.0-1.0)之间的随机值
    }
```



# 第3章 Random类

## 3.1 概述

​		当我们在完成类似小游戏之类的程序时经常需要用到随机数的知识，我们可以使用Random类来实现。Random类的实例用于生成伪随机数流。由于实例是通过算法算出来的，并不是真正意义上的随机，故称为伪随机。而算法依赖一个随机种子。

​		如果有2个随机种子相同的Random实例，其每次随机出来的数字都相同。

构造器：

- `public Random()`：创建一个新的随机数生成器。
- `public Random(long seed)`：使用单个 long 种子创建一个新的随机数生成器。

成员方法：

- `public double nextDouble()`： 返回下一个伪随机数，它是取自此随机数生成器序列的、在 `0.0` 和 `1.0` 之间均匀分布的  `double` 值。
- `public float nextFloat()`： 返回下一个伪随机数，它是取自此随机数生成器序列的、在 `0.0` 和 `1.0` 之间均匀分布的  `float` 值。
- `public int nextInt()`： 返回下一个伪随机数，它是此随机数生成器的序列中均匀分布的 `int` 值。
- `public int nextInt(int n)`： 返回一个伪随机数，它是取自此随机数生成器序列的、在 0（包括）和指定值（不包括）之间均匀分布的 `int` 值。
- `public long nextLong()`： 返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的 `long` 值。



## 3.2 API

​	`Random` 类中的方法都比较简单，我们一起看下其使用方法：

```java
public static void main(String[] args) {
//        创建一个随机对象
        Random random = new Random() ;
//        生成一个随机的int整数
        System.out.println(random.nextInt());
//        随机生成一个[0,10)范围内的随机数
        System.out.println(random.nextInt(10));
//        随机生成一个float类型的值
        System.out.println(random.nextFloat());
//        随机生成一个double类型的值
        System.out.println(random.nextDouble());
//        随机生成一个long类型的值
        System.out.println(random.nextLong());
//        随机生成一个boolean类型的值
        System.out.println(random.nextBoolean());
}
```



# 第4章 日期时间类

## 4.1 Date类

### 4.1.1 概述

​	项目中经常需要使用到日期跟时间的表示，JDK为我们提供了Date类来满足项目中的需要。虽然Date类中的很多方法都已经过时，但由于使用简单方便，我们仍然经常使用。

​	` java.util.Date`类 表示特定的瞬间，精确到毫秒。

常用构造器：

- `public Date()`：分配Date对象并初始化此对象，以表示分配它的时间（精确到毫秒）。`
- `public Date(long date)`：分配Date对象并初始化此对象，以表示自从标准基准时间（称为“历元（epoch）”，即1970年1月1日00:00:00 GMT）以来的指定毫秒数。

常用方法：

-  `public void setTime(long time)`：设置此 Date 对象，以表示 1970 年 1 月 1 日 00:00:00 GMT 以后 time 毫秒的时间点。

-  `public long getTime()`：返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。 



### 4.1.2 API

```java
    public static void main(String[] args) {
//      创建当前时间对应的Date对象
        Date date = new Date();
//      使用Date中重写的toString的格式显示日期
        System.out.println(date); // Mon Dec 28 14:29:39 CST 2020
//      自从标准基准时间之间的毫秒数
        System.out.println(date.getTime());//  1609137137133

        
//		创建日期对象，把当前的毫秒值转成日期对象
        Date date2 = new Date(0);
        System.out.println(date2); // Thu Jan 01 08:00:00 CST 1970
    }
```

tips: 由于我们处于东8区，所以我们的基准时间为1970年1月1日8时0分0秒。



## 4.2 SimpleDateFormat类

### 4.2.1 概述

​	`java.text.DateFormat` 是日期/时间格式化子类的抽象类，我们通过这个类可以帮我们完成日期和文本之间的转换,也就是可以在Date对象与String对象之间进行来回转换。这里DateFormat是抽象类，故实际中我们使用它的子类`java.text.SimpleDateFormat`。

​	实际开发中我们经常使用的时间是字符串形式，故需要经常将时间在字符串跟Date类型之间转换，把字符串形式的时间转成Date类型称为**解析**，把Date类型转为字符串类型成为**格式化**。

**常用构造器：**

- ​	`public SimpleDateFormat(String pattern)`：用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat。

  ​	参数pattern是一个字符串，代表日期时间的自定义格式。

**格式规则:**

| 标识字母（区分大小写） | 含义 |
| ---------------------- | ---- |
| y                      | 年   |
| M                      | 月   |
| d                      | 日   |
| H                      | 时   |
| m                      | 分   |
| s                      | 秒   |

tips ：更详细的格式规则，可以参考SimpleDateFormat类的API文档。



**常用方法：**

- `public String format(Date date)`：将Date对象格式化为字符串。
- `public Date parse(String source)`：将字符串解析为Date对象。



### 4.2.2 API

- 将Date对象转换成自定义的格式输出。

```java
    public static void main(String[] args) throws ParseException {
    //	定义当前时间点对应的Date对象    
        Date date = new Date();    
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
      //将日期Date格式化输出
        String dateString = format.format(date);
        System.out.println(dateString);//2020-12-28 14:57:18
 
    }
```



- 将字符串格式的日期转成Date类型

```java
    public static void main(String[] args) throws ParseException {     
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        //字符串类型的日期
        String d = "20-12-28 14:55:05";
        // 字符串类型的日期转成Date对象
        Date date = format.parse(d);
        System.out.println(date);//Sat Dec 28 14:55:05 CST 20
    }
```



## 4.3 Calendar类

### 4.3.1 概述

 上面讲解的Date类的大多数方法已经过时，JDK为我们推荐使用的Calendar类，此类表示日历。该类将所有可能用到的时间信息封装为静态成员变量，方便获取。日历类就是方便获取各个时间属性的。



### 4.3.2  Calendar的获取

​	由于Calendar类是一个抽象类，不能直接通过new来获取对象。我们需要通过其静态方法`getInstance`来获取其对象类。

* `public static Calendar getInstance()`：使用默认时区和语言环境获得一个日历。

  ```java
  import java.util.Calendar;
  
  public class CalendarDemo {
      public static void main(String[] args) {
          Calendar cal = Calendar.getInstance();
      }    
  }
  ```

  

### 4.3.3 API

- `public int get(int field)`：返回给定日历字段的值。

  Calendar类中提供很多成员常量，代表给定的日历字段：

  | 字段值       | 含义                                  |
  | ------------ | ------------------------------------- |
  | YEAR         | 年                                    |
  | MONTH        | 月（从0开始，可以+1使用）             |
  | DAY_OF_MONTH | 月中的天（几号）                      |
  | HOUR         | 时（12小时制）                        |
  | HOUR_OF_DAY  | 时（24小时制）                        |
  | MINUTE       | 分                                    |
  | SECOND       | 秒                                    |
  | DAY_OF_WEEK  | 周中的天（周几，周日为1，可以-1使用） |

**代码演示**

```java
    public static void main(String[] args) {
//        创建当前时间对应的日历类
        Calendar cal = Calendar.getInstance();
//        获取日历类中的年份
        System.out.println(cal.get(Calendar.YEAR));//2020
//        获取日历类中的月份
        System.out.println(cal.get(Calendar.MONTH));//11
//        获取日历类中的几号
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));//28
//        获取日历类中的小时，12小时制
        System.out.println(cal.get(Calendar.HOUR));//3
//        获取日历类中的小时，24小时制
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));// 15
 //         获取日历类中的分
        System.out.println(cal.get(Calendar.MINUTE));//31
 //         获取日历类中的秒
        System.out.println(cal.get(Calendar.SECOND));// 36
//         获取日历类中的星期
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));//2
    }
```



- `public void set(int field, int value)`：将给定的日历字段设置为给定值。

**代码演示**

```java
   public static void main(String[] args) {
//        创建当前时间对应的日历类
        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR,2012);
        cal.set(Calendar.MONTH,11);
        cal.set(Calendar.DAY_OF_MONTH,12);
        System.out.println(cal.get(Calendar.YEAR)+"年 "+(cal.get(Calendar.MONTH)+1)+"月 "+cal.get(Calendar.DAY_OF_MONTH)+"日");
       // 2012年 12月 12日

    }
```

tips: 月份从0开始，故显示时需要+1。星期是从周日开始。



- `public abstract void add(int field, int amount)`：根据日历的规则，为给定的日历字段添加或减去指定的时间量。

**代码演示**

```java
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DAY_OF_MONTH) + "日"); // 2018年1月17日
//      2020年12月28日

        // 使用add方法，将日增加1
        cal.add(Calendar.DAY_OF_MONTH, 1);
        // 使用add方法，将年份减去9
        cal.add(Calendar.YEAR, -9);
        System.out.println(cal.get(Calendar.YEAR) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DAY_OF_MONTH) + "日"); // 2018年1月17日
//      2011年12月29日
    }
```



- `public final Date getTime()`: 返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量）的 
  Date 对象。 
- `public final void setTime(Date date)`: 使用给定的 Date 设置此 Calendar 的时间。 

**代码演示**

```java
// 将日历类对象转成Date对象
public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    Date date = cal.getTime();
    System.out.println(date); // Tue Jan 16 16:03:09 CST 2018
}
```

```java
// 将Date对象转成日历类对象
public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date();
        cal.setTime(date);
        System.out.println(cal);  
    }
```










































































