package leetcode.editor.cn.Q35;

//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 你可以假设数组中无重复元素。 
//
// 示例 1: 
//
// 输入: [1,3,5,6], 5
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [1,3,5,6], 2
//输出: 1
// 
//
// 示例 3: 
//
// 输入: [1,3,5,6], 7
//输出: 4
// 
//
// 示例 4: 
//
// 输入: [1,3,5,6], 0
//输出: 0
// 
// Related Topics 数组 二分查找 
// 👍 734 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int searchInsert(int[] nums, int target) {
//        int lo=0,hi=nums.length,mid;
//        while(lo<hi){
//            mid = (lo+hi)>>1;
//            if(target > nums[mid]){
//                lo = mid+1 ;
//            }else{
//                hi = mid ;
//            }
//
//        }
//        return lo;
//
//    }

    public int searchInsert(int[] nums, int target) {
        return searchInsert(nums, target, 0, nums.length);
    }

    int searchInsert(int[] nums, int target, int low, int hi) {
        if (low >= hi) return low;
        int mid = (low + hi) >> 1;

        if (target > nums[mid]) return searchInsert(nums, target, mid + 1, hi);
        else {
            return searchInsert(nums, target, low, mid);
        }


    }

}
//leetcode submit region end(Prohibit modification and deletion)


class test {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6};
        Solution solution = new Solution();
        System.out.println("输入: [1,3,5,6], 5 输出: 2" + solution.searchInsert(array, 5));
        System.out.println("输入: [1,3,5,6], 2 输出: 1" + solution.searchInsert(array, 2));
        System.out.println("输入: [1,3,5,6], 7 输出: 4" + solution.searchInsert(array, 7));
        System.out.println("输入: [1,3,5,6], 0 输出: 0" + solution.searchInsert(array, 0));
        array = new int[]{1, 3};
        System.out.println("输入: [1,3], 2 输出: 1" + solution.searchInsert(array, 2));
    }
}


// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
