package leetcode.editor.cn.Q145;
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 697 👎 0

import leetcode.editor.cn.common.utils;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    //    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        postorderTraversal(root,list);
//        return list;
//    }
//
//    private void postorderTraversal(TreeNode root, List<Integer> list) {
//        if(root==null)return;
//        postorderTraversal(root.left,list);
//        postorderTraversal(root.right,list);
//        list.add(root.val);
//    }
    //中右左
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new LinkedList<>();
//        Stack<TreeNode>stack = new Stack<>();
//
//        while (root!=null || !stack.isEmpty()){
//            while (root!=null){
//                stack.push(root);
//                list.add(0,root.val );
//                root = root.right;
//            }
//            root = stack.pop();
//            root = root.left;
//        }
//
//        return list;
//    }

//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        Stack<TreeNode>stack = new Stack<>();
//        TreeNode pre = null;
//        while (root!=null || !stack.isEmpty()){
//            while (root!=null){
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if(root.right==null || root.right==pre){
//                list.add(root.val);
//                pre = root;
//                root = null;
//            }else{
//                stack.push(root);
//                root = root.right;
//            }
//        }
//        return list;
//    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode predecessor;
        root = new TreeNode(-1, root, null);

        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    predecessor.right = null;
                    addnode(root.left, list);
                    root = root.right;
                }
            } else {
                root = root.right;
            }
        }
        return list;
    }

    private void addnode(TreeNode root, List<Integer> list) {
        //遍历链表
        TreeNode cur = reverseList(root);
        while (cur != null) {
            list.add(cur.val);
            cur = cur.right;
        }

        reverseList(root);

    }

    //反转链表
    private TreeNode reverseList(TreeNode head) {
        TreeNode cur = head;
        TreeNode pre = null;
        while (cur != null) {
            TreeNode next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


class test145 {
    static int nullvalue = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] array;
        TreeNode root;

        array= new int[]{1,nullvalue,2,nullvalue,nullvalue,3};
         root = constructTree(array);


        System.out.println(utils.isSameList(
                new ArrayList<>(Arrays.asList(3,2,1)),
                solution.postorderTraversal(root)));

        array = new int[]{1, nullvalue, 2,nullvalue,nullvalue, 3, 4};
        root = constructTree(array);


        System.out.println(utils.isSameList(
                new ArrayList<>(Arrays.asList(3, 4, 2, 1)),
                solution.postorderTraversal(root)));
    }

    // LET Integer.MIN_VALUE REPLACE OF NULL
    private static TreeNode constructTree(int[] array) {
        if (array == null || array.length == 0) return null;


        TreeNode[] treeNodes = new TreeNode[array.length];
        treeNodes[0]=new TreeNode(array[0]);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == nullvalue) {
                continue;
            }
            int left = 2 * i + 1;
            if (left >= array.length) break;
            if(array[left]!=nullvalue){
                treeNodes[left] = new TreeNode(array[left]);
                treeNodes[i].left = treeNodes[left];
            }


            int right = 2 * i + 2;
            if (right >= array.length) break;
            if(array[right]!=nullvalue){
                treeNodes[right] = new TreeNode(array[right]);
                treeNodes[i].right = treeNodes[right];
            }

        }
        return treeNodes[0];
    }
}