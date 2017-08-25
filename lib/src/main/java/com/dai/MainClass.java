package com.dai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MainClass {

    public static void main(String[] args) {
        quickSort();
    }


    //快速排序
    private static void quickSort() {
        int[] array = {4, 8, 0, 3, 2, 7, 6, 9};
        SortClass sortClass = new SortClass();
        sortClass.quickSort(array, 0, array.length - 1);
        for (int arr : array) {
            System.out.println("arr = " + arr);
        }
    }
    //两个有序数组，合成一个集合，求中位数

    private static void sort_1() {
        ArrayList<Integer> list = new ArrayList<>();
        int[] a = {1, 2, 4, 6, 7, 14};
        int[] b = {3, 6, 9, 11, 15};

        int index = 0;
        for (int value : a) {
            for (int j = index; j < b.length; j++) {
                if (b[j] < value) {
                    list.add(b[j]);
                } else {
                    list.add(value);
                    index = j;
                    break;
                }
            }
        }
        System.out.println("list.get(list.size() / 2) = " + list.get(list.size() / 2));
    }

    //优化 两个有序数组，合成一个集合，求中位数
    private static void sort_2() {
        int[] a = {1, 2, 4, 6, 7, 14};
        int[] b = {3, 6, 9, 11, 15};
        int[] temp = new int[a.length + b.length];
        int index = 0;
        int aLeft = 0;
        int aRight = a.length;
        int bLeft = 0;
        int bRight = b.length;

        while (aLeft < aRight && bLeft < bRight) {
            if (a[aLeft] < b[bLeft]) {
                temp[index++] = a[aLeft++];
            } else {
                temp[index++] = b[bLeft++];
            }
        }
        while (aLeft < aRight) {
            temp[index++] = a[aLeft++];
        }
        while (bLeft < bRight) {
            temp[index++] = b[bLeft++];
        }
        System.out.println("temp[temp.length / 2] = " + temp[temp.length / 2]);
    }


    public char findFirstRepeat_1(String A, int n) {

        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        char[] charArray = A.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            if (hm.get(charArray[i]) == null) {
                hm.put(charArray[i], 1);
            } else {
                return charArray[i];
            }
        }

        return '\n';
    }

    public static char findFirstRepeat_2(String A, int n) {
        HashSet<Character> hm = new HashSet<Character>();


        char[] charArray = A.toCharArray();

        for (int i = 0; i < charArray.length; i++) {


            if (hm.add(charArray[i])) {

            } else {
                System.out.println("charArray[i] = " + charArray[i]);
                System.out.println("true = " + false);
                return charArray[i];
            }
        }
        return '\n';
    }

    public char findFirstRepeat_3(String A, int n) {

        char[] charArray = A.toCharArray();
        int[] hashChar = new int[256]; // ASCII 范围

        for (int i = 0; i < charArray.length; i++) {
            if (hashChar[charArray[i] - '0'] == 0) {
                hashChar[charArray[i] - '0'] = 1;
            } else {
                return charArray[i];
            }
        }
        return '\n';
    }
}

