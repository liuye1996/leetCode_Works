package easy0594longestHarmoniousSubsquenceNotFinish;

/**
 * @Author: ye_liu
 * @Date: 2021/11/20 17:31
 */
public class Solution {


    /**
     * 594. 最长和谐子序列
     * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
     *
     * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
     *
     * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,3,2,2,5,2,3,7]
     * 输出：5
     * 解释：最长的和谐子序列是 [3,2,2,2,3]
     * 示例 2：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：2
     * 示例 3：
     *
     * 输入：nums = [1,1,1,1]
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 2 * 104
     * -109 <= nums[i] <= 109
     * 通过次数47,480提交次数85,504
     */

    public int findLHS(int[] nums) {
        int size = nums.length;
        int max = 0;
        for (int i=0;i<size;i++){
            int thisMin = nums[i];
            int thisMax = nums[i];
            int thisMaxCount = 0;
            for(int j = i + 1 ; j < size ; j++){
                thisMin = Math.min(nums[j], thisMin);
                thisMax = Math.max(nums[j], thisMax);
                if ((thisMax-thisMin) <= 1){
                    thisMaxCount++;
                }
            }
            max = thisMaxCount;
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,3,2,2,5,2,3,7};

        System.out.println(solution.findLHS(nums));

    }



}
