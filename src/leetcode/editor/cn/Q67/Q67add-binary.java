package leetcode.editor.cn.Q67;

//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 514 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int aidx = a.length() - 1, bidx = b.length() - 1, carry = 0, tmp;

        StringBuilder sb = new StringBuilder();
        while (aidx >= 0 || bidx >= 0) {
            tmp = carry;
            if (aidx >= 0) tmp += Integer.parseInt(a.charAt(aidx) + "");
            if (bidx >= 0) tmp += Integer.parseInt(b.charAt(bidx) + "");
            sb.append(tmp % 2);
            carry = tmp / 2;
            aidx--;
            bidx--;
        }
        if(carry == 1)sb.append(1);

        return sb.reverse().toString();

    }


}
//leetcode submit region end(Prohibit modification and deletion)


class test67 {
    public static void main(String[] args) {
        String a = "100", b = "110010";
        Solution solution = new Solution();
        System.out.println("String a = \"100\", b = \"110010\";expect:110110;result:" + solution.addBinary(a, b));

    }
}


