package leetcode.editor.cn;
//给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。 
//
// 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。 
//
// 以数组形式返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [8,1,2,2,3]
//输出：[4,0,1,1,3]
//解释： 
//对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。 
//对于 nums[1]=1 不存在比它小的数字。
//对于 nums[2]=2 存在一个比它小的数字：（1）。 
//对于 nums[3]=2 存在一个比它小的数字：（1）。 
//对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
// 
//
// 示例 2： 
//
// 输入：nums = [6,5,4,8]
//输出：[2,1,0,3]
// 
//
// 示例 3： 
//
// 输入：nums = [7,7,7,7]
//输出：[0,0,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 500 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 哈希表 
// 👍 88 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int[] smallerNumbersThanCurrent(int[] nums) {
//
//        int[] array = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(nums, 0, nums.length);
//
//        for (int i = 0; i < nums.length; i++) {
//            array[i] = findPos(nums,array[i]);
//        }
//        return array;
//    }
//
//    private int findPos(int[] nums,int target){
//        for (int i = 0; i< nums.length;i++){
//            if(nums[i]==target)return i;
//        }
//        return -1;
//    }

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] array = new int[101];
        for(int i: nums){
            array[i]++;
        }
        for(int j = 1;j<101;j++){
            array[j] += array[j-1];
        }
        for(int i=0;i<nums.length;i++){
            nums[i] = nums[i] ==0?0:array[nums[i]-1];
        }
        return nums;
    }



    public static void main(String[] args) {
        int[] array = {8, 1, 2, 2, 3};
        System.out.println("输入：nums = [8,1,2,2,3];输出：[4,0,1,1,3]:");
        int[] nums = new Solution().smallerNumbersThanCurrent(array);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
        System.out.println();


        array = new int[]{6, 5, 4, 8};
        System.out.println("输入：nums = [6,5,4,8],输出：[2,1,0,3] :");
        nums = new Solution().smallerNumbersThanCurrent(array);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
        System.out.println();

        array = new int[]{7, 7, 7, 7};
        System.out.println("输入：nums = [7,7,7,7],输出：[0,0,0,0] :");
        nums = new Solution().smallerNumbersThanCurrent(array);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
        System.out.println();

        array = new int[]{5,0,10,0,10,6};
        System.out.println("输入：nums = [5,0,10,0,10,6],输出：[2,0,4,0,4,3] :");
        nums = new Solution().smallerNumbersThanCurrent(array);
        Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
        System.out.println();


    }
}
//leetcode submit region end(Prohibit modification and deletion)
