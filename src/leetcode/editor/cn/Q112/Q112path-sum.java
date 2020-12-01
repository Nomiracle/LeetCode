package leetcode.editor.cn.Q112;

//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索 
// 👍 469 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
//
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
    //info: 解答成功: //	执行耗时:0 ms,击败了100.00% 的Java用户 //	内存消耗:38.4 MB,击败了75.90% 的Java用户 (a minute ago)
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if(root == null)return false;
//
//        if(root.left==null&&root.right==null&&(sum-root.val)==0)return true;
//
//        return hasPathSum(root.left, sum- root.val)|| hasPathSum(root.right, sum- root.val);
//
//    }

    public boolean hasPathSum(TreeNode root, int sum) {
        System.out.println();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        root.val = sum - root.val;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null && (node.val) == 0) return true;

            if (node.left != null) {
                node.left.val = node.val - node.left.val;
                queue.add(node.left);

            }
            if (node.right != null) {
                node.right.val = node.val - node.right.val;
                queue.add(node.right);
            }


        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test112 {
    public static void main(String[] args) {
        int[] array = {5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, -1, 1};
        TreeNode node = buildTree(array, 0);
        printTree(node);
        Solution solution = new Solution();
        System.out.println("result: " + solution.hasPathSum(node, 22));

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
