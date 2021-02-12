package leetcode.editor.cn.Q171;

//给定一个Excel表格中的列名称，返回其相应的列序号。 
//
// 例如， 
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28 
//    ...
// 
//
// 示例 1: 
//
// 输入: "A"
//输出: 1
// 
//
// 示例 2: 
//
// 输入: "AB"
//输出: 28
// 
//
// 示例 3: 
//
// 输入: "ZY"
//输出: 701 
//
// 致谢： 
//特别感谢 @ts 添加此问题并创建所有测试用例。 
// Related Topics 数学 
// 👍 196 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String s) {

        int sum=0;
        for(int i=0;i<s.length();i++){
            int temp= (int)s.charAt(i)-(int)'A'+1;
            sum+=temp*Math.pow(26,s.length()-i-1);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test171{
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        Solution solution = new Solution();

        System.out.println("result:"+solution.titleToNumber("A"));
        System.out.println("result:"+solution.titleToNumber("Z"));
        System.out.println("result:"+solution.titleToNumber("ZY"));

    }
}


