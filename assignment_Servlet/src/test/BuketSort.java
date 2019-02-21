package com.susu.iult.sortAlgorithm;

import java.util.Arrays;

/**
 * 描述:
 * 桶排序
 *
 * @author iult
 * @create 2019-02-11 0:11
 */
public class BuketSort implements IArraySort{
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        return buketSort(array, 5);
    }

    private int[] buketSort(int[] array, int buketSize) {
        if (array.length == 0){
            return array;
        }
        int minValue = array[0];
        int maxValue = array[0];
        for (int value : array) {
            if (value < minValue) {
                maxValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }
        int buketCount = (int) Math.floor((maxValue - minValue) / buketSize) +1;
        int[][] bukets = new int[buketCount][0];
        //利用映射函数将数据分配到各个桶中
        for (int i = 0; i < array.length; i++) {
            int index = (int) Math.floor((array[i] - minValue) / buketSize);
            bukets[index] = arrayAppend(bukets[index], array[i]);
        }
        int arrayIndex = 0;
        for (int[] buket : bukets) {
            if (buket.length <= 0) {
                continue;
            }
            //对每个桶进行排序，这里使用了插入排序
            buket = new InsertSort().sort(buket);
            for (int value : buket) {
                array[arrayIndex++] = value;
            }
        }
        return array;
    }

    /**
     * 自动扩容，并保存数据
     * @param array
     * @param value
     * @return
     */
    private int[] arrayAppend(int[] array, int value) {
        array = Arrays.copyOf(array, array.length+1);
        array[array.length - 1] = value;
        return array;
    }
}
