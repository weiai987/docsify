package com.blb;

import java.util.Arrays;

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
