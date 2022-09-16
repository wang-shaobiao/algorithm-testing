import subject.practice.linkedlist.IsPalindromeList;

public class Test02 {
    public static void main(String[] args) {
        IsPalindromeList.Node node1 = new IsPalindromeList.Node(1);
        IsPalindromeList.Node node2 = new IsPalindromeList.Node(2);
        IsPalindromeList.Node node3 = new IsPalindromeList.Node(3);
        IsPalindromeList.Node node4 = new IsPalindromeList.Node(3);
        IsPalindromeList.Node node5 = new IsPalindromeList.Node(2);
        IsPalindromeList.Node node6 = new IsPalindromeList.Node(1);
//        IsPalindromeList.Node node7 = new IsPalindromeList.Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
//        node6.next = node7;
        long startTime = System.nanoTime();
        Boolean test1 = IsPalindromeList.isPalindromeList01(node1);
        long endTime = System.nanoTime();
        //System.out.println(endTime - startTime);
        long durationTime1 = endTime-startTime;
        startTime = System.nanoTime();
        Boolean test2 = IsPalindromeList.isPalindromeList02(node1);
        endTime = System.nanoTime();
        //System.out.println(endTime - startTime);
        long durationTime2 = endTime-startTime;
        startTime = System.nanoTime();
        Boolean test3 = IsPalindromeList.isPalindormeList03(node1);
        endTime = System.nanoTime();
        long durationTime3 = endTime-startTime;
        System.out.println(test1+"运行时间（ns）"+durationTime1);
        System.out.println(test2+"运行时间（ns）"+durationTime2);
        System.out.println(test3+"运行时间（ns）"+durationTime3);
    }
}
