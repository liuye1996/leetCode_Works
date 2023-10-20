package easy1652defuseTheBomb;

import java.util.Arrays;

/**
 * @Author: ye_liu
 * @Date: 2023/10/19 18:37
 */
public class Solution {


    /**
     * https://leetcode.cn/problems/defuse-the-bomb/description/
     *
     * 1652.拆炸弹
     *
     * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
     *
     * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
     *
     * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
     * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
     * 如果 k == 0 ，将第 i 个数字用 0 替换。
     * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
     *
     * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
     *
     *
     *
     * 示例 1：
     *
     * 输入：code = [5,7,1,4], k = 3
     * 输出：[12,10,16,13]
     * 解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。
     * 示例 2：
     *
     * 输入：code = [1,2,3,4], k = 0
     * 输出：[0,0,0,0]
     * 解释：当 k 为 0 时，所有数字都被 0 替换。
     * 示例 3：
     *
     * 输入：code = [2,4,9,3], k = -2
     * 输出：[12,5,6,13]
     * 解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
     *
     *
     * 提示：
     *
     * n == code.length
     * 1 <= n <= 100
     * 1 <= code[i] <= 100
     * -(n - 1) <= k <= n - 1
     * 通过次数
     * 38.3K
     * 提交次数
     * 57.6K
     * 通过率
     * 66.5%
     */

    /**
     * 暴力法
     *
     * 时间
     * 详情
     * 2ms
     * 击败 17.13%使用 Java 的用户
     *
     * 内存
     * 详情
     * 39.19MB
     * 击败 75.93%使用 Java 的用户
     *
     * @param code
     * @param k
     * @return
     */
    public int[] decrypt(int[] code, int k) {
        if (0==k){
            Arrays.fill(code, 0);
            return code;
        }
        int[] result = new int[code.length];
        for(int i = 0;i<code.length;i++){
            int sum = 0;
            int index = i;
            for (int j = 1; j <= Math.abs(k) ; j++){
                if ( k > 0){
                    index += 1;
                    if ( index == code.length){
                        index = 0;
                    }
                }else {
                    index -= 1;
                    if (index == -1){
                        index = code.length-1;
                    }
                }
                sum += code[index];
            }
            result[i] = sum;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] code1 = new int[]{5,7,1,4};
        int k1 = 3;
        int[] code2 = new int[]{1,2,3,4};
        int k2 = 0;
        int[] code3 = new int[]{2,4,9,3};
        int k3 = -2;
        System.out.println(Arrays.toString(solution.decrypt(code1, k1)));
        System.out.println(Arrays.toString(solution.decrypt(code2, k2)));
        System.out.println(Arrays.toString(solution.decrypt(code3, k3)));
    }

}
