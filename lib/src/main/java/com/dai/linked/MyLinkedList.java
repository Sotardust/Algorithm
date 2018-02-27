package com.dai.linked;

/**
 * Created by dai on 2018/2/27.
 */
public class MyLinkedList {


    private Node head = null;

    public MyLinkedList() {
        head = new Node(0);
    }

    public Node getHead() {
        return head;
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

    //对列表插入排序
    public void insertSortNode() {

        Node node = head;
        Node temp = new Node(0);


        //复制整个链表
//        if (temp.next == null) {
//            temp.next = node.next;
//        }

        //降低一个节点放入新链表中
        if (temp.next == null) {
            temp = node.next ;
            temp.next = new Node(node.next.data);
        }

        StringBuffer sb = new StringBuffer();
        while (temp.next != null) {
            sb.append(temp.data);
            temp = temp.next;
            if (temp.next == null) break;
            sb.append(" --> ");
        }
        System.out.println("1链表 = " + sb);
//        while (node.next != null) {
//            temp.next = node.next;
//            System.out.println("node = " + node.data);
//            temp = temp.next;
//            temp  = node ;
//            node = node.next;
//        }

    }

    //计算链表长度
    private int length() {
        Node node = head;
        int length = 0;
        while (node.next != null) {
            length++;
            node = node.next;
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
    }
}
