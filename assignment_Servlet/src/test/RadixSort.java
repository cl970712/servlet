package com.susu.iult.sortAlgorithm;

import java.util.Arrays;

/**
 * 描述:
 * 基数排序
 *
 * @author iult
 * @create 2019-02-11 0:42
 */
public class RadixSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxDigit = getMaxDigit(array);
        return radixSort(array, maxDigit);
    }

    /**
     * 获取最高位数
     * @param array
     * @return
     */
    private int getMaxDigit(int[] array) {
        int maxValue = getMaxValue(array);
        return getNumLength(maxValue);
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

    protected int getNumLength(long num) {
        if (num == 0) {
            return 1;
        }
        int length = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            length++;
        }
        return length;
    }

    private int[] radixSort(int[] array, int maxDigit) {
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10,mod *= 10) {
            //考虑负数的情况，这里扩展一倍队列数，其中[0-9]对应负数，[10-19]对应正数(buket + 10)
            int[][] counter = new int[mod * 2][0];
            for (int j = 0; j < array.length; j++) {
                int buket = ((array[j] % mod) / dev) + mod;
                counter[buket] = arrayAppend(counter[buket], array[j]);
            }
            int pos = 0;
            for (int[] buket : counter) {
                for (int value : buket) {
                    array[pos++] = value;
                }
            }
        }
        return  array;
    }
    
    private int[] arrayAppend(int[] array, int value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
        return array;
    }
}
