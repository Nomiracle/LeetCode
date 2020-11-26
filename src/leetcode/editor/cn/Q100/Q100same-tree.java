package leetcode.editor.cn.Q100;

//给定两个二叉树，编写一个函数来检验它们是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 示例 1: 
//
// 输入:       1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//输出: true 
//
// 示例 2: 
//
// 输入:      1          1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//输出: false
// 
//
// 示例 3: 
//
// 输入:       1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//输出: false
// 
// Related Topics 树 深度优先搜索 
// 👍 518 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.LinkedList;
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
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p==null&&q==null)return true;
//        if(p==null||q==null)return false;
//        if(p.val == q.val)
//            return isSameTree( p.left,  q.left) && isSameTree( p.right,  q.right);
//        else
//            return false;
//    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1 = new LinkedList<>(), queue2 = new LinkedList<>();
        queue1.add(p);
        queue2.add(q);
        TreeNode tmp1, tmp2;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            tmp1 = queue1.poll();
            tmp2 = queue2.poll();
            if (tmp1 != null && tmp2 != null) {
                if (tmp1.val != tmp2.val) return false;
                queue1.add(tmp1.left);
                queue2.add(tmp2.left);
                queue1.add(tmp1.right);
                queue2.add(tmp2.right);
            } else if (tmp1 != null || tmp2 != null) {
                return false;
            }

        }
        return queue1.isEmpty() && queue2.isEmpty();
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


class test100 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        TreeNode node1, node2;

//        node1 = buildTree(new int[]{1, 2, 3}, 0);
//        node2 = buildTree(new int[]{1, 2, 3}, 0);
//        printTree(node1);
//        System.out.println(" 输入:       1         1\n" +
//                "          / \\       / \\\n" +
//                "         2   3     2   3\n" +
//                "\n" +
//                "        [1,2,3],   [1,2,3]");
//        System.out.println("比较结果 ： " + solution.isSameTree(node1, node2));
//
//        System.out.println("输入:      1          1\n" +
//                "         /           \\\n" +
//                "        2             2\n" +
//                "       [1,2],     [1,null,2]");
//        node1 = buildTree(new int[]{1, 2}, 0);
//        node2 = buildTree(new int[]{1, -1, 2}, 0);
//        printTree(node1);
//        printTree(node2);
//        System.out.println("比较结果 ： " + solution.isSameTree(node1, node2));

        node1 = buildTree(new int[]{1, 2, 1}, 0);
        node2 = buildTree(new int[]{1, 1, 2}, 0);
        printTree(node1);
        printTree(node2);
        System.out.println(" 输入:       1         1\n" +
                "          / \\       / \\\n" +
                "         2   1     1   2\n" +
                "\n" +
                "        [1, 2, 1],   [1, 1, 2]");
        System.out.println("比较结果 ： " + solution.isSameTree(node1, node2));
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


