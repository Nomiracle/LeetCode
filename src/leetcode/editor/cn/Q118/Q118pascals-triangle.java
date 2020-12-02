package leetcode.editor.cn.Q118;

//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 380 👎 0


import java.util.LinkedList;
import java.util.List;
//   [1],
//   [1,1],
//   [1,2,1],
//   [1,3,3,1],
//   [1,4,6,4,1]
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //info: 解答成功: //	执行耗时:1 ms,击败了60.64% 的Java用户 //	内存消耗:36.4 MB,击败了45.09% 的Java用户 (6 minutes ago)
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if(numRows <=0) return result;
        List<Integer> pre = new LinkedList<>(),current;
        result.add(pre);
        pre.add(1);
        for(int i = 2;i<=numRows;i++){
            current = new LinkedList<>();
            for(int j =0;j<i;j++){
                if(j==0||j==i-1)current.add(1);
                else {
                    current.add(pre.get(j)+ pre.get(j-1));
                }

            }
            pre = current;result.add(current);

        }
        return result;
    }


}
//leetcode submit region end(Prohibit modification and deletion)


class test118{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("result :" + solution.generate(5));

    }
}


