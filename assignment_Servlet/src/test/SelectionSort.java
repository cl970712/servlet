package com.susu.iult.sortAlgorithm;

import java.util.Arrays;

/**
 * 描述:
 * 选择排序
 *
 * @author iult
 * @create 2019-01-31 17:37
 */
public class SelectionSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }
}
