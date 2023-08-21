# 学习目标

```
1、掌握String类的用法
2、掌握String类、StringBuffer类、StringBuilder类的区别
3、掌握基本类型跟包装类型的转换
4、掌握自动装箱跟自动拆箱的概念
5、掌握BigInteger类跟BigDecimal类的用法
6、了解DecimalFormat类的用法
7、掌握枚举的用法
```



# 第1章 String类

## 1.1 概述

​		基本数据类型`char`可以用来表示单个字符，但生活中跟项目中通常需要表示多个字符，使用`char`就显得力不从心。JDK提供了String类来达到我们的要求。

​		`java.lang.String`类的底层结构是`final char value[]`，所以String对象具有原内容不能变的特性。



## 1.2 String的获取

> 方式1

​	直接通过双引号的方式定义，这种定义方式的字符串是存在常量池中。常量池是给JAVA虚拟机运行时分配的一块空间，主要用来存放一些常量数据。

**代码演示**

```java
public static void main(String[] args) {
    String name = "haley";
}
```



> 方式2

​	通过new的方式定义，这种定义方式的字符串是存在堆内存中。

**代码演示**

```java
public static void main(String[] args) {
    String name =new String("haley") ;
}
```



## 1.3 常用API

- `public int length()`：返回此字符串的长度。

  **代码演示**

```java
        String name =new String("haley") ;
        System.out.println(name.length()); //长度为5
```



-  `public boolean equals(Object anObject) `：将此字符串与指定的对象比较。 

-  ` public boolean equalsIgnoreCase(String anotherString) `:将此 String 与另一个 String 比较，不考虑大小写。

   **代码演示**

```java
   public static void main(String[] args) {
        String name =new String("haley") ;
        System.out.println(name.equals("Haley")); //false
        System.out.println(name.equalsIgnoreCase("Haley")); //true
    }
```



