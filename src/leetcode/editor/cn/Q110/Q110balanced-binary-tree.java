package leetcode.editor.cn.Q110;

//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 
// 👍 527 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedd(root) >= 0;

    }

    private int isBalancedd(TreeNode root) {
        if (root == null) return 0;
        int left = isBalancedd(root.left);
        if (left < 0) return -1;
        int right = isBalancedd(root.right);
        if (right < 0) return -1;

        if (Math.abs(left - right) >= 2) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class test110 {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, -1, -1, 4, 4};
        TreeNode treeNode = buildTree(array, 0);
        printTree(treeNode);
        Solution solution = new Solution();
        System.out.println("结果：" + solution.isBalanced(treeNode));

        array = new int[]{3, 9, 20, -1, -1, 15, 7};
        treeNode = buildTree(array, 0);
        printTree(treeNode);
        System.out.println("结果：" + solution.isBalanced(treeNode));

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


