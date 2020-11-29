package leetcode.editor.cn.Q104;

//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 747 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //info: 解答成功: //	执行耗时:0 ms,击败了100.00% 的Java用户 //	内存消耗:38.4 MB,击败了83.83% 的Java用户 (moments ago)
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) +1;
    }
//info: 解答成功: //	执行耗时:2 ms,击败了16.25% 的Java用户 //	内存消耗:38.4 MB,击败了78.04% 的Java用户 (moments ago)
//    public int maxDepth(TreeNode root) {
//        if(root == null)return 0;
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        int current = 1,next = 0,level = 0;
//        TreeNode treeNode;
//        while(!queue.isEmpty()){
//             treeNode = queue.poll();
//            current--;
//            if(treeNode.left!=null){
//                queue.add(treeNode.left);
//                next ++;
//            }
//            if(treeNode.right!=null){
//                queue.add(treeNode.right);
//                next ++;
//            }
//            if(current == 0){
//                level++;
//                current = next;
//                next = 0;
//            }
//
//
//        }
//        return level;
//
//
//    }


}
//leetcode submit region end(Prohibit modification and deletion)
  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class test104{
    public static void main(String[] args) {
        int[] array = {3,9,20,-1,-1,15,7};
        Solution solution = new Solution();
        System.out.println("     3\n" +
                "   / \\\n" +
                "  9  20\n" +
                "    /  \\\n" +
                "   15   7");
        TreeNode treeNode = buildTree(array,0);
        printTree(treeNode);
        System.out.println("结果："+solution.maxDepth(treeNode));
    }
    static TreeNode buildTree(int[] nodes, int index) {
        if (nodes.length <= index || nodes[index] == -1) return null;

        TreeNode node = new TreeNode(nodes[index]);

        node.left = buildTree(nodes, 2 * index + 1);
        node.right = buildTree(nodes, 2 * index + 2);
        return node;
    }

    public static void printTree(TreeNode root) {
        System.out.println();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int currentCount = 1, nextCount = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            currentCount--;

            if (node != null) {
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.add(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextCount++;
                }
            }

            if (currentCount == 0) {
                currentCount = nextCount;
                nextCount = 0;
                System.out.println();
            }

        }

    }
}


