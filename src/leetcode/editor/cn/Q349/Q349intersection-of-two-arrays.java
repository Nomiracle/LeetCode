package leetcode.editor.cn.Q349;

//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 252 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int nums1Cur = 0, nums2Cur = 0;
        while (nums1Cur < nums1.length && nums2Cur < nums2.length) {
            if (nums1[nums1Cur] < nums2[nums2Cur]) nums1Cur++;
            else if (nums1[nums1Cur] > nums2[nums2Cur]) nums2Cur++;
            else {
                set.add(nums1[nums1Cur]);
                nums1Cur++;
            }
        }

        int[] resultarray = new int[set.size()];
        int j = 0;
        for (int i : set) {
            resultarray[j++] = i;
        }

        return resultarray;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Arrays.stream(solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})).forEach(System.out::print);
        System.out.println();
    }
}


