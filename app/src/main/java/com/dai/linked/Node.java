package com.dai.linked;

/**
 * Created by dai on 2018/2/27.
 */
public class Node {

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
