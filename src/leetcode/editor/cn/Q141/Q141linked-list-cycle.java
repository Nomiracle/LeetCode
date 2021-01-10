package leetcode.editor.cn.Q141;

//给定一个链表，判断链表中是否有环。 
//
// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数
//pos 来表示链表尾连接到链表中的
//位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。 
//
// 如果链表中存在环，则返回 true 。 否则，返回 false 。 
//
// 
//
// 进阶： 
//
// 你能用 O(1)（即，常量）内存解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [3,2,0,-4], pos = 1
//输出：true
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [1,2], pos = 0
//输出：true
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [1], pos = -1
//输出：false
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 104] 
// -105 <= Node.val <= 105 
// pos 为 -1 或者链表中的一个 有效索引 。 
// 
// Related Topics 链表 双指针 
// 👍 890 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    //info: 解答成功: //	执行耗时:0 ms,击败了100.00% 的Java用户 //	内存消耗:38.6 MB,击败了68.56% 的Java用户 (a minute ago)
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)return false;
        ListNode fast = head.next,slow=head;

        while (slow!=fast){
            if(fast==null||fast.next==null)return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
    //info: 解答成功: //	执行耗时:7 ms,击败了10.02% 的Java用户 //	内存消耗:38.8 MB,击败了50.76% 的Java用户 (moments ago)
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> nodeList = new HashSet<>();
//        ListNode ls = head;
//        while (ls!=null){
//            if(nodeList.contains(ls))return true;
//            nodeList.add(ls);
//            ls = ls.next;
//        }
//        return false;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class test141{
    public static void main(String[] args) {
        int[] array;
        Solution solution = new Solution();
        ListNode listNode;

        array = new int[]{3,2,0,-4};

        listNode = buildCycle(array,true,1);
        printList(listNode,true,array.length);
        System.out.println("result:"+solution.hasCycle(listNode));

        array = new int[]{1,3};
        listNode = buildCycle(array,true,0);
        printList(listNode,true,array.length);
        System.out.println("result:"+solution.hasCycle(listNode));

        array = new int[]{1};
        listNode = buildCycle(array,false,0);
        printList(listNode,false,array.length);
        System.out.println("result:"+solution.hasCycle(listNode));

        array = new int[]{1,2};
        listNode = buildCycle(array,false,0);
        printList(listNode,false,array.length);
        System.out.println("result:"+solution.hasCycle(listNode));

    }
    private static void printList(ListNode head,boolean isCircle,int len){
        ListNode tmp = head;
        for(int i=0;i<len;i++){
            System.out.print(tmp.val+" ");
            tmp = tmp.next;
        }
        if(!isCircle){
            System.out.println();
            return;
        }
        System.out.print(" ,circle node:");
        System.out.print(tmp.val+" ");
        System.out.println();
    }

    private static ListNode buildCycle(int[] array,boolean isCircle,int circlePos){
        ListNode root = buildCycle(array, 0);
        if(!isCircle)return root;
        ListNode tmp = root,circlePosNode=root;
        int tmpPos=0;
        while(tmp.next!=null){
            if(tmpPos==circlePos){
                circlePosNode=tmp;
            }
            tmpPos++;
            tmp = tmp.next;
        }

        tmp.next = circlePosNode;

        return root;
    }

    private static ListNode buildCycle(int[] array,int pos){
        if(pos>=array.length)return null;
        ListNode node = new ListNode(array[pos]);
        node.next=buildCycle(array, pos+1);
        return node;
    }
}


