package easy0001twoSum;

import java.util.Arrays;

/**
 * @Author: ye_liu
 * @Date: 2020/10/16 12:44
 */
public class Solution {


    /**
     * https://leetcode-cn.com/problems/two-sum/
     *
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     *
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * 通过次数1,468,911提交次数2,955,498
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0;i<nums.length;i++){
            for(int j = i + 1;j<nums.length;j++){
                if((nums[i]+nums[j] == target)){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int A[] = new int[]{3,2,4};
        int B[] = solution.twoSum(A, 6);
        System.out.println(Arrays.toString(B));

    }

}
