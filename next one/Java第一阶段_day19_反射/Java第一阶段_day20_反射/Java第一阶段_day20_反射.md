# 学习目标

```
1、掌握反射的概念
2、掌握3种获取Class的方式
3、掌握通过反射创建对象
4、掌握通过反射机使用属性
5、掌握通过反射使用方法
```



# 第1章 反射

## 1.1 概述

​	 JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意方法和属性；这种动态获取信息以及动态调用对象方法的功能称为Java语言的反射机制。

​	这里的反理解为反转，控制反转。假如我们需要零花钱就找老婆要，这是“正”。但是现在反过来是老婆主动给我们，这是“反”。虽然最后的结果都一样，都是老婆给我们零花钱，但是方式不一样。程序中以前创建对象是通过`new`来创建对象，自上而下。但是现在我们可以使用反射技术反过来自下而上的提供访问。反射相关的类都在`java.lang.reflect`包下。



- 优点 ：在程序运行时，对类和对象的信息进行解析、调用方法，极大地提高了灵活性。

- 缺点 ：由于需要动态解析类的信息，降低了程序性能。



## 1.2 Class类

​	面向对象的过程中，把对象的相同特征跟行为能力提取出来成为类，比如人类、桌子类、猫类、狗类……那这些类又具有什么相同的特征跟行为能力？是否可以继续往上抽取出来呢？答案是肯定的。所有的类可以继续抽象出`Class`类、所有的方法可以抽取为`Method`类、所有的字段抽取为`Filed`类等等。

​	通过`Class`、`Method`、 `Filed`等类的API间接创建、操作对象的方式称为反射机制。

​	使用反射机制首先要获取对应类的`Class`对象。获取`Class`对象有3种方式

> 方式1—通过类名

```java
Class clazz = Person.class ;
```



> 方式2—通过对象

```java
Class  clazz = new Person().getClass();
```



> 方式3—类路径的字符串

```java
Class  clazz = Class.forName("com.blb.Person");
```

**代码演示**

```java
class Person {

}

public class Demo01Reflect {

    public static void main(String[] args) throws ClassNotFoundException {
//      第1种方式：
        Class clazz = Person.class ;
//		第2种方式：
//		Class  clazz = Class.forName("com.blb.Person");
//		第3种方式：
//		Person p  = new Person();
//		Class clazz = p.getClass();

    }
}
```



## 1.3 创建对象

#### 1.3.1 无参构造	

>  方式1

可以通过`Class`对象的`newInstance`方法直接通过无参的构造方法创造对象。这种方式只能针对无参的构造方法使用。

**代码演示**

```java
Person  person = (Person) clazz.newInstance();
```



> 方式2

​	所有的构造方法也同样的映射成`Constructor`类型的对象，所以也可以使用`Constructor`对象的方式构建对象。

- `getConstructor`：获取所有的public类型构造器
- `getDeclaredConstructor` : 获取自身定义的所有构造器，包括`private`的构造器

**代码演示**

```java
//Constructor c = clazz.getConstructor();
Constructor c = clazz.getDeclaredConstructor();
// 通过newInstance方法创建构造器对应的对象
Person  person = (Person) c.newInstance();
```



#### 1.3.2 有参构造

​		带参数的构造器只能通过`Constructor`方式，由于构造器的参数个数跟类型都不是固定的，所以`getConstructor`跟`getDeclaredConstructor`方法的参数列表设计成可变参数类型。

**代码演示**

```java
class  User{

    private String name;

    private int age ;
    
// 构造方法是私有的
    private User(String name , int age ){
        this.name = name ;
        this.age = age ;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Demo02Reflect {

    public static void main(String[] args) throws Exception {
//      获取对应的Class对象
        Class clazz = User.class ;
//      获取想要的构造器,这里的参数列表的类型要跟定义的构造方法一致
        Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
//       由于构造方式是私有的，需要设置权限
        c.setAccessible(true);
//        通过对应的构造器创建对应的对象，这里的参数列表的值要跟构造方法的类型一致
        User user = (User) c.newInstance("blb", 18);
        System.out.println(user);
    }
}

```



## 1.4 属性

​		我们也可以通过API获取对应的属性，常用API如下：

- `Field[] getDeclaredFields() `： 获取当前类声明的所有属性，包括`private`的属性。
- `Field[] getFields() `： 获取当前类声明的所有的公共（public）属性，包括继承过来的。

- `Field getDeclaredField(String name) `： 获取当前类声明的某个属性，包括`private`的属性 。
- `Field getField(String name) `： 获取当前类声明的某个公共（public）属性，包括继承过来的 。



**代码演示**

```java
class  Student{

    private String name;

    private int age ;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Demo03Reflect {

    public static void main(String[] args) throws Exception {
//      获取对应的Class对象
        Class clazz = Student.class ;
//      获取对象
        Student s = (Student) clazz.newInstance();
//       获取当前类定义的所有的属性
        Field[] fields = clazz.getDeclaredFields();
//        遍历所有的属性
        for (Field f: fields) {
//          打印字段名称
            System.out.println(f.getName());
        }
//      获取属性名为name的属性
        Field nameField = clazz.getDeclaredField("name");
//      私有的属性需要打开访问权限
        nameField.setAccessible(true);
//      给对象s的name属性赋值为blb
        nameField.set(s,"blb");

        System.out.println(s);

    }
}
```

tips：

- 属性的赋值依赖于某个对象，表示给哪个对象的属性赋值。
- 操作私有的属性需要设置权限`setAccessible`



## 1.5 方法

​	我们也可以通过API获取对应的成员方法，常用API如下：
- `Method[] getDeclaredMethods()  `： 获取当前类声明的所有方法，包括`private`的方法。
- `Method[] getMethods() `： 获取当前类声明的所有的公共（public）方法，包括继承过来的。

- `Method getDeclaredMethod(String name, Class<?>... parameterTypes) `： 获取当前类声明的某个方法，包括`private`的方法 。
- `Method getMethod(String name, Class<?>... parameterTypes) `： 获取当前类声明的某个公共（public）方法，包括继承过来的 。



**代码演示**

```java
class  Student{

    public void study(){
        System.out.println("好好学习，天天向上。");
    }

    private int exam(String name){
        System.out.println(name+"同学，认真考试");
        int score = 90 ;
        return score ;
    }

}

public class Demo04Reflect {

    public static void main(String[] args) throws Exception {
//      获取对应的Class对象
        Class clazz = Student.class ;
//      获取对象
        Student s = (Student) clazz.newInstance();
//       获取当前类定义的所有的属性
        Method[] methods = clazz.getDeclaredMethods();

//        遍历所有的方法
        for (Method m: methods) {
//          打印方法名称
            System.out.println(m.getName());
        }

//      获取方法名为study的方法
        Method study = clazz.getDeclaredMethod("study");
//      通过invoke方法调用这个s对象的study方法
        study.invoke(s);

//      获取方法名为exam的方法,参数类型要一致
        Method exam = clazz.getDeclaredMethod("exam",String.class);
//      私有方法，必须要设置访问权限
        exam.setAccessible(true);
//      通过invoke方法调用这个s对象的exam方法，接收方法调用的结果
        Integer result = (Integer) exam.invoke(s,"blb");
        System.out.println("考试分数为： "+result);

    }
}
```

tips:

- 方法的调用依赖于某个对象，表示调用哪个对象方法。
- 调用私有的方法需要设置权限`setAccessible`



