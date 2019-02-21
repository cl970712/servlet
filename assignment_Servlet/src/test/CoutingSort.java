package com.susu.iult.sortAlgorithm;

import java.util.Arrays;

/**
 * 描述:
 * 计数排序
 *
 * @author iult
 * @create 2019-02-11 0:03
 */
public class CoutingSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxValue = getMaxValue(array);
        return countingSort(array, maxValue);
    }

    private int[] countingSort(int[] array, int maxValue) {
        int buketLength = maxValue + 1;
        int[] buket = new int[buketLength];
        for (int value : array) {
            buket[value]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j < buketLength; j++) {
            while (buket[j] > 0) {
                array[sortedIndex++] = j;
                buket[j]--;
            }
        }
        return array;
    }

    private int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int value : array) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
