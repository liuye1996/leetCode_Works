package fibonacciNumber0509;

/**
 * @Author: ye_liu
 * @Date: 2021/1/4 13:43
 */
public class Solution0509 {

    /**
     * https://leetcode-cn.com/problems/fibonacci-number/
     *
     * 509. 斐波那契数
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     *
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给你 n ，请计算 F(n) 。
     *
     * 示例 1：
     *
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
     * 示例 2：
     *
     * 输入：3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2
     * 示例 3：
     *
     * 输入：4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3
     *
     * 提示：
     *
     * 0 <= n <= 30
     * 通过次数117,576提交次数173,852
     *
     * @param n
     * @return
     */
    /**
     * 执行结果：通过
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：35.1 MB, 在所有 Java 提交中击败了75.88%的用户
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        int[] reslutArray = new int[n+1];
        reslutArray[0] = 0;
        reslutArray[1] = 1;
        for(int i=2;i<=n;i++){
            reslutArray[i] = reslutArray[i-1]+reslutArray[i-2];
        }
        return reslutArray[n];
    }

}
