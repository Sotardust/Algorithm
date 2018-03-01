package com.dai;


import com.dai.linked.MyLinkedList;
import com.dai.linked.Node;
import com.dai.otheralgo.BiSearch;
import com.dai.otheralgo.MyDynamic;
import com.dai.sort.MySort;

/**
 * Created by dai on 2018/2/27.
 */
public class Test {

    public static void main(String[] args) {
//        myLinkedList();
//        mySort();
//        myBiSearch();
        myDynamic();
    }

    //单链表
    private static void myLinkedList() {

        MyLinkedList myLinkedList = new MyLinkedList();

        for (int i = 1; i < 9; i++) {
            Node node = new Node(i);
            myLinkedList.addNode(node);
        }
//        myLinkedList.insertNode(3, new Node(7));
        myLinkedList.printLinkedList();
//
//        myLinkedList.deleteNode(5);
//        myLinkedList.printLinkedList();
//
//        myLinkedList.insertSortNode();
//        myLinkedList.printLinkedList();


//        Node head = myLinkedList.getHead();
//
//        myLinkedList.printLinkedList(head);
//
//        Node node = myLinkedList.reverse3(head);
//
//        myLinkedList.printLinkedList(node);
    }


    private static void mySort() {
        MySort mySort = new MySort();

        mySort.bubbleSort();
        mySort.printArray("冒泡排序");

        mySort.resetInts();
        mySort.optimizeBubbleSort();
        mySort.printArray("优化冒泡排序");

        mySort.resetInts();
        mySort.insertSort();
        mySort.printArray("插入排序");

        mySort.resetInts();
        mySort.selectSort();
        mySort.printArray("选择排序");

        mySort.resetInts();
        mySort.executeQuickSort();
        mySort.printArray("快速排序");

        mySort.resetInts();
        mySort.printArray();
        mySort.executeMergeSort();
        mySort.printArray("快速排序");

        mySort.resetInts();
        mySort.printArray();
        mySort.executeHeapSort();
        mySort.printArray("堆排序");
    }

    private static void myBiSearch() {
        BiSearch biSearch = new BiSearch();
        MySort mySort = new MySort();
        mySort.insertSort();
        mySort.printArray();
        int[] ints = mySort.getInts();
        long start = System.currentTimeMillis();
        biSearch.biSearch(ints, ints[2]);
        System.out.println("折半查找所用时间 = " + (System.currentTimeMillis() - start));
        long start1 = System.currentTimeMillis();
        int number = biSearch.biSearch_1(ints, ints[2], 0, ints.length - 1);
        System.out.println("number = " + number);
        System.out.println("递归折半查找所用时间= " + (System.currentTimeMillis() - start1));

    }

    private static void myDynamic() {
        MyDynamic myDynamic = new MyDynamic();
        System.out.println("myDynamic.maxSum() = " + myDynamic.maxSum());
        myDynamic.executeCommonSequence();
    }
}
