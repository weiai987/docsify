package com.blb;

import java.util.Arrays;

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
