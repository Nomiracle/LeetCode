package leetcode.editor.cn.Q111;

//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 409 👎 0


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
    //info: 解答成功: //	执行耗时:9 ms,击败了8.13% 的Java用户 //	内存消耗:59.5 MB,击败了5.03% 的Java用户 (2 minutes ago)
//    public int minDepth(TreeNode root) {
//        if(root == null)return 0;
//        if(root.left == null && root.right == null)return 1;
//        if(root.left == null)return minDepth(root.right)+1;
//        if(root.right == null)return minDepth(root.left)+1;
//
//        int left = minDepth(root.left),
//                right = minDepth(root.right);
//        return Math.min(left,right)+1;
//    }

    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        Queue<TreeNode>queue = new ArrayDeque<>();
        queue.add(root);
        int current = 1,next = 0,minDepth=0;
        TreeNode node;
        while(!queue.isEmpty()){
            node = queue.poll();
            current --;
            if(node.left == null && node.right == null)break;
            if(node.left!=null){
                queue.offer(node.left);
                next++;
            }
            if(node.right!=null){
                queue.offer(node.right);
                next++;
            }
            if(current==0){
                current = next;
                next = 0;
                minDepth++;
            }

        }


        return minDepth+1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

class test111{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {3,9,20,-1,-1,15,7};
        TreeNode node = buildTree(array,0);
        printTree(node);

        System.out.println("result: "+solution.minDepth(node));
        //解答失败: 测试用例:[2,null,3,null,4,null,5,null,6] 测试结果:1 期望结果:5 stdout:
        array = new int[]{2,-1,3,-1,-1,-1,4};
         node = buildTree(array,0);
        printTree(node);
        System.out.println("result: "+solution.minDepth(node));

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
