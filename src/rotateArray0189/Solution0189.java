package rotateArray0189;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ye_liu
 * @Date: 2021/1/8 14:25
 */
public class Solution0189 {


    /**
     * https://leetcode-cn.com/problems/rotate-array/
     *
     * 189. 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     *
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * 说明:
     *
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     * 通过次数200,254提交次数449,762
     */
    /**
     * 执行结果：
     * 通过
     * 执行用时：232 ms, 在所有 Java 提交中击败了29.81%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了86.86%的用户
     *
     * 暴力法
     *
     * @param nums
     * @param k
     */
    public void rotate0(int[] nums, int k) {
        int length = nums.length;
        if(length==0){
            return;
        }
        for(int j=0;j<k;j++){
            int tmp = nums[length-1];
            for(int i = length-1;i>0;i--){
                nums[i] = nums[i-1];
            }
            nums[0] = tmp;
        }
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if(length==0){
            return;
        }
        List<Integer> cache = new ArrayList<>();
        for(int i=0;i<length;i++){
            if(cache.contains(i)){
                continue;
            }
            int tmp = nums[i];
            int index = i+k > length? (i+k)%k : i+k;
            nums[i] = nums[index];
            nums[index] = tmp;
            cache.add(i);
            cache.add(index);
        }
    }

}
