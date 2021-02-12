package leetcode.editor.cn.Q167;

//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找 
// 👍 455 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        for(int i = 0; i < numbers.length-1;i++){
            answer[0] = i+1;
            answer[1] = binSearch(numbers,i+1,target - numbers[i]);
            if(answer[1]!=-1){
                answer[1]++;
                return answer;
            }
        }
        return null;
    }

    private int binSearch(int[] numbers, int start,int target){
        int end = numbers.length,mid;
        while(start<end){
            mid = (start + end)>>1;
            if(numbers[mid]==target)return mid;
            else if(numbers[mid]<target)start=mid+1;
            else end=mid;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class test167{
    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        Solution solution = new Solution();
        System.out.println("result:"+ Arrays.toString(solution.twoSum(array, 26)));

    }
}


