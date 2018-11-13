package com.dai;

import java.util.ArrayList;

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

    //最长公共子序列问题：LCS
    void commonSequence(int a[], int b[]) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();//保存所有公共子序列
        for (int i = 0; i < a.length; i++) {
            int index = i;
            ArrayList<Integer> temp = new ArrayList<>();  //保存公共子序列
            boolean flag = false;
            for (int aB : b) {
                if (index < a.length && a[index] == aB) {
                    ++index;
                    flag = true;
                    temp.add(aB);
                } else {
                    if (flag)
                        break;
                }
            }
            list.add(temp);
        }

        int index = 0;  //最长公共子序列下标
        int maxLength = 0;
        for (ArrayList<Integer> temp : list) {
            if (temp.size() > maxLength) {
                maxLength = temp.size();
                index = list.indexOf(temp);
            }
        }
    }

    //快速排序
    void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int index = i;
            for (int j = i; j < a.length; j++) {
                if (a[index] > a[j]) {
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
    }

    //插入排序
    void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j > -1 && temp < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

    //冒泡排序
    void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    //堆排序
    void heapSort(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            heapAdjust(a, i, a.length - 1);
        }
        for (int i = a.length - 1; i > 0; --i) {
            swap(a, i, 0);
            heapAdjust(a, 0, i - 1);
        }

    }

    //堆调整
    void heapAdjust(int[] a, int root, int length) {
        for (int i = 2 * root + 1; i < length; i++) {
            swap(a, i, i + 1);
            swap(a, root, i);
        }
    }

    void swap(int[] a, int index1, int index2) {
        if (a[index1] < a[index2]) {
            int temp = a[index1];
            a[index1] = a[index2];
            a[index2] = temp;
        }
    }

    //折半查找
    void biSearch_1(int[] array, int num) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (num == array[mid]) {
                //返回查找到改数值的索引
                System.out.println("折半查找获取该数组的索引值为：mid = " + mid);
                break;
            } else if (num > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    //通过递归实现折半查找查找
    int biSearch_2(int[] array, int num, int left, int right) {
        int mid = (left + right) / 2;
        if (num == array[mid]) {
            //通过递归查询该数值的索引
            System.out.println("折半查找获取该数组的索引值为：mid = " + mid);
            return mid;
        } else if (num < array[mid]) {
            return biSearch_2(array, num, left, mid - 1);
        } else {
            return biSearch_2(array, num, mid + 1, right);
        }
    }
}
