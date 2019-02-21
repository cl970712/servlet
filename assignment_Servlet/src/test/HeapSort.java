package com.susu.iult.sortAlgorithm;

import java.util.Arrays;

/**
 * 描述:
 * 堆排序
 *
 * @author iult
 * @create 2019-02-10 23:54
 */
public class HeapSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        int length = array.length;
        bulidMaxHeap(array, length);
        for (int i = length-1; i > 0; i--) {
            swap(array, 0, i);
            length--;
            heapify(array, 0, length);
        }
        return array;
    }

    private void bulidMaxHeap(int[] array, int length) {
        for (int i = (int) Math.floor(length / 2); i >= 0; i--) {
            heapify(array, i, length);
        }
    }

    private void heapify(int[] array, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, largest, length);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] =temp;
    }
}
