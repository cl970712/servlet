package com.susu.iult.sortAlgorithm;

import java.util.Arrays;

/**
 * 描述:
 * 冒泡排序
 *
 * @author iult
 * @create 2019-01-31 17:22
 */
public class BubbleSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length-i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return array;
    }
}
