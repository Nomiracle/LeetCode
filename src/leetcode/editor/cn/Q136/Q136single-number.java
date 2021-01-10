package leetcode.editor.cn.Q136;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1616 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int singleNumber(int[] nums) {
//        if (nums.length == 1) return nums[0];
//        Arrays.sort(nums);
//        int current = 0, next = 1;
//        while (next < nums.length) {
//            if (nums[current] != nums[next]) {
//                return nums[current];
//            } else {
//                current = next + 1;
//                next = current + 1;
//            }
//        }
//        return nums[current];
//    }

    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test136 {
    public static void main(String[] args) {
        int[] array = {4, 1, 2, 1, 2};
        Solution solution = new Solution();
        System.out.println("result:" + solution.singleNumber(array));

    }
}


