package com.dai;

import com.dai.linked.MyLinkedList;
import com.dai.linked.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MainClass {

    private static SortClass sortClass;

    public static void main(String[] args) {
        System.out.println("MainClass.main");
        sortClass = new SortClass();
        quickSort();
        commonSequence();
        selectSort();
        insertSort();
        bubbleSort();
        biSearch();
        linkedList();
    }


    //快速排序
    private static void quickSort() {
        int[] array = {4, 8, 0, 3, 2, 7, 6, 9};
        sortClass.quickSort(array, 0, array.length - 1);
    }

    //最长公共子序列问题：LCS
    private static void commonSequence() {
        int[] a = {-2, 11, -4, 13, -5, -2};
        int[] b = {5, 11, -4, 13, 6, -2};
        sortClass.commonSequence(a, b);
    }

    //选择排序
    private static void selectSort() {
        int[] a = {5, 11, -4, 13, 6, -2};
        sortClass.selectSort(a);
    }

    //插入排序
    private static void insertSort() {
        int[] a = {5, 11, -4, 13, 6, -2};
        sortClass.insertSort(a);
    }

    //冒泡排序
    private static void bubbleSort() {
        int[] a = {5, 11, -4, 13, 6, -2};
        sortClass.bubbleSort(a);
    }

    //折半查找
    private static void biSearch() {
        int[] array = {4, 8, 9, 12, 16, 17, 20, 31, 42, 56, 81};
        sortClass.biSearch_1(array, 8);
        int index = sortClass.biSearch_2(array, 8, 0, array.length - 1);
        System.out.println("index = " + index);
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

    //对单链表进行处理
    private static void linkedList() {

        MyLinkedList myLinkedList = new MyLinkedList();

        for (int i = 1; i < 9; i++) {
            Node node = new Node(i);
            myLinkedList.addNode(node);
        }
        myLinkedList.insertNode(3, new Node(7));
        myLinkedList.printLinkedList();

        myLinkedList.deleteNode(5);
        myLinkedList.printLinkedList();

        myLinkedList.insertSortNode();
    }
}

