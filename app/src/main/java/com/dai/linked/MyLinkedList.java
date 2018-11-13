package com.dai.linked;

import java.util.Stack;

/**
 * Created by dai on 2018/2/27.
 */
public class MyLinkedList {


    public Node getHead() {
        return head;
    }

    private Node head;

    public MyLinkedList() {
        head = new Node(-1000);
    }

    /**
     * 添加Node结点
     *
     * @param node 新增的节点
     */
    public void addNode(Node node) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node; //把节点添加到链表最后
//        temp = (head);
    }

    /**
     * 把节点插入指定位置
     *
     * @param index 插入的节点的位置
     * @param node  插入的节点
     */
    public void insertNode(int index, Node node) {
        if (index < 1 || index > length()) return;
        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            if (++count == index) {
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除指定位置的节点
     *
     * @param index 指定下标
     */
    public void deleteNode(int index) {
        if (index < 1 || index > length()) return;
        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            if (count++ == index) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
    }

    //对列表插入排序 //仍有问题
    public void insertSortNode() {

        Node node = head.next;
        Node temp = head;
        while (node != null) {
            Node cur = head;  //比较节点，每次都是从头节点开始

//            if (node.data < head.data) { //由于是单链表，每次只能从头节点开始比较
//                temp.next = node.next;
//                node.next = head;
//                head = node;
//            } else
            while (cur.next != node) {
                if (node.data < cur.next.data) {//将P与cur.next进行比较，方便单链表插入
                    temp.next = node.next;
                    node.next = cur.next;
                    cur.next = node;
                    node = temp;  //保证pre每次指向的都是p前面的一个节点
                } else
                    cur = cur.next;
                printLinkedList(cur);
            }
            System.out.println("node = " + node.data);
            temp = node;
            node = node.next;
        }
    }

    //计算链表长度
    private int length() {
        Node node = head;
        int length = 0;
        while (node.next != null) {
            length++;
            node = node.next;
            if (node.next == null) {
                length++;
            }
        }
        return length;
    }

    //打印整个链表
    public void printLinkedList() {
        Node temp = head;
        StringBuffer sb = new StringBuffer();
        while (temp.next != null) {
            sb.append(temp.data);
            temp = temp.next;
            if (temp.next == null) break;
            sb.append(" -> ");
        }
        System.out.println("链表 = " + sb);
    } //打印整个链表

    //打印带参数的链表
    public void printLinkedList(Node tempNode) {
        StringBuffer sb1 = new StringBuffer();
        sb1.append(tempNode.data);
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            sb1.append(" --> ").append(tempNode.data);
            if (tempNode.next == null) break;
        }
        System.out.println("链表 = " + sb1);
    }

    /**
     * 递归实现 当栈深度大于12000 则会出现StakOverflowError
     *
     * @param head head
     * @return node
     */
    public Node reverse1(Node head) {
        if (null == head || null == head.getNext()) return head;
        Node revNode = reverse1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        printLinkedList(revNode);
        return revNode;
    }

    /**
     * 遍历实现 通用实现方法
     * 考虑到reverse1最多只支持12000，因此将size改为100000时，
     * 再观察reverse2和reverse3之间的执行结果
     * 最好的方法是采用遍历的方式进行反转。
     *
     * @param head
     * @return
     */
    public Node reverse2(Node head) {
        if (null == head || null == head.getNext()) return head;
        Node pre = head;
        Node cur = head.getNext();
        while (null != cur.getNext()) {
            cur.setNext(pre);
            pre = cur;
            cur = cur.getNext();
        }
        cur.setNext(pre);
        head.setNext(null);
        return cur;
    }

    /**
     * 方法3 利用其他数据结构 stack
     *
     * @param head
     * @return
     */
    public Node reverse3(Node head) {
        Stack<Node> stack = new Stack<Node>();
        for (Node node = head; null != node; node = node.getNext()) {
            stack.add(node);
        }
        Node reHead = stack.pop();
        Node cur = reHead;
        while (!stack.isEmpty()) {
            cur.setNext(stack.pop());
            cur = cur.getNext();
            cur.setNext(null);
            printLinkedList(cur);
        }
        return reHead;
    }


}
