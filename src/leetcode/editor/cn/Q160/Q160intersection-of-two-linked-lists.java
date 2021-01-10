package leetcode.editor.cn.Q160;

//编写一个程序，找到两个单链表相交的起始节点。 
//
// 如下面的两个链表： 
//
// 
//
// 在节点 c1 开始相交。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, s
//kipB = 3
//输出：Reference of the node with value = 8
//输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1
//,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
// 
//
// 
//
// 示例 2： 
//
// 
//
// 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB =
// 1
//输出：Reference of the node with value = 2
//输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4
//]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
// 
//
// 
//
// 示例 3： 
//
// 
//
// 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//输出：null
//输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而
// skipA 和 skipB 可以是任意值。
//解释：这两个链表不相交，因此返回 null。
// 
//
// 
//
// 注意： 
//
// 
// 如果两个链表没有交点，返回 null. 
// 在返回结果后，两个链表仍须保持原有的结构。 
// 可假定整个链表结构中没有循环。 
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。 
// 
// Related Topics 链表 
// 👍 923 👎 0
  class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB ==null)return null;
        if(headA==headB)return headA;
        ListNode tempA = headA,tempB=headB;

        while(tempA.next!=tempB.next){
            tempA = tempA.next;
            tempB = tempB.next;

            if(tempA==null)tempA=headB;
            if(tempB==null)tempB=headA;
            if(tempA==tempB)return tempA;
        }
        return tempA.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test160{
    public static void main(String[] args) {
        Solution solution = new Solution();
        test160 test = new test160();

        int[] array1 = {4,1,8,4,5},array2 = {5,0,1,8,4,5};
        ListNode[] listNodes = test.buildListNode(array1,array2,2,3);
        test.printList(listNodes[0]);
        test.printList(listNodes[1]);
        ListNode interactionnODE = solution.getIntersectionNode(listNodes[0],listNodes[1]);
        System.out.println("result:"+interactionnODE+","+(interactionnODE==null?null:interactionnODE.val));


        array1 = new int[]{2,6,4};
        array2 = new int[]{1,5};
        listNodes = test.buildListNode(array1,array2,3,2);
        test.printList(listNodes[0]);
        test.printList(listNodes[1]);
        interactionnODE = solution.getIntersectionNode(listNodes[0],listNodes[1]);
        System.out.println("result:"+interactionnODE+","+(interactionnODE==null?null:interactionnODE.val));

        array1 = new int[]{1};
        array2 = new int[]{1};
        listNodes = test.buildListNode(array1,array2,0,0);
        test.printList(listNodes[0]);
        test.printList(listNodes[1]);
        interactionnODE = solution.getIntersectionNode(listNodes[0],listNodes[1]);
        System.out.println("result:"+interactionnODE+","+(interactionnODE==null?null:interactionnODE.val));

        array1 = new int[]{3};
        array2 = new int[]{2,3};
        listNodes = test.buildListNode(array1,array2,0,1);
        test.printList(listNodes[0]);
        test.printList(listNodes[1]);
        interactionnODE = solution.getIntersectionNode(listNodes[0],listNodes[1]);
        System.out.println("result:"+interactionnODE+","+(interactionnODE==null?null:interactionnODE.val));
    }

    ListNode[] buildListNode(int[] A,int[] B,int skipA,int skipB){
        System.out.println("-----------------------------------------------------------");
        ListNode[] listNodes = new ListNode[2];

        ListNode interaction = buildListNode(A,skipA,A.length-1);
        System.out.println("interaction node:"+(interaction==null?null:interaction.val));


        listNodes[0] = skipA==0?interaction:buildListNode(A,0,skipA-1);
        listNodes[1] = skipB==0?interaction:buildListNode(B,0,skipB-1);

        if(skipA!=0)addInteraction(listNodes[0],interaction);
        if(skipB!=0)addInteraction(listNodes[1],interaction);
        return listNodes;
    }

    ListNode buildListNode(int[] A,int start,int end){
         if(start>end)return null;
         ListNode listNode = new ListNode(A[start]);
         listNode.next = buildListNode(A,start+1,end);
         return listNode;
    }
    void addInteraction(ListNode listNode,ListNode interaction){
        while(listNode.next!=null){
            listNode = listNode.next;
        }
        listNode.next = interaction;
    }
    void printList(ListNode listNodes){
        ListNode listNode = listNodes;
        while(listNode.next!=null){
            System.out.print(""+listNode.val);
            listNode = listNode.next;
        }
        System.out.println(""+listNode.val);
        listNode = listNodes;
        while(listNode.next!=null){
            System.out.print(" "+(""+listNode).split("@")[1]);
            listNode = listNode.next;
        }
        System.out.println(" "+(""+listNode).split("@")[1]);
    }
}


