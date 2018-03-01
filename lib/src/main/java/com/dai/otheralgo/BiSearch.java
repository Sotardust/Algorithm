package com.dai.otheralgo;

import java.util.Random;

/**
 * Created by dai on 2018/3/1.
 */
public class BiSearch {
    private int[] ints = new int[10];
    private Random random = new Random();

    public BiSearch() {
        resetInts();
    }

    //重置数据
    public void resetInts() {
        for (int i = 0; i < ints.length; i++) {
//            ints[i] = random.nextInt(5 * ints.length) % (5 * ints.length - 1 + 1) + 1;
            ints[i] = i;
        }
    }

    //折半查找又称二分法查找
    // 数据需要有序排列
    public void biSearch(int[] ints, int number) {

        int left = 0;
        int right = ints.length - 1;
        int mid = 0;
        boolean flag = true;
        while (left <= right) {
            mid = (left + right) / 2;
            if (ints[mid] == number) {
                flag = false;
                break;
            } else if (ints[mid] > number) {
                right = mid + 1;
            } else if (ints[mid] < number) {
                left = mid - 1;
            }
        }
    }


    //通过递归实现折半查找查找
    public int biSearch_1(int[] ints, int number, int left, int right) {
        int mid = (left + right) / 2;
        if (ints[mid] == number) {
            return mid;
        } else if (ints[mid] > number) {
            return biSearch_1(ints, number, left, mid - 1);
        } else {
            return biSearch_1(ints, number, mid + 1, right);
        }
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
