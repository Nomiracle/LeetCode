package leetcode.editor.cn.Q125;

//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 302 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    public boolean isPalindrome(String s) {
//        if(s==null || s.length()==0)return true;
//        return isPalindrome(s, 0, s.length() - 1);
//    }
////info: 解答成功: //	执行耗时:12 ms,击败了15.78% 的Java用户 //	内存消耗:56.8 MB,击败了5.02% 的Java用户 (a minute ago)
//    private boolean isPalindrome(String s, int low, int hi) {
//        if (low >= hi) return true;
////        System.out.println(s.substring(low, hi+1));
//
//        if (isInValidCharacter(s.charAt(low))) return isPalindrome(s, low + 1, hi);
//        if (isInValidCharacter(s.charAt(hi))) return isPalindrome(s, low, hi - 1);
//
//        if (Character.toLowerCase(s.charAt(low)) == Character.toLowerCase(s.charAt(hi)))
//            return isPalindrome(s, low + 1, hi - 1);
//        else return false;
//    }
    boolean isInValidCharacter(char c) {
        if ('A' <= c && c <= 'Z') return false;
        if ('a' <= c && c <= 'z') return false;
        return !('0' <= c && c <= '9');
    }
//info: 解答成功: //	执行耗时:2 ms,击败了99.88% 的Java用户 //	内存消耗:38.6 MB,击败了65.68% 的Java用户 (moments ago)
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int low = 0, hi = s.length() - 1;
        while (low < hi) {
            if (isInValidCharacter(s.charAt(low))) {
                low++;
                continue;
            }
            if (isInValidCharacter(s.charAt(hi))) {
                hi--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(low)) == Character.toLowerCase(s.charAt(hi))) {
                low++;
                hi--;
            } else {
                return false;
            }

        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test125 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("result: " + solution.isPalindrome("race a car"));

    }
}