- `public String toLowerCase()`:使用默认语言环境的规则将此 String 中的所有字符都转换为小写。
- `public String toUpperCase()`:使用默认语言环境的规则将此 String 中的所有字符都转换为大写。`

**代码演示**

```java
public static void main(String[] args) {
    String name =new String("Haley") ;
    System.out.println(name.toLowerCase()); //haley
    System.out.println(name.toUpperCase()); //HALEY
}
```



- `public String concat(String str)`: 将指定字符串连接到此字符串的结尾。

**代码演示**

```java
public static void main(String[] args) {
    String name =new String("hello ") ;
    System.out.println(name.concat("helay")); //hello helay
    System.out.println("hello "+"helay"); //hello helay
}
```

tips:  +号用在字符串时表示拼接，字符串跟任意类型拼接结果都为字符串。



- `public int indexOf(int ch) `:  返回指定字符在此字符串中第一次出现处的索引。

- `public int indexOf(String value)`: 返回指定子字符串在此字符串中第一次出现处的索引。
- `public int lastIndexOf(int ch) `: 返回指定字符在此字符串中最后一次出现处的索引。
- `public int lastIndexOf(String value)`: 返回指定子字符串在此字符串中最右边出现处的索引。

**代码演示**

```java
public static void main(String[] args) {
    String word ="hello , welcome to bailiban! ";
    //            返回字符97第一次出现的位置
    System.out.println(word.indexOf(97)); //20
    //            返回字符串ba第一次出现的位置
    System.out.println(word.indexOf("ba")); //19
    //            返回字符97最后一次出现的位置
    System.out.println(word.lastIndexOf(97)); //25
    //            返回字符串ba最后一次出现的位置
    System.out.println(word.lastIndexOf("ba")); //24
}
```

tips: 索引都是从0开始计算。



- `public String substring(int index)`: 返回一个新的字符串，它是此字符串的一个子字符串。该子字符串从指定索引处的字符开始，直到此字符串末尾。
- `public String substring(int beginindex,int endindex)`: 返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始，直到索引 endIndex-1 处的字符。因此，该子字符串的长度为 endIndex-beginIndex。 

**代码演示**

```java
@Test
public void testString01() {
    String word ="hello , welcome to bailiban! ";
    System.out.println(word.substring(8)); //welcome to bailiban!
    System.out.println(word.substring(8,15)); //welcome
}
```



- `public String trim()`: 返回字符串的副本，忽略前导空白和尾部空白。

**代码演示**

```java
@Test
public void testString02() {
    String word ="  hello  ";
    //去掉两端的空白字符
    System.out.println(word.trim()); //hello
}
```



- ` public String replace(CharSequence target,CharSequence replacement) `: 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。

**代码演示**

```java
@Test
public void testString03() {
    String word ="hello , welcome to bailiban! ";
    //hello子字符串替换为byebye
    System.out.println(word.replace("hello","byebye")); //byebye , welcome to bailiban!
}
```



- `public char charAt(int index)`: 返回指定索引处的 char 值。索引范围为从 0 到 length() - 1。

**代码演示**

```java
@Test
public void testString04() {
    String word ="hello , welcome to bailiban! ";
    //返回索引位置为4的内容
    System.out.println(word.charAt(4)); //o
}
```



- `public String[] split(String regex)`: 根据给定正则表达式的匹配拆分此字符串。

**代码演示**

```java
@Test
public void testString05() {
    String word ="welcome to bailiban! ";
    //以空格字符将字符串分割为数组
    String[] attr = word.split(" ");
    System.out.println(Arrays.toString(attr)); //[welcome, to, bailiban!]
}
```



# 第2章 StringBuffer与StringBuilder

## 2.1 概述

​		上面讲的`java.lang.String`类用来表示字符串，它是`final`类型，故原始内容不能变更。而`StringBuffer`跟`StringBuilder`又称为可变字符序列，它是一个类似于 String 的字符串缓冲区， 它们可以改变该序列的长度和内容。

​		`StringBuffer`跟`StringBuilder`区别主要在于`StringBuffer`是线程安全的，而`StringBuilder`是线程非安全的。2者的API几乎一样。StringBuffer与StringBuilder官方推荐使用StringBuilder



## 2.2 构造方法

​		常用构造方法有2个：

- `public StringBuilder()`： 构造一个其中不带字符的字符串缓冲区。
- `public StringBuilder(String str)`：构造一个字符串缓冲区，并将其内容初始化为指定的字符串内容。

**代码演示**

```java
@Test
public void testStringBuilder01() {
    StringBuilder sb = new StringBuilder();
    System.out.println(sb);// 空白
    StringBuilder sb2 = new StringBuilder("bailiban");
    System.out.println(sb2);// bailiban
}
```



## 2.3 常用方法

- append方法

  append方法具有多种重载形式，可以接收任意类型的参数。任何数据作为参数都会将对应的字符串内容添加到StringBuilder中。

**代码演示**

```java
@Test
public void testStringBuilder02() {
    StringBuilder sb = new StringBuilder();
    sb = sb.append("hello ").append(" welcome ").append(" to ").append(" bailiban ");
    System.out.println(sb);// hello  welcome  to  bailiban
}
```



- `public StringBuffer reverse()`:  将字符串内容进行反转。

**代码演示**

```java
@Test
public void testStringBuilder03() {
    StringBuilder sb = new StringBuilder("bailiban");
    System.out.println(sb.reverse());// nabiliab
}
```

tips:  这个方法是`String`类所没有的，其它API方法参考`String`类。



# 第3章 包装类

## 3.1 概述

​		JDK提供了8中基本数据类型，很多时候基本数据类型存在很多限制，不像引用类型那样提供很多API给我们使用，故JAVA为我们提供了8中基本数据类型对应的引用类型，我们称为包装类。

| 基本类型 | 对应的包装类  |
| -------- | ------------- |
| byte     | Byte          |
| short    | Short         |
| int      | **Integer**   |
| long     | Long          |
| float    | Float         |
| double   | Double        |
| char     | **Character** |
| boolean  | Boolean       |

​		这些包装类都位于`java.lang`包下，基本数据类型跟对应的包装类型可以自动相互转换，称为自动装箱跟自动拆箱。

* **自动装箱**：从基本类型转换为对应的包装类对象。

* **自动拆箱**：从包装类对象转换为对应的基本类型。



**装箱代码演示**

```java
 @Test
public void testInteger01(){
    //将基本类型的1自动装箱为包装类Integer
    Integer i = 1 ;
    System.out.println(i);//1
}
```

**拆箱代码演示**

```java
@Test
public void testInteger02(){
    //定义包装类对象i
    Integer i = new Integer(1) ;
    //将包装类拆箱成基本类型int
    int i2 = i ;
    System.out.println(i2);// 1
}
```





## 3.2 常用API

​		8种包装类的用法类似，这里用`Integer`为例。



#### 3.2.1 字符串转成进本类型

​	除了Character类之外，其他包装类都具有parseXXX静态方法用来将字符串参数转换为对应的基本类型：

- `public static byte parseByte(String s)`：将字符串参数转换为对应的byte基本类型。
- `public static short parseShort(String s)`：将字符串参数转换为对应的short基本类型。
- `public static int parseInt(String s)`：将字符串参数转换为对应的int基本类型。
- `public static long parseLong(String s)`：将字符串参数转换为对应的long基本类型。
- `public static float parseFloat(String s)`：将字符串参数转换为对应的float基本类型。
- `public static double parseDouble(String s)`：将字符串参数转换为对应的double基本类型。
- `public static boolean parseBoolean(String s)`：将字符串参数转换为对应的boolean基本类型。



**代码演示**

```java
 @Test
