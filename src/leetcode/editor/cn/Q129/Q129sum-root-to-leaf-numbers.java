package leetcode.editor.cn.Q129;

//给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。 
//
// 例如，从根到叶子节点路径 1->2->3 代表数字 123。 
//
// 计算从根到叶子节点生成的所有数字之和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//    1
//   / \
//  2   3
//输出: 25
//解释:
//从根到叶子节点路径 1->2 代表数字 12.
//从根到叶子节点路径 1->3 代表数字 13.
//因此，数字总和 = 12 + 13 = 25. 
//
// 示例 2: 
//
// 输入: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//输出: 1026
//解释:
//从根到叶子节点路径 4->9->5 代表数字 495.
//从根到叶子节点路径 4->9->1 代表数字 491.
//从根到叶子节点路径 4->0 代表数字 40.
//因此，数字总和 = 495 + 491 + 40 = 1026. 
// Related Topics 树 深度优先搜索 
// 👍 246 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//Definition for a binary tree node.


import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
//    public int sumNumbers(TreeNode root) {
//        return sumNumbers(root, 0);
//    }
//
//    public int sumNumbers(TreeNode root, int parentNum) {
//        if (root == null) return 0;
//        int currentSum = parentNum * 10 + root.val;
//        if (root.left == null && root.right == null) return currentSum;
//        return sumNumbers(root.left, currentSum) + sumNumbers(root.right, currentSum);
//    }

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int sum = 0;
        queue.add(root);
        TreeNode tmp;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (tmp.left == null && tmp.right == null) {
                sum += tmp.val;
            }
            if (tmp.left != null) {
                tmp.left.val += 10 * tmp.val;
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                tmp.right.val += 10 * tmp.val;
                queue.add(tmp.right);
            }

        }
        return sum;

    }


}

//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class test {
    public static void main(String[] args) {
        int[] array = {4, 9, 0, 5, 1};
        TreeNode root = buildTree(array, 0);

        printTree(root);


        Solution solution = new Solution();
        int sum = solution.sumNumbers(root);
        System.out.println("结果为：" + sum);

    }

    public static TreeNode buildTree(int[] array, int index) {
        if (array.length - 1 < index) return null;
        TreeNode node = new TreeNode(array[index]);
        node.left = buildTree(array, index * 2 + 1);
        node.right = buildTree(array, index * 2 + 2);
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


