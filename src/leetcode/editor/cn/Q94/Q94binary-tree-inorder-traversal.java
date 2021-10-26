package leetcode.editor.cn.Q94;
//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1007 👎 0
//import leetcode.editor.cn.common.TreeNode;
import leetcode.editor.cn.common.utils;

import java.util.*;


//Definition for a binary tree node.
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


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        inorderTraversal(root,list);
//        return list;
//    }
//
//    private void inorderTraversal(TreeNode root, List<Integer> list) {
//        if(root==null){
//            return;
//        }
//        inorderTraversal(root.left,list);
//        list.add(root.val);
//        inorderTraversal(root.right,list);
//    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer>list = new ArrayList<>();
//        Stack<TreeNode>stack = new Stack<>();
//        while(root!=null || !stack.isEmpty()){
//            while (root!=null){
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            list.add(root.val);
//            root = root.right;
//        }
//        return list;
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        TreeNode predecessor;
        while(root!=null){
            if(root.left!=null){
                predecessor = root.left;
                while (predecessor.right!=null&&predecessor.right!=root){
                    predecessor=predecessor.right;
                }
                if(predecessor.right==null){
                    predecessor.right = root;
                    root = root.left;
                }else{
                    list.add(root.val);
                    root=root.right;
                    predecessor.right=null;
                }

            }else{
                list.add(root.val);
                root = root.right;
            }

        }
        return list;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


class test94{

     static int nullvalue=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array = new int[]{1,nullvalue,2,3};
        TreeNode root = constructTree(array);


        System.out.println(utils.isSameList(
                new ArrayList<>(Arrays.asList(1,3,2)),
                solution.inorderTraversal(root)));

        array = new int[]{1,2};
        root = constructTree(array);
        System.out.println(utils.isSameList(
                new ArrayList<>(Arrays.asList(2,1)),
                solution.inorderTraversal(root)));
    }
    // LET Integer.MIN_VALUE REPLACE OF NULL
    private static TreeNode constructTree(int[] array){
        if(array==null||array.length==0)return null;

        TreeNode[] treeNodes = new TreeNode[array.length];
        for(int i=0;i<array.length;i++){
            if(array[i]==nullvalue){
                continue;
            }
            if(array[i]!=nullvalue&&treeNodes[i]==null){
                treeNodes[i] = new TreeNode(array[i]);
            }
            int left = i+1;
            if(left<array.length&&array[left]!=nullvalue){
                treeNodes[left]= new TreeNode(array[left]);
                treeNodes[i].left = treeNodes[left];
            }
            int right = i+2;
            if(right<array.length&&array[right]!=nullvalue){
                treeNodes[right]= new TreeNode(array[right]);
                treeNodes[i].right =treeNodes[right];
            }
        }
        return treeNodes[0];
    }


}