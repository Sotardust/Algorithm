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

        //创建新链表
        Node newHead = new Node(-1000);    //新链表的头结点
        Node newTemp = newHead;        //新链表的移动指针
        Node temp = head;        //旧链表的移动指针
        if (newTemp.next == null) {        //将第一个结点直接放入新链表中。
            newTemp.next = new Node(temp.data);
            temp = temp.next;    //旧链表中指针移到下一位(第二个结点处)。
        }
        printLinkedList(temp);
        while (temp.next != null) {     //    遍历现有链表
            while (newTemp.next != null) {
                //先跟新链表中的第一个结点进行比较,如果符合条件则添加到新链表，注意是在第一个位置上增加结点
                //如果不符合，则跟新链表中第二个结点进行比较，如果都不符合，跳出while，判断是否是到了新链表的最后一个结点，如果是则直接在新链表后面添加即可

                if (newTemp.next.data < temp.next.data) {
                    Node node = new Node(temp.next.data);
                    node.next = newTemp.next;
                    newTemp.next = node;
                    break;
                }
                newTemp = newTemp.next;
            }
            if (newTemp.next == null) {//到达最末尾还没符合，那么说明该值是新链表中最小的数，直接添加即可到链表中即可
                //直接在新链表后面添加
                Node node = new Node(temp.next.data);
                newTemp.next = node;
            }
            //旧链表指针指向下一位结点，继续重复和新链表中的结点进行比较。
            temp = temp.next;
            //新链表中的移动指针需要复位，指向头结点
            newTemp = newHead;
        }
        //开始使用新链表，旧链表等待垃圾回收机制将其收回。
        head = newHead;
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
    } //打印整个链表

    //打印带参数的链表
    public void printLinkedList(Node tempNode) {
        System.out.println("*****************************************");
        StringBuffer sb1 = new StringBuffer();
        sb1.append(tempNode.data);
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            sb1.append(" --> ").append(tempNode.data);
            if (tempNode.next == null) break;
        }
        System.out.println(" ****链表**** = " + sb1);
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
            Node temp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = temp;
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
    public static Node reverse3(Node head) {
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
        }
        return reHead;
    }


}
