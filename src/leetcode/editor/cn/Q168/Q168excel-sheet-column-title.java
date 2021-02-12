package leetcode.editor.cn.Q168;

//给定一个正整数，返回它在 Excel 表中相对应的列名称。 
//
// 例如， 
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 
//    ...
// 
//
// 示例 1: 
//
// 输入: 1
//输出: "A"
// 
//
// 示例 2: 
//
// 输入: 28
//输出: "AB"
// 
//
// 示例 3: 
//
// 输入: 701
//输出: "ZY"
// 
// Related Topics 数学 
// 👍 305 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToTitle(int decimal) {

        int rem;
        StringBuilder hex= new StringBuilder();
        char[] t26chars ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        while(decimal>0)
        {
            decimal-=1;
            rem=decimal%26;
            hex.insert(0, t26chars[rem]);
            decimal=decimal/26;
        }
        return hex.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)


class test168{
    public static void main(String[] args) {
        Solution solution = new Solution();
        for(int i=1;i<29;i++){
            System.out.println((i)+":result:"+solution.convertToTitle(i));
        }

        System.out.println(701+":result:"+solution.convertToTitle(701));
    }
}


