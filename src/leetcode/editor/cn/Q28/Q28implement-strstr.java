package leetcode.editor.cn.Q28;

//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 615 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int strStr(String haystack, String needle) {
//        if ("".equals(needle)) return 0;
//
//        int idx = 0, nidx = 0;
//        while (idx < haystack.length() && nidx < needle.length()) {
//            if (haystack.charAt(idx) == needle.charAt(nidx)) {
//                idx++;
//                nidx++;
//            } else {
//                idx = idx - nidx + 1;
//                nidx = 0;
//            }
//        }
//        return nidx == needle.length() ? idx - nidx : -1;
//    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;

        int[] next = buildNext(needle);
        int j = 0, i = 0;
        while (j < haystack.length() && i < needle.length()) {
            if (0 > i || haystack.charAt(j) == needle.charAt(i)) {
                ++j;
                ++i;
            } else {
                i = next[i];
            }
        }

        return i == needle.length() ? j - i : -1;
    }

    private int[] buildNext(String needle) {
        int len = needle.length();
        int[] N = new int[len];
        int j = 0, t = -1;
        N[0] = t;
        while (j < len - 1) {
            if (0 > t || needle.charAt(j) == needle.charAt(t)) {
                ++j;
                ++t;
                N[j] = needle.charAt(j) == needle.charAt(t) ? N[t] : t;
            } else {
                t = N[t];
            }

        }
        return N;

    }


}
//leetcode submit region end(Prohibit modification and deletion)


class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("00012", "1"));

    }
}