public void testInteger03(){
    // 将字符串类型转成对应的基本类型
    int i = Integer.parseInt("99");
    System.out.println(i);
}
```

tips: 如果转换异常会抛出`NumberFormatException`异常。



#### 3.2.2 包装类转成基本类型

​	包装类转成基本类型除了使用自动拆箱的方式外还可以通过类似XxxValue等方法实现。以Integer为例：



- `public byte byteValue()`:  以byte 类型返回该 Integer 的值。
- `public short shortValue()`: 以 short 类型返回该 Integer 的值。  
- `public int intValue()`: 以 int 类型返回该 Integer 的值。 
- `public long longValue()`: 以 long 类型返回该 Integer 的值。 
- `public float floatValue()`: 以 float 类型返回该 Integer 的值。 
- `public double doubleValue()`: 以 double 类型返回该 Integer 的值。 



**代码演示**

```java
@Test
public void testInteger04(){
    Integer it = new Integer(100);
    // 将包装类转成基本类型
    int i = it.intValue();
    System.out.println(i);
}
```



#### 3.2.3 进制的转换

 	Integer还提供一些API可以将整型类型转成其它进制的表示形式。

- `public static String toBinaryString(int i)`: 以二进制（基数 2）无符号整数形式返回一个整数参数的字符串表示形式。
- `public static String toOctalString(int i)`: 以八进制（基数 8）无符号整数形式返回一个整数参数的字符串表示形式。
- `public static String toHexString(int i)`: 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式。 

**代码演示**

```java
public static void main(String[] args) {
    //          获取36的2进制的表示形式
    System.out.println( Integer.toBinaryString(36));
    //          获取36的8进制的表示形式
    System.out.println( Integer.toOctalString(36));
    //          获取36的16进制的表示形式            
    System.out.println( Integer.toHexString(36));
}
```



# 第4章 BigInteger类

  	整型的基本数据最大范围的是long，如果需要超过long类型的范围则需要使用`BigInteger`类。为了提高自动装箱的效率，Integer类的内部提供了一个自动装箱池，将-128到127之间的整数装箱完毕并放入池中，当程序中出现该范围的数据时则直接从池中获取并使用。

​     `BigInteger`类在`java.math`包下。



## 4.1 构造方法

- `public BigInteger(String val)`: 将 BigInteger 的十进制字符串表示形式转换为 BigInteger。

  重载了很多不同参数类型的构造方法，常用的是字符串类型的参数。

**代码演示**

```java
@Test
public void testBigInteger01(){
    BigInteger bi = new BigInteger("9999999999999999999999999999999999999");
    System.out.println(bi);
}
```



##  4.2 成员方法

​		由于不是基本数据类型，不能通过`+ - * /`进行运算，只能通过成分方法实现。

​	

- `public BigInteger add(BigInteger val)`: 返回其值为 (this + val) 的 BigInteger。 

**代码演示**

```java
@Test
public void testBigInteger02(){
    BigInteger b1 = new BigInteger("99999999999999999999999999999999999999999");
    BigInteger b2 = new BigInteger("99999999999999999999999999999999999999999");
    // 将2个BigInteger进行相加运算
    System.out.println(b1.add(b2));
}
```



- `public BigInteger subtract(BigInteger val)`: 返回其值为 (this - val) 的 BigInteger。 

**代码演示**

```java
@Test
public void testBigInteger03(){
    BigInteger b1 = new BigInteger("999999999999999999999999999999999999999999999");
    BigInteger b2 = new BigInteger("111111111111111111111111111111111111111111111");
    // 将2个BigInteger进行相减运算
    System.out.println(b1.subtract(b2));
}
```



- `public BigInteger multiply(BigInteger val)`:返回其值为 (this * val) 的 BigInteger。 

**代码演示**

```java
 @Test
