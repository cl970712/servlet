package com.susu.iult.sortAlgorithm;

import java.util.Arrays;

/**
 * 描述:
 * 快速排序
 *
 * @author iult
 * @create 2019-02-10 19:45
 */
public class QuickSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(array, 0, array.length-1);
    }

    private int[] quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            quickSort(array, left, partitionIndex-1);
            quickSort(array, partitionIndex+1, right);
        }
        return array;
    }

    private int partition(int[] array, int left, int right) {
        //设定基准值
        int pivot = left;
        int index = pivot+1;
        for (int i = index; i <= right; i++) {
            if (array[i] < array[pivot]) {
                swap(array, i, index);
                index++;
            }
        }
        swap(array, pivot, index-1);
        return index-1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] =temp;
    }
}
