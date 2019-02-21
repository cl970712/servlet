package com.susu.iult.sortAlgorithm;

import java.util.Arrays;

/**
 * 描述:
 *
 * @author iult
 * @create 2019-01-31 17:45
 */
public class ShellSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        int gap = 1;
        while (gap < array.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j = i - gap;
                while (j > 0 && array[j] > temp) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = temp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        return array;
    }

}
