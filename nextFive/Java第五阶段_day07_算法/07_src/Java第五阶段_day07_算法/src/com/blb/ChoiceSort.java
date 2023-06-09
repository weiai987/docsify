package com.blb;

import java.util.Arrays;

// 选择排序
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
