package medium1686stoneGameVI;


/**
 * @Author: ye_liu
 * @Date: 2024/2/2 14:13
 */

import java.util.Arrays;

/**
 * 1686. 石子游戏 VI
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * Alice 和 Bob 轮流玩一个游戏，Alice 先手。
 *
 * 一堆石子里总共有 n 个石子，轮到某个玩家时，他可以 移出 一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准 。双方都知道对方的评判标准。
 *
 * 给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 Alice 和 Bob 认为第 i 个石子的价值。
 *
 * 所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。
 *
 * 请你推断游戏的结果，用如下的方式表示：
 *
 * 如果 Alice 赢，返回 1 。
 * 如果 Bob 赢，返回 -1 。
 * 如果游戏平局，返回 0 。
 *
 *
 * 示例 1：
 *
 * 输入：aliceValues = [1,3], bobValues = [2,1]
 * 输出：1
 * 解释：
 * 如果 Alice 拿石子 1 （下标从 0开始），那么 Alice 可以得到 3 分。
 * Bob 只能选择石子 0 ，得到 2 分。
 * Alice 获胜。
 * 示例 2：
 *
 * 输入：aliceValues = [1,2], bobValues = [3,1]
 * 输出：0
 * 解释：
 * Alice 拿石子 0 ， Bob 拿石子 1 ，他们得分都为 1 分。
 * 打平。
 * 示例 3：
 *
 * 输入：aliceValues = [2,4,3], bobValues = [1,6,7]
 * 输出：-1
 * 解释：
 * 不管 Alice 怎么操作，Bob 都可以得到比 Alice 更高的得分。
 * 比方说，Alice 拿石子 1 ，Bob 拿石子 2 ， Alice 拿石子 0 ，Alice 会得到 6 分而 Bob 得分为 7 分。
 * Bob 会获胜。
 *
 *
 * 提示：
 *
 * n == aliceValues.length == bobValues.length
 * 1 <= n <= 105
 * 1 <= aliceValues[i], bobValues[i] <= 100
 * 请问您在哪类招聘中遇到此题？
 * 1/5
 * 社招
 * 校招
 * 实习
 * 未遇到
 * 通过次数
 * 13.3K
 * 提交次数
 * 21.3K
 * 通过率
 * 62.6%
 */
class Solution {
    /**
     * 简单比较大小失败
     * @param aliceValues
     * @param bobValues
     * @return
     */
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        // 从大到小排序
        Arrays.sort(aliceValues);
        Arrays.sort(bobValues);
        // 比大小
        int aliceScore = 0;
        int bobScore = 0;
        for (int i = 0;i < aliceValues.length / 2;i++){
            if (aliceValues[i] > bobValues[i]){
                aliceScore += aliceValues[i];
            }else if (aliceValues[i] < bobValues[i]){
                bobScore += bobValues[i];
            }
        }
        if (aliceScore > bobScore){
            return 1;
        }else if (aliceScore < bobScore){
            return -1;
        }else{
            return 0;
        }

    }

    /**
     * 查看题解  https://leetcode.cn/problems/stone-game-vi/solutions/2628498/xiang-xi-jie-shi-wei-shi-yao-yao-an-zhao-0zsg/?envType=daily-question&envId=2024-02-02
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/stone-game-vi/solutions/2623533/shi-zi-you-xi-vi-by-leetcode-solution-t2u9/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @return
     */
    public int stoneGameVI1(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[][] values = new int[n][3];
        for (int i = 0; i < n; i++) {
            values[i][0] = aliceValues[i] + bobValues[i];
            values[i][1] = aliceValues[i];
            values[i][2] = bobValues[i];
        }
        Arrays.sort(values, (a, b) -> b[0] - a[0]);
        int aliceSum = 0, bobSum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                aliceSum += values[i][1];
            } else {
                bobSum += values[i][2];
            }
        }
        if (aliceSum > bobSum) {
            return 1;
        } else if (aliceSum == bobSum) {
            return 0;
        } else {
            return -1;
        }


    }
}




















