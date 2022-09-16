package subject.practice.linkedlist;

import java.util.HashMap;

public class CopyListWithRand {
    public static class Node{
        public int value;
        public Node next;
        public Node rand;
        public Node(int data) {
            this.value = data;
        }
    }
    //interview use container(hashMap)
    public static Node copyListWithRand01(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node cur = head;
        //use hashmap copy node
        while (cur != null) {
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        //duplicate pointer connect
        cur = head;
        while (cur != null) {
            //cur old-node
            //map.get(cur) new-node
            map.get(cur).next = cur.next;
            map.get(cur).rand = cur.rand;
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node copyListWithRand02(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node next = null;
        //copy node and link to every node
        //1-2  -> 1-1'-2
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        //copy node next is already
        //set copy node rand
        while (cur != null) {
            next = cur.next.next;//record next origin node
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        //peel copy list
        Node res = head.next;
        cur = head;
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
