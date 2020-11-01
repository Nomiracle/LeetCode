package leetcode.editor.cn.common;


import java.util.Stack;

public class utils {
    public void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (!stack.empty()||t!=null){
            if(t!=null){

                stack.push(t);
                t = t.left;
                for (TreeNode node:stack){
                    System.out.print(node.val);
                }
                System.out.println();
            }else{
                t = stack.pop();
                t=t.right;
            }
        }

    }
}
