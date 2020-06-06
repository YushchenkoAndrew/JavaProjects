package main.java.LeetCode.Task2;

public class Task2 {
    public static void main(String[] args) {

        ListNode test1 = new ListNode(2);
        test1.next = new ListNode(4);
        test1.next.next = new ListNode(3);

        ListNode test2 = new ListNode(5);
        test2.next = new ListNode(6);
//        test2.next.next = new ListNode(4);

        ListNode outPut = addTwoNumbersSolution2(test1, test2);

        int[] input = new int[]{4, 3};
        ListNode test3 = new ListNode(2);

        ListNode prev = test3;
        for (int i = 0; i < 2; i++) {
            prev.next = new ListNode(input[i]);
            prev = prev.next;
        }

        System.out.println(outPut.val);
        System.out.println(outPut.next.val);
        System.out.println(outPut.next.next.val);
//        System.out.println(outPut.next.next.next.val);
    }

    /**
     * Okey, let me explain, what does this method do?
     * U have the class ListNode and U need to throw from this 2 "lists" l1 and l2
     * for creating the same "list" of sum this two list.
     * It's task seems like depth searching or some of that.
     * Example:
     *      Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     *      Output: 7 -> 0 -> 8
     *      Explanation: 342 + 465 = 807.
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode[] list = new ListNode[]{l1, l2};
        ListNode store = result;
        int carry = 0;
        while(list[0] != null || list[1] != null) {
            int sum = (list[0] != null ? list[0].val : 0) + (list[1] != null ? list[1].val : 0) + carry;
            store.next = new ListNode(sum % 10);
            store = store.next;

            if (list[0] != null)
                list[0] = list[0].next;
            if (list[1] != null)
                list[1] = list[1].next;
            carry = sum / 10;
            if (carry == 1)
                store.next = new ListNode(1);
        }
        return result.next;
    }

    public static ListNode function(ListNode l1, ListNode l2, int carry) {
        if (l1 != null || l2 != null){
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            ListNode result = new ListNode(sum % 10);
            result.next = function((l1 != null ? l1.next : null), (l2 != null ? l2.next : null), sum / 10);
            return result;
        }
        return carry == 1 ? new ListNode(1) : null;
    }

    public static ListNode addTwoNumbersSolution2(ListNode l1, ListNode l2) {
        return function(l1, l2, 0);
    }
}