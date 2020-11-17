package leetcode.editor.cn.Q66;

//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 575 👎 0


import java.util.Arrays;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int carry = 0;
        digits[digits.length - 1] += 1;
        int tmp;
        for (int i = digits.length - 1; i >= 0; i--) {
            tmp = digits[i] + carry;
            digits[i] = tmp % 10;
            carry = tmp / 10;
            if (carry == 0) {
                return digits;
            }
        }
        int[] newDig = new int[digits.length + 1];
        newDig[0] = carry;
        System.arraycopy(digits, 0, newDig, 1, digits.length);
        return newDig;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test66 {
    public static void main(String[] args) {
        int[] array = {9, 9};
        Solution solution = new Solution();
        System.out.println(Arrays.stream(solution.plusOne(array)).boxed().collect(Collectors.toList()));

    }
}


