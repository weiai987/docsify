package org.hopu.djp.libDemo.jucTest;

public class SortTest {
    private static final int[] numbers = {
            12,3,7,5,18,22,6,19,14
    };
    // 冒泡排序
    public static void bubbleSort(int[] numbers) {
        int temp; // 记录临时中间值
        int size = numbers.length; // 数组大小
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] < numbers[j]) { // 交换两数的位置
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 冒泡排序
        bubbleSort(numbers);
        for(int x : numbers) {
            System.out.print(x + ",");
        }
    }
}