public void testBigInteger04(){
    BigInteger b1 = new BigInteger("999999999999999999999999999999999999999999999");
    BigInteger b2 = new BigInteger("111111111111111111111111111111111111111111111");
    // 将2个BigInteger进行相乘运算
    System.out.println(b1.multiply(b2));
}
```



- `public BigInteger divide(BigInteger val)`: 返回其值为 (this / val) 的 BigInteger。 

**代码演示**

```java
@Test
public void testBigInteger05(){
    BigInteger b1 = new BigInteger("999999999999999999999999999999999999999999999");
    BigInteger b2 = new BigInteger("111111111111111111111111111111111111111111111");
    // 将2个BigInteger进行相乘运算
    System.out.println(b1.divide(b2)); // 9
}
```



# 第5章 BigDecimal类

​	前面讲过小数不能进行精确的算术运算，比如

```java
public static void main(String[] args) {
    System.out.println(0.1 + 0.2); //0.30000000000000004
}
```

​	结果并不是我们期待的0.3，而是0.30000000000000004，这是由于计算机是2进制，无法对小数进行精确的算术运算。那对某些业务比如金融需要对小数进行算术运算该怎么办呢？BigDecimal类可以解决这个问题。

​     `BigDecimal`类在`java.math`包下。



## 4.1 构造方法

- `public BigDecimal(String val)`: 将 BigDecimal 的字符串表示形式转换为 BigDecimal。

  重载了很多不同参数类型的构造方法，常用的是字符串类型的参数。

**代码演示**

```java
public static void main(String[] args) {
    BigDecimal bd1 = new BigDecimal("0.123456789"); 
}
```



##  4.2 成员方法

​		由于不是基本数据类型，不能通过`+ - * /`进行运算，只能通过成分方法实现。

​	

- `public BigDecimal add(BigDecimal augend)`: 返回一个 BigDecimal，其值为 (this + augend)。其标度为 max(this.scale(), augend.scale())。  

**代码演示**

```java
@Test
public void testBigDecimal02(){
    BigDecimal bd1 = new BigDecimal("0.1");
    BigDecimal bd2 = new BigDecimal("0.2");
    // 对2个小数进行相加运算
    System.out.println(bd1.add(bd2));
}
```



- `public BigDecimal subtract(BigDecimal subtrahend)`: 返回一个 BigDecimal，其值为 (this - subtrahend)，其标度为max(this.scale(), subtrahend.scale())。  

**代码演示**

```java
@Test
public void testBigDecimal03(){
    BigDecimal bd1 = new BigDecimal("0.1");
    BigDecimal bd2 = new BigDecimal("0.2");
    //          对2个小数进行相减运算
    System.out.println(bd2.subtract(bd1));
}
```



- `public BigDecimal multiply(BigDecimal multiplicand)`:返回一个 BigDecimal，其值为 (this × multiplicand)，其标度为(this.scale() + multiplicand.scale())。  

**代码演示**

```java
public static void main(String[] args) {
    BigDecimal bd1 = new BigDecimal("0.1");
    BigDecimal bd2 = new BigDecimal("0.2");
    //          对2个小数进行相乘运算
    System.out.println(bd2.multiply(bd1));
}
```



- `public BigDecimal divide(BigDecimal divisor)`: 返回一个 BigDecimal，其值为 (this / divisor)，其首选标度为 (this.scale() divisor.scale())；如果无法表示准确的商值（因为它有无穷的十进制扩展），则抛出ArithmeticException。

     

- public BigDecimal divide(BigDecimal divisor,   int scale, int  roundingMode)： 返回一个 BigDecimal，其值为 (this / divisor)，其标度为指定标度。如果必须执行舍入，以生成具有指定标度的结果，则应用指定的舍入模式。  

     

- 

**代码演示**

```java
public static void main(String[] args) {
    BigDecimal bd1 = new BigDecimal("0.33");
    BigDecimal bd2 = new BigDecimal("0.11");
    // 对2个小数进行相除运算，如果除不尽则报错
    System.out.println(bd1.divide(bd2));
    //  对2个小数进行相除运算，如果除不尽则保留3位小数位,末尾采取四舍五入的方式
    System.out.println(bd2.divide(bd1,3,BigDecimal.ROUND_HALF_UP));
}
```

**常用的舍入模式**

- `BigDecimal.ROUND_UP`: 始终进位。
- `BigDecimal.ROUND_DOWN`: 始终舍弃。
- `BigDecimal.ROUND_HALF_UP`: 四舍五入模式，如果是5则入。
- `BigDecimal.ROUND_HALF_DOWN`: 四舍五入模式，如果是5则舍。



# 第6章 DecimalFormat类

​	`java.text.DecimalFormat`是 `NumberFormat` 的一个具体子类，用于格式化十进制数字。该类设计有各种功能，使其能够解析和格式化任意语言环境中的数，包括对西方语言、阿拉伯语和印度语数字的支持。它还支持不同类型的数，包括整数 (123)、定点数 (123.4)、科学记数法表示的数 (1.23E4)、百分数 (12%) 和金额 ($123)。所有这些内容都可以本地化。 

​	用法比较简单，这里举些实例。

**代码演示**

```java
public static void main(String[] args) {
    double pi = Math.PI;//圆周率
    //取一位整数
    System.out.println(new DecimalFormat("0").format(pi));//3
    //取一位整数和两位小数
    System.out.println(new DecimalFormat("0.00").format(pi));//3.14
    //取两位整数和三位小数，整数不足部分以0填补。
    System.out.println(new DecimalFormat("00.000").format(pi));// 03.142
    //取所有整数部分
    System.out.println(new DecimalFormat("#").format(pi));//3
    //以百分比方式计数，并取两位小数
    System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%

    long c =299792458;//光速
    //显示为科学计数法，并取五位小数
    System.out.println(new DecimalFormat("#.#####E0").format(c));//2.99792E8
    //显示为两位整数的科学计数法，并取四位小数
    System.out.println(new DecimalFormat("00.####E0").format(c));//29.9792E7
    //每三位以逗号进行分隔。
    System.out.println(new DecimalFormat(",###").format(c));//299,792,458
    //将格式嵌入文本
    System.out.println(new DecimalFormat("光速大小为每秒,###米。").format(c));
}
```



# 第7章 Enum类

## 7.1 概述

​		在开发过程中我们经常需要用到一系列有限对象个数的数据，比如星期只有周一到周日，月份只有1月到12月等等 。在JDK1.5之前主要通过一系列的静态常量完成。但是问题是这种用法操作麻烦，在1.5之后提供枚举类型来实现。



## 7.2 枚举的使用

- 语法定义

  ```
  enum 枚举名称{
      枚举常量,枚举常量,枚举常量....
  }
  ```

  **代码演示**

  ```java
  public enum Genders {
      MALE , FEMALE ;
  }
  ```

  tips: MALE跟FEMALE不需要指定类型，默认为当前Genders类型。



- 枚举的使用

  ```
  枚举名称 变量 = 枚举名称.常量;
  ```

  **代码演示**

  ```java
  @Test
  public void testEnum01(){
      Genders person = Genders.MALE ;
      System.out.println(person);
  }
