package com.dai;

/**
 * Created by dai on 2017/8/24.
 */

class SortClass {

    //求基数位置
    private int partition(int[] array, int left, int right) {
        int key = array[left];
        while (left < right) {
            while (array[right] > key && right > left) {
                right--;
            }

            array[left] = array[right];
            while (array[left] < key && right > left) {
                left++;
            }
            array[right] = array[left];
        }
        array[right] = key;
        return right;
    }

    //通过递归进行排序
    void quickSort(int[] array, int left, int right) {
        if (left > right) return;
        int index = partition(array, left, right);
        quickSort(array, left, index - 1);
        quickSort(array, index + 1, right);
    }
}
