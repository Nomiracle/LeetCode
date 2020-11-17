package leetcode.editor.cn.Q83;

//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 426 👎 0
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }


        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test83 {
    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 3};
        ListNode root = createList(array, 0);
        displayList(root);
        Solution solution = new Solution();
        System.out.println();
        displayList(solution.deleteDuplicates(root));
    }

    static ListNode createList(int[] nodes, int index) {
        if (index >= nodes.length) return null;
        ListNode node = new ListNode(nodes[index]);
        node.next = createList(nodes, index + 1);
        return node;
    }

    static void displayList(ListNode root) {
        ListNode pos = root;
        while (pos != null) {
            System.out.print(pos.val + " ");
            pos = pos.next;
        }

    }
}


