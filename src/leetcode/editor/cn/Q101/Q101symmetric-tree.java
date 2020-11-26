package leetcode.editor.cn.Q101;

//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1128 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
       return isSymmetric(root.left,root.right);
    }
//    info: 解答成功: //	执行耗时:0 ms,击败了100.00% 的Java用户 //	内存消耗:36.5 MB,击败了83.14% 的Java用户 (moments ago)
    boolean isSymmetric(TreeNode left,TreeNode right){
        if(left == null && right ==null )return true;
        if(left ==null || right ==null)return false;
        if(left.val!=right.val)return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
//info: 解答成功: //	执行耗时:1 ms,击败了28.49% 的Java用户 //	内存消耗:38.1 MB,击败了12.37% 的Java用户 (moments ago)
//    boolean isSymmetric(TreeNode left,TreeNode right){
//        Queue<TreeNode> queue1 = new LinkedList<>(), queue2 = new LinkedList<>();
//        queue1.add(left);
//        queue2.add(right);
//        TreeNode tmp1, tmp2;
//        while (!queue1.isEmpty() && !queue2.isEmpty()) {
//            tmp1 = queue1.poll();
//            tmp2 = queue2.poll();
//            if (tmp1 != null && tmp2 != null) {
//                if (tmp1.val != tmp2.val) return false;
//                queue1.add(tmp1.left);
//                queue1.add(tmp1.right);
//                queue2.add(tmp2.right);
//                queue2.add(tmp2.left);
//            } else if (tmp1 != null || tmp2 != null) {
//                return false;
//            }
//
//        }
//        return queue1.isEmpty() && queue2.isEmpty();
//    }
    
}
//leetcode submit region end(Prohibit modification and deletion)

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class test101{
    public static void main(String[] args) {
        int[] array = {1,2,2,3,4,4,3};
        Solution solution = new Solution();
        TreeNode node = buildTree(array,0);
        printTree(node);
        System.out.println("结果："+solution.isSymmetric(node));

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


