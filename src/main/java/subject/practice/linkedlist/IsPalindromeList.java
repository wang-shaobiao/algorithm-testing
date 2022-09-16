package subject.practice.linkedlist;


import java.util.ArrayDeque;
import java.util.Deque;


public class IsPalindromeList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }
    //笔试，最简单实现
    public static boolean isPalindromeList01(Node head) {
        Deque<Node> stack = new ArrayDeque<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    //稍进化一点，不全部入栈
    //使用快慢指针
    public static boolean isPalindromeList02(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Deque<Node> stack = new ArrayDeque<>();
        //快慢指针，指向中点下一个
        Node slow = head.next;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //后半段入栈
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        //对比
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    //O(1) extra space
    //best now  to me
    public static boolean isPalindormeList03(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        Node n3 = null;//预留节点使用 reserved node
        //slow/fast pointer
        //if odd, n1 point to the middle
        //if even, n1 point to the left middle
        //but it doesn't matter
        while (n2.next != null && n2.next.next != null) {//find mid node
            n1 = n1.next; // n1->mid
            n2 = n2.next.next; // n2-end
        }
        //此时，从中点开始反转链表
        n2 = n1.next;
        n1.next = null;//中点成为尾节点
        while (n2 != null) { // right part convert
            n3 = n2.next; //n3->save the next node
            n2.next = n1; //next of right node convert
            n1 = n2;//n1 right shift
            n2 = n3;//n2 right shift
        }
        //检测回文，check palindrome
        n3 = n1 ; //save last node --保存最后节点，留待后续再翻转回来
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        //reset original list
        n1 = n3.next;
        n3.next = null;//尾节点 last node
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
