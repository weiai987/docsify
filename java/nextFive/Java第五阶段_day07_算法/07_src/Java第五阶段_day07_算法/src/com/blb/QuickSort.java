package com.blb;

import java.util.Arrays;
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
