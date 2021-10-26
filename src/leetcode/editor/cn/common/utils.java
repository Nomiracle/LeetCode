package leetcode.editor.cn.common;


import java.util.List;
import java.util.Objects;
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

    public static boolean isSameList(List<Integer> list1,List<Integer> list2){
        System.out.println(list1 + " , "+ list2);
        if(list1==null||list2==null)return false;
        if(!list1.containsAll(list2)||!list2.containsAll(list1))return false;

        for(int i=0;i<list1.size();i++){
            if(!Objects.equals(list1.get(i), list2.get(i))){
                return false;
            }
        }
        return true;
    }
}
