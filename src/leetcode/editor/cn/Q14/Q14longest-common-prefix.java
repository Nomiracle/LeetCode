package leetcode.editor.cn.Q14;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1328 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    //solution 1 :竖直比较
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) return "";
//        int i = 0;
//        String shortest = strs[0];
//        while (i < shortest.length()) {
//            for (String str : strs) {
//                if (str.length() == i || str.charAt(i) != shortest.charAt(i)) {
//                    return shortest.substring(0, i);
//                }
//            }
//
//            i++;
//        }
//        return shortest;
//    }

//    //solution 2 :横直比较
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) return "";
//        if (strs.length == 1) return strs[0];
//
//        StringBuilder shortest= new StringBuilder(strs[0]);
//        for (int j = 1; j < strs.length; j++) {
//            intersection(shortest,strs[j]);
//        }
//        return shortest.toString();
//    }
//    private static void intersection(StringBuilder stringBuilder,String str2){
//        int i=0;
//        while(i< stringBuilder.length()&&i<str2.length()){
//            if(stringBuilder.charAt(i)!=str2.charAt(i)){
//                break;
//            }
//            i++;
//        }
//
//        for(int ind = stringBuilder.length()-1;ind>=i;ind--){
//            stringBuilder.deleteCharAt(ind);
//        }
//    }

//    //solution 3 :分治
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) return "";
//        if (strs.length == 1) return strs[0];
//
//        return intersection(strs, 0, strs.length - 1);
//
//    }
//
//    private static String intersection(String[] strs, int lo, int hi) {
//        if (lo == hi) return strs[lo];
//        if ("".equals(strs[lo]) || "".equals(strs[hi])) return "";
//
//
//        int mid = (lo + hi) / 2;
//
//        String left = intersection(strs, lo, mid);
//        String right = intersection(strs, mid + 1, hi);
//        int i = 0;
//        while (i < left.length() && i < right.length()) {
//            if (left.charAt(i) != right.charAt(i)) {
//                break;
//            }
//            i++;
//        }
//        return left.substring(0, i);
//
//    }


    //    solution 4 :二分
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int i = 0;
        String shortest = strs[0];
        for(String s : strs){
            shortest = shortest.length()>s.length()?s:shortest;
        }

        int low =0,hi = shortest.length()-1,mid;
        while (low<=hi) {
            mid = (low+hi)/2;
            if(longestCommonPrefix(strs,low,mid,shortest)){
                low = mid+1;
            }else{
                hi = mid -1;
            }

        }
        return shortest.substring(0,low);
    }
    public boolean longestCommonPrefix(String[] strs,int start,int end,String shortest) {
        for(int i = start;i<=end;i++){
            char temp = shortest.charAt(i);
            for(String s : strs){
                if(s.charAt(i)!=temp){
                    return false;
                }
            }

        }
        return true;
    }



}
//leetcode submit region end(Prohibit modification and deletion)


class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"ab", "a"}));

    }
}


