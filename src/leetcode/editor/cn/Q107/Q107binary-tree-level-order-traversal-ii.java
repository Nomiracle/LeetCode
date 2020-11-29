package leetcode.editor.cn.Q107;

//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 370 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

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
    //info: 解答成功: //	执行耗时:2 ms,击败了19.63% 的Java用户 //	内存消耗:38.9 MB,击败了70.63% 的Java用户 (moments ago)
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listList = new LinkedList<>();
        if (root == null) return listList;
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int current = 1, next = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            current--;
            list.add(treeNode.val);
            if (treeNode.left != null) {
                queue.add(treeNode.left);
                next++;
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
                next++;
            }
            if (current == 0) {
                listList.add(0,list);
                list = new ArrayList<>();
                current = next;
                next = 0;
            }

        }

        return listList;
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

class test107 {
    public static void main(String[] args) {
        int[] array = {3, 9, 20, -1, -1, 15, 7};
        Solution solution = new Solution();
        TreeNode treeNode = buildTree(array, 0);
        System.out.println("    3\n" +
                "  / \\\n" +
                " 9  20\n" +
                "   /  \\\n" +
                "  15   7");
        printTree(treeNode);
        System.out.println("结果：" + solution.levelOrderBottom(treeNode));

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


