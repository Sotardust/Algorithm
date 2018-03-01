package com.dai.sort;

import java.util.Random;

/**
 * Created by dai on 2018/2/28.
 */
public class MySort {

    public int[] getInts() {
        return ints;
    }

    private int[] ints = new int[100000];
    private Random random = new Random();

    public MySort() {
        resetInts();
    }

    //重置数据
    public void resetInts() {
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(5 * ints.length) % (5 * ints.length - 1 + 1) + 1;
        }

    }

    // 数组交换 升序
    private void swap(int[] a, int index1, int index2) {
        if (a[index1] < a[index2]) {
            int temp = a[index1];
            a[index1] = a[index2];
            a[index2] = temp;
        }
    }

    //冒泡排序算法
    public void bubbleSort() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < ints.length; i++) {
            for (int j = i; j < ints.length; j++) {
                if (ints[i] > ints[j]) {
                    int temp = ints[j];
                    ints[j] = ints[i];
                    ints[i] = temp;
                }
            }
        }
        printConsumeTime("冒泡排序", start);
    }

    //优化冒泡排序算法
    public void optimizeBubbleSort() {

        long start = System.currentTimeMillis();

        int index = 0;
        boolean flag = true; //设置标志位
        while (flag) {
            flag = false;
            for (int j = index; j < ints.length - 1; j++) {
                if (ints[j + 1] < ints[j]) {
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                    flag = true;
                }
            }
            index++;
        }
        printConsumeTime("优化冒泡排序", start);

    }

    //插入排序算法
    public void insertSort() {
        for (int i = 1; i < ints.length; i++) {
            int temp = ints[i];
            int j = i - 1;
            while (j >= 0 && temp < ints[j]) {
                ints[j + 1] = ints[j];
                j--;
            }
            ints[j + 1] = temp;
        }
    }

    //执行快速排序算法
    public void executeQuickSort() {
        quickSort(ints, 0, ints.length - 1);
    }

    // 求基准元素位置
    private int partition(int[] ints, int low, int high) {
        int key = ints[low];
        while (low < high) {
            while (ints[high] >= key && high > low) { //从后半部分向前扫描
                high--;
            }
            ints[low] = ints[high];
            while (ints[low] <= key && high > low) { //从前半部分向后扫描
                low++;
            }
            ints[high] = ints[low];
        }
        ints[high] = key;
        return high;
    }

    //执行快速排序算法
    private void quickSort(int[] ints, int low, int high) {
        if (low >= high) return;
        int index = partition(ints, low, high);
        quickSort(ints, low, index - 1);
        quickSort(ints, index + 1, high);

    }

    //堆排序算法
    private void heapSort() {
        for (int i = 0; i < ints.length / 2; i++) {
            heapAdjust(ints, i, ints.length - 1);
        }
        for (int i = ints.length - 1; i > 0; --i) {
            swap(ints, i, 0);
            heapAdjust(ints, 0, i - 1);
        }
    }

    //执行堆排序算法
    public void executeHeapSort() {
        heapSort();
    }

    //堆调整
    private void heapAdjust(int[] a, int root, int length) {
        for (int i = 2 * root + 1; i < length; i++) {
            swap(a, i, i + 1);
            swap(a, root, i);
        }
    }

    //归并排序算法
    public void executeMergeSort() {
        //TODO
        mergeSort(ints, 0, ints.length - 1);
    }

    //归并排序算法
    private void mergeSort(int[] ints, int low, int high) {
        int mid = (low + high) / 2;
        if (low >= high) return;
        mergeSort(ints, low, mid);
        mergeSort(ints, mid + 1, high);
        merge(ints, low, mid, high);
    }

    // 归并
    private void merge(int[] ints, int low, int center, int high) {
        int[] temp = new int[ints.length];
        int mid = center + 1;
        int tempIndex = low;
        int index = low;
        while (low <= center && mid <= high) {
            if (ints[low] <= ints[mid]) {
                temp[index++] = ints[low++];
            } else {
                temp[index++] = ints[mid++];
            }
        }
//        printArray("temp1", temp);
        while (low <= center) {
            temp[index++] = ints[low++];
        }

//        printArray("temp2", temp);
        while (mid <= high) {
            temp[index++] = ints[mid++];
        }

//        printArray("temp3", temp);
        //（原left-right范围的内容被复制回原数组）
        while (tempIndex <= high) {
            ints[tempIndex] = temp[tempIndex++];
        }
//        printArray("temp4", ints);
    }

    //选择排序算法
    public void selectSort() {
        for (int i = 0; i < ints.length; i++) {
            int index = i;
            for (int j = i; j < ints.length; j++) {
                if (ints[index] > ints[j]) {
                    index = j;
                }
            }
            int temp = ints[i];
            ints[i] = ints[index];
            ints[index] = temp;
        }
    }

    //希尔排序算法
    public void shellSort() {
        //TODO 等待添加希尔排序
    }

    //动态规划算法

    //打印执行算法所消耗时间
    private void printConsumeTime(String string, Long start) {
        System.out.println(string + "所用时间 = " + (System.currentTimeMillis() - start));
    }

    //打印数组
    public void printArray() {
        StringBuilder sb = new StringBuilder();
        sb.append(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            sb.append(" , " + ints[i]);
        }
        System.out.println("数组 : " + sb + "\n");
    }

    //打印带参数组
    public void printArray(String sort, int[] ints) {
        StringBuilder sb = new StringBuilder();
        sb.append(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            sb.append(" , " + ints[i]);
        }
        System.out.println(sort + " : " + sb + "\n");
    }

    //打印带参数组
    public void printArray(String sort) {
        StringBuilder sb = new StringBuilder();
        sb.append(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            sb.append(" , " + ints[i]);
        }
        System.out.println(sort + " : " + sb + "\n");
    }
}
