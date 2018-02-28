package com.dai;

import com.dai.linked.MyLinkedList;
import com.dai.linked.Node;
import com.dai.sort.MySort;


/**
 * Created by dai on 2018/2/27.
 */
public class Test {

    private Node head;//头结点

    public static void main(String[] args) {
//        myLinkedList();
        mySort();
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
    }

}
