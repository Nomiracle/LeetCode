package leetcode.editor.cn.Q119;

//给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 3
//输出: [1,3,3,1]
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(k) 空间复杂度吗？ 
// Related Topics 数组 
// 👍 200 👎 0


import java.util.ArrayList;
import java.util.List;

//   [1],
//   [1,1],
//   [1,2,1],
//   [1,3,3,1],
//   [1,4,6,4,1]
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //info: 解答成功: //	执行耗时:1 ms,击败了78.89% 的Java用户 //	内存消耗:36.2 MB,击败了71.72% 的Java用户 (moments ago)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        if (rowIndex < 0) return result;
        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            result.add(i, 1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test119 {
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        Solution solution = new Solution();
        System.out.println(solution.getRow(3));
    }
}


