package subject.practice.linkedlist;

import utils.SwapUtils;

//链表分组
public class ListPartition {
    public static class Node {
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }
    /*
    给定单链表头结点head，节点类型为整型，在给定一个整数pivot。
    实现一个调整链表的函数，将链表调整为左部分都是值小于pivot的节点，
    中间部分都是等于pivot的节点，右部分都是值大于pivot的节点。
    */
    //written examination--simple implementation
    public static Node listPartition01(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        //创建数组 create an array
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        //链表入数组
        i=0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i-1].next = null;//end node
        return nodeArr[0];
    }
    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                SwapUtils.swap(nodeArr,++small,index);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                SwapUtils.swap(nodeArr, --big, index);
            }
        }
    }
    //interview --better implementation
    public static Node listPartition02(Node head, int pivot) {
        //6个节点指针
        Node sH = null;//small head
        Node sT = null;//small tail
        Node eH = null;//equal head
        Node eT = null;//equal tail
        Node bH = null;//big head
        Node bT = null;//big tail
        Node next = null; //save next node
        //partition
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT =head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        //各个分区连接，需要考虑到边界问题
        //reconnect ,borders need to be considered
        if (sT != null) {//如果有小于区域
            sT.next=eH;
            eT = eT == null ? sT : eT;//下一步，谁去连接大于区域的头，谁就变为eT
        }
        //上面的if,不管跑了没有
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);
    }
}
