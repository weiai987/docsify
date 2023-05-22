package com.blb;

import java.util.Scanner;

public class Demo02Exception {

    public static void main(String[] args) {
        //创建数组
        int[] arr = {1,2,3,4};
        //根据索引找对应的元素
        int index = 4;
        int element = getElement(arr, index);

        System.out.println(element);
    }

    public static int getElement(int[] arr,int index){
// 当数组下表越界时抛出下标越界异常
        if(index<0 || index>arr.length-1){
            throw new ArrayIndexOutOfBoundsException("blb提醒您，数组下标已越界。");
        }
        return arr[index];
    }
}
