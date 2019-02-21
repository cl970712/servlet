package com.susu.iult.sortAlgorithm;

import java.util.Arrays;

/**
 * 描述:
 * 插入排序
 *
 * @author iult
 * @create 2019-01-31 17:43
 */
public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && temp < array[j-1]) {
                array[j] = array[j-1];
                j--;
            }
            if (j != i) {
                array[j] = temp;
            }
        }
        return array;
    }
}
