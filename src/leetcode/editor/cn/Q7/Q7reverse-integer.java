package leetcode.editor.cn.Q7;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31, 2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学 
// 👍 2300 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int temp1 = 0, pop, MAXBOUND = Integer.MAX_VALUE / 10, MINBOUND = Integer.MIN_VALUE / 10;
        while (x != 0) {
            pop = x % 10;
            x /= 10;
            if (temp1 > MAXBOUND || (temp1 == MAXBOUND / 10 && pop > 7)) return 0;
            if (temp1 < MINBOUND || (temp1 == MINBOUND && pop < -8)) return 0;

            temp1 = temp1 * 10 + pop;
        }
        return temp1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(123));
    }
}