```
  

  
​	枚举中除了可以定义枚举值以外，还可以定义其它一个类可以定义的所有内容，比如属性、构造方法、成员方法等等。使用起来简单方便，但同时也需要遵守相关规则：
  
- 枚举是有构造方法的，默认且必须是private修饰的无参构造方法
  
- 构造方法可以进行重载，如果定义了构造方法则不会默认创建
  
- 枚举默认继承Enum类，故不能再继承其它类
  
- 枚举可以实现其它接口
  
- 枚举值的定义必须在最前面
  
    

## 7.3 常用API

​		由于枚举都默认继承Enum类，故所有的枚举都可以使用Enum类中的方法。

- `public final String name()`: 回此枚举常量的名称，在其枚举声明中对其进行声明。 
- `public final int ordinal()`: 返回枚举常量的序数，从0开始。
- `  valueOf (Class<T> enumType, String name)`  ： 返回带指定名称的指定枚举类型的枚举常量。



**代码演示**

```java
 @Test
public void testEnum02(){
    Genders person = Genders.FEMALE ;
    System.out.println(person.name());//FEMALE
    System.out.println(person.ordinal());//1

    Genders p1 = Enum.valueOf(Genders.class, "MALE");
    System.out.println(p1.name());//MALE
    System.out.println(p1.ordinal());//0
}
```



## 7.4 枚举在switch中的使用

​	枚举可以跟switch结合使用，此时枚举类型可以不写。

**代码演示**

```java
enum Weeks {
    //七个星期常量
    MON,TUE,WES,THU,FRI,SAT,SUN
}

public class Demo09Enum02 {

    @Test
    public void testWeek(){
        //定义枚举变量并赋值
        Weeks week = Weeks.SAT;
        //使用switch判断枚举变量
        switch(week){
            case MON:
                System.out.println("星期一吃鱼香茄子");
                break;
            case TUE:
                System.out.println("星期二吃蛋炒饭");
                break;
            case WES:
                System.out.println("星期三吃小牛肉");
                break;
            case THU:
                System.out.println("星期四吃热干面");
                break;
            case FRI:
                System.out.println("星期五吃黄焖鸡");
                break;
            case SAT:
                System.out.println("星期六吃泡面");
                break;
            case SUN:
                System.out.println("星期天吃青椒肉丝");
                break;
        }
    }
    
}
```








































