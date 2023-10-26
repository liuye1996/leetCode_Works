package easy2520countTheDigitsThatDivideANumber;

/**
 * @Author: ye_liu
 * @Date: 2023/10/26 9:08
 */
class Solution {


    /**
     * 2520. 统计能整除数字的位数
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
     *
     * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：num = 7
     * 输出：1
     * 解释：7 被自己整除，因此答案是 1 。
     * 示例 2：
     *
     * 输入：num = 121
     * 输出：2
     * 解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
     * 示例 3：
     *
     * 输入：num = 1248
     * 输出：4
     * 解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
     *
     *
     * 提示：
     *
     * 1 <= num <= 109
     * num 的数位中不含 0
     * 通过次数
     * 14K
     * 提交次数
     * 16.7K
     * 通过率
     * 83.7%
     */

    /**
     *> 2023/10/26 09:19:04
     * 解答成功:
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:38.1 MB,击败了40.80% 的Java用户
     * @param num
     * @return
     */
    public int countDigits(int num) {
        int count = 0;
        String numStr = Integer.toString(num);
        for (int i = 0;i<numStr.length();i++){
            if (num % (numStr.charAt(i) - '0') == 0){
                count++;
            }
        }
        return count;
    }

    /**
     * 
     * 官方题解
     *> 2023/10/26 10:05:21
     * 解答成功:
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:38.2 MB,击败了32.24% 的Java用户
     * @param num
     * @return
     */
    public int countDigitsOfficial(int num) {
        int t = num;
        int count = 0;
        while(t != 0){
            if (num % (t % 10) == 0){
                count++;
            }
            t /= 10;
        }
        return count++;
    }

}