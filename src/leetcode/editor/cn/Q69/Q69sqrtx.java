package leetcode.editor.cn.Q69;

//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 542 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int mySqrt(int x) {
//        if (x == 0 || x == 1) return x;
//        int lo = 0, hi = x, mid;
//
//        while (lo < hi) {
//            mid = lo + (hi - lo) / 2;
//            if (x < (long) mid * mid) {
//                hi = mid;
//
//            } else {
//                lo = mid + 1;
//            }
//        }
//        return --lo;
//
//    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        double x0 = x, x1;
        while(true){
            x1 = 0.5 *(x0+x/x0);
            if(Math.abs(x1-x0)<1e-7)break;
            x0 = x1;
        }
        return (int)x1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test69 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(8));

    }
}


