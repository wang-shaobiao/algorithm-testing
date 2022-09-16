package subject.practice.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 递归遍历 recursive traversal
 * 非递归遍历 non-recursive traversal
 * 宽度优先遍历 width first traversal
 */
public class SimpleTraversal {
    /**
     * 二叉树为链表结构实现
     */
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 递归实现三种遍历方式
     */
    //先序遍历-递归实现
    //pre Order-recursive
    public static void preOrderRecur(Node head) {
        if (head == null) {
            return ;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
    //中序遍历-递归实现
    //in Order-recursive
    public static void inOrderRecur(Node head) {
        if (head == null) {
            return ;
        }
        preOrderRecur(head.left);
        System.out.println(head.value + " ");
        preOrderRecur(head.right);
    }
    //后序遍历-递归实现
    //post Order-recursive
    public static void postOrderRecur(Node head) {
        if (head == null) {
            return ;
        }
        preOrderRecur(head.left);
        preOrderRecur(head.right);
        System.out.println(head.value + " ");
    }
    /**
     * no recursive --非递归实现
     * 自准备栈
     */
    //先序
    public static void proOrderUnRecur(Node head) {
        System.out.println("pre-order: ");
        if (head != null) {
            Deque<Node> stack = new ArrayDeque<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    //中序
    public static void inOrderUnRecur(Node head) {
        System.out.println("in-order: ");
        if (head != null) {
            Deque<Node> stack = new ArrayDeque<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
    }

    //后续
    public static void posOrderUnRecur01(Node head) {
        System.out.println("pos-order: ");
        if (head != null) {
            Deque<Node> stack1 = new ArrayDeque<Node>();
            Deque<Node> stack2 = new ArrayDeque<Node>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value + " ");
            }
        }
    }

    /**
     * 宽度优先遍历
     */
    public static void widthTraversal(Node head) {
        if (head == null) {
            return ;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }

    }

}
