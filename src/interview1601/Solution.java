package interview1601;

import java.util.Arrays;

/**
 * @Author: ye_liu
 * @Date: 2020/10/16 14:03
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/swap-numbers-lcci/
     *
     * 面试题 16.01. 交换数字
     * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
     *
     * 示例：
     *
     * 输入: numbers = [1,2]
     * 输出: [2,1]
     * 提示：
     *
     * numbers.length == 2
     * 通过次数12,954提交次数15,641
     *
     * @param numbers
     * @return
     */
    public int[] swapNumbers(int[] numbers) {
        return new int[]{numbers[0] - (numbers[0] - numbers[1]), numbers[1] + (numbers[0] - numbers[1])};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int A[] = new int[]{9,2};
        int B[] = solution.swapNumbers(A);
        System.out.println(Arrays.toString(B));
    }

}
