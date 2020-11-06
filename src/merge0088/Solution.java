package merge0088;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ye_liu
 * @Date: 2020/11/4 15:07
 */
public class Solution {


    /**
     * https://leetcode-cn.com/problems/merge-sorted-array/
     *
     * 88. 合并两个有序数组
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     *
     * 说明：
     *
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     *
     * 示例：
     *
     * 输入：
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * 输出：[1,2,2,3,5,6]
     *
     * 提示：
     *
     * -10^9 <= nums1[i], nums2[i] <= 10^9
     * nums1.length == m + n
     * nums2.length == n
     * 通过次数226,451提交次数463,455
     *
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        return ;
    }



    /**
     *
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 5.09%
     * 的用户
     * 内存消耗：
     * 38.4 MB
     * , 在所有 Java 提交中击败了
     * 91.92%
     * 的用户
     *
     *
     */
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (n==0){
//            return;
//        }
//        int length = m + n;
//        List<Integer> list = new ArrayList<>(length);
//        for (int i = 0;i < m;i++){
//            list.add(nums1[i]);
//        }
//        for (int i = 0;i < n;i++){
//            list.add(nums2[i]);
//        }
//        Collections.sort(list);
//        for (int i = 0;i < length;i++){
//            nums1[i] = list.get(i);
//        }
//    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int m = 0;
        int[] nums2 = new int[]{1};
        int n = 1;
        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);
    }
}
