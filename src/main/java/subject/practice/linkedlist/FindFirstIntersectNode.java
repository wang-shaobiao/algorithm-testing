package subject.practice.linkedlist;

public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * main function--主函数
     */
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //1.两个链表均为无环
        //two list both no loop
        if (loop1 == null && loop2 == null) {
            return noLoopIntersect(head1, head2);
        }
        //2.两个链表均为有环
        //two list both loop
        if (loop1 != null && loop2 != null) {
            return bothLoopIntersection(head1, loop1, head2, loop2);
        }
        //3.一有环一无环，必不相交
        //one loop ,the other no loop
        return null;
    }

    /**
     * find the first node into the ring,if no ring ,return null
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        // slow and fast pointer,slow pointer first ring must meet the fast pointer
        Node n1 = head.next; //n1 -> slow
        Node n2 = head.next.next;//n2 -> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;//exists null node ,no ring
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        //after slow and fast meeting,use other pointer or reuse the fast pointer start at the beginning,
        //when the two pointer meet,this node must be the first node into the ring
        //this conclusion can be proved by mathematical expression
        n2 = head;// n2->walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    /**
     * no loop list intersect,return the first intersect node
     */
    public static Node noLoopIntersect(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        //start counting
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //if the two list intersect ,then must be repeated at the tail nod
        if (cur2 != cur1) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;//who big  who be cur1
        cur2 = cur1 == head1 ? head2 : head1;//who small who be cur2
        n = Math.abs(n);//the absolute value
        //the long linkedlist goes first
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        //the two list both go together
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * two has ring list/two loop list intersect
     * no exist one has ring ,the other has no ring
     */
    public static Node bothLoopIntersection(Node head1, Node loop1, Node head2, Node loop2) {
        //三种情况
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;//return loop2 is also true
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
