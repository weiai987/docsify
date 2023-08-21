# 学习目标

```
1、了解算法的作用跟特征
2、掌握冒泡排序的使用
3、掌握选择排序的使用
4、掌握插入排序的使用
5、掌握快速排序的使用
6、掌握二分查找的使用
```



# 第1章 算法

## 1.1 概述

​		算法是规则的有限集合，为解决特定问题而规定的一系列操作。

​		在Java中，算法通常都是由类的方法来实现的。前面的数据结构，比如链表为啥插入、删除快，而  查找慢，平衡的二叉树插入、删除、查找都快，这都是实现这些数据结构的算法所造成的。后面我们讲  的各种排序实现也是算法范畴的重要领域。	



## 1.2 算法的特征

- 有穷性：有限步骤内正常结束，不能无限循环。
- 确定性：每个步骤都必须有确定的含义，无歧义。
- 可行性：原则上能精确进行，操作能通过有限次完成。
- 输入：有0或多个输入。
- 输出：至少有一个输出


## 1.3 数组的排序

​		JAVA中比较常用的算法有数组的排序，排序的算法有很多，常见的有冒泡排序、选择排序、插入排序、快速排序等。



### 1.3.1 冒泡排序

​	这个名词的由来很好理解，一般河水中的冒泡，水底刚冒出来的时候是比较小的，随着慢慢向水面  浮起会逐渐增大，这物理规律我不作过多解释，大家只需要了解即可。

冒泡算法的运作规律如下：

①、比较相邻的元素。如果第一个比第二个大，就交换他们两个。

②、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素  会是最大的数（也就是第一波冒泡完成）。

③、针对所有的元素重复以上的步骤，除了最后一个。

④、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

![冒泡排序](assets/冒泡排序.gif)

**代码实现**

```java
//冒泡排序
public class BubbleSort {

    public static void sort(int[] array) {
        // 这里for循环表示总共需要比较多少轮
        for (int i = 1; i < array.length; i++) {
            // 这里for循环表示每轮比较参与的元素下标
            // 对当前无序区间array[0 length-i]进行排序
            // j的范围很关键，这个范围是在逐步缩小的,因为每轮比较都会将最大的放在右边
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 4, 2, 8, 9, 5, 7, 6, 1, 3 };
        // 未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        System.out.println(Arrays.toString(array));

        sort(array);
        System.out.println("经过冒泡排序后的数组顺序为：");
        System.out.println(Arrays.toString(array));
    }
}

```



### 1.3.2 选择排序

选择排序是每一次从待排序的数据元素中选出最小的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。

分为三步：

①、从待排序序列中，找到关键字最小的元素

②、如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换

③、从余下的 N - 1 个元素中，找出关键字最小的元素，重复(1)、(2)步，直到排序结束。

![选择排序](assets/选择排序.gif)

**代码实现**

```java
/ 选择排序
public class ChoiceSort {

    public static void sort(int[] array) {
        // 总共要经过N-1轮比较
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            // 每轮需要比较的次数
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;// 记录目前能找到的最小值元素的下标
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] array = { 4, 2, 8, 9, 5, 7, 6, 1, 3};
        // 未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        System.out.println(Arrays.toString(array));

        sort(array);
        System.out.println("经过选择排序后的数组顺序为：");
        System.out.println(Arrays.toString(array));
    }
}

```



### 1.3.3 插入排序

​		直接插入排序基本思想是每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直  到插完所有元素为止。

​		插入排序还分为直接插入排序、二分插入排序、链表插入排序、希尔排序等等，这里我们只是以直接插入排序为例。

![插入排序](assets/插入排序.gif)

**代码实现**

```java
//插入排序
public class InsertSort {

    public static int[] sort(int[] array) {
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];// 记录要插入的数据
            int j = i;
            while (j > 0 && array[j - 1]>tmp) {
                array[j] = array[j - 1];
                // 向后挪动
                j--;
            }
            array[j] = tmp;// 存在比其小的数，插入
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = { 4, 2, 8, 1, 3};
        // 未排序数组顺序为
        System.out.println("未排序数组顺序为：");
        System.out.println(Arrays.toString(array));

        sort(array);

        System.out.println("经过插入排序后的数组顺序为：");
        System.out.println(Arrays.toString(array));
    }

}
```



### 1.3.4 快速排序

​	快速排序是对冒泡排序的一种改进，该方法的基本思想是：

1．先从数列中取出一个数作为基准数。

2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。

3．再对左右区间重复第二步，直到各区间只有一个数。

 ![快速排序](assets/快速排序.gif)



**代码实现**

```java
//快速排序
public class QuickSort {

    public static void main(String[] args) {

        int[] array = {  4, 2, 8, 9, 5, 7, 6, 1, 3};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    static void quickSort(int s[], int left, int right) {
        if (left < right) {
            int i = left, j = right, x = s[left];
            while (i < j) {
                while (i < j && s[j] >= x) { // 从右向左找第一个小于x的数
                    j--;
                }
                while (i < j && s[i] <= x) {// 从左向右找第一个大于等于x的数
                    i++;
                }
                //将找到的第一个小于x跟大于x的数据进行交换
                int temp = s[j];
                s[j] = s[i];
                s[i] = temp ;
            }
//          把目标交换到合适位置，保证前面的所有数都小于它，后面的数都大于它
            int temp = s[i] ;
            s[i] = s[left];
            s[left] = temp ;

            quickSort(s, left, i - 1); // 递归调用
            quickSort(s, i + 1, right);
        }
    }

}
```



## 1.4 二分查找

​		二分查找又叫做折半查找，其查找过程为：先确定待查记录所在的范围（区间），然后逐步缩小范围知道找到或者找不到该记录为止。注意二分查找是在**有序**表上进行的，且二分查找也是分治思想的很好例证。





![img](assets/461877-20160721092729169-843824718.gif)



**代码实现**

```java
public class BinarySearch {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        int result = binarySearch(arr,7);
        System.out.println(result);
    }

    public static int binarySearch(int [] srcArray, int des) {
        //定义初始最小、最大索引
        int start = 0;
        int end = srcArray.length - 1;
        //确保不会出现重复查找，越界
        while (start <= end) {
            //计算出中间索引值
            int middle = (end + start)>>>1 ;//防止溢出
            if (des == srcArray[middle]) {
                return middle;
                //判断下限
            } else if (des < srcArray[middle]) {
                end = middle - 1;
                //判断上限
            } else {
                start = middle + 1;
            }
        }
        //若没有，则返回-1
        return -1;
    }
}
```



​	`java.util.Arrays`已经实现了二分查找算法`binarySearch`，并重载了各种基本数据类型数组的查找，以int []为例。

**代码演示**

```java
public class BinarySearch {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
       // 在数组中查找目标为4的索引位置
        System.out.println(Arrays.binarySearch(arr, 4));

    }
}
```

