package leetcode.editor.cn.Q21;

//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1357 👎 0
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

//leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    //    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//
//        ListNode head = new ListNode(-1), mergeList = head;
//
//        while (l1 != null && l2 != null) {
//            if (l1.val >= l2.val) {
//                mergeList.next = l2;
//                l2 = l2.next;
//            } else {
//                mergeList.next = l1;
//                l1 = l1.next;
//            }
//            mergeList = mergeList.next;
//        }
//
//        if (l1 != null) {
//            mergeList.next = l1;
//        } else mergeList.next = l2;
//
//
//        return head.next;
//    }
// 输入：1->2->4,
//      1->3->4
//输出：1->1->2->3->4->4
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode node;

        if (l1.val >= l2.val) {
            node = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        } else {
            node = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        }

        return node;

    }


}
//leetcode submit region end(Prohibit modification and deletion)


class test {
    public static void main(String[] args) {
        int[] array = {1, 2, 4};
        ListNode list1 = buildLinkedList(array, 0);
        showLinkedList(list1);
        int[] array1 = {1, 3, 4};
        ListNode list2 = buildLinkedList(array1, 0);
        showLinkedList(list2);

        Solution solution = new Solution();
        showLinkedList(solution.mergeTwoLists(list1, list2));

    }


    public static ListNode buildLinkedList(int[] array, int currentIndex) {
        if (currentIndex >= array.length) return null;
        ListNode root = new ListNode(array[currentIndex]);
        root.next = buildLinkedList(array, currentIndex + 1);
        return root;
    }

    public static void showLinkedList(ListNode l1) {
        while (l1 != null) {
            System.out.print(l1.val);
            l1 = l1.next;
        }
        System.out.println();

    }

}


