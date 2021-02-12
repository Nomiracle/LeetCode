package leetcode.editor.cn.Q172;

//给定一个整数 n，返回 n! 结果尾数中零的数量。 
//
// 示例 1: 
//
// 输入: 3
//输出: 0
//解释: 3! = 6, 尾数中没有零。 
//
// 示例 2: 
//
// 输入: 5
//输出: 1
//解释: 5! = 120, 尾数中有 1 个零. 
//
// 说明: 你算法的时间复杂度应为 O(log n) 。 
// Related Topics 数学 
// 👍 398 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int trailingZeroes(int n) {
//        int fives=0;
//
//        for(int i=5;i<=n;i+=5){
//            int j=i;
//
//            while(j!=0){
//                if(j%5==0){
//                    fives++;
//                    j/=5;
//                }
//                else break;
//            }
//
//        }
//
//        return fives;
//
//    }
    // fives = n/5 + n/25 + n/125+ ...
    public int trailingZeroes(int n) {
        int fives=0;
        while(n>0){
            fives+=n/5;
            n/=5;
        }
        return fives;

    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test172{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("result:"+solution.trailingZeroes(30));

    }
}


