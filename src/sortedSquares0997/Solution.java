package sortedSquares0997;

import java.util.Arrays;

/**
 * @Author: ye_liu
 * @Date: 2020/10/16 11:35
 */
public class Solution {

    /**
     *
     * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
     *
     * 977. 有序数组的平方
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     *
     *
     *
     * 示例 1：
     *
     * 输入：[-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 示例 2：
     *
     * 输入：[-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *
     *
     * 提示：
     *
     * 1 <= A.length <= 10000
     * -10000 <= A[i] <= 10000
     * A 已按非递减顺序排序。
     * 通过次数63,495提交次数86,911
     *
     */
    public int[] sortedSquares(int[] A) {
        int squareArray[] = new int[A.length];
        for(int i = 0;i<A.length;i++){
            squareArray[i] = A[i] * A[i];
        }
        Arrays.sort(squareArray);
        return squareArray;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int A[] = new int[]{-4,-1,0,3,10};
        int B[] = solution.sortedSquares(A);
        System.out.println(Arrays.toString(B));
    }




}
