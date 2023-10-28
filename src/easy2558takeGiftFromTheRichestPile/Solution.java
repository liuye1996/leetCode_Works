package easy2558takeGiftFromTheRichestPile;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: ye_liu
 * @Date: 2023/10/28 23:08
 */
public class Solution {

    /**
     *
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 gifts ，表示各堆礼物的数量。每一秒，你需要执行以下操作：
     *
     * 选择礼物数量最多的那一堆。
     * 如果不止一堆都符合礼物数量最多，从中选择任一堆即可。
     * 选中的那一堆留下平方根数量的礼物（向下取整），取走其他的礼物。
     * 返回在 k 秒后剩下的礼物数量。
     *
     *
     *
     * 示例 1：
     *
     * 输入：gifts = [25,64,9,4,100], k = 4
     * 输出：29
     * 解释：
     * 按下述方式取走礼物：
     * - 在第一秒，选中最后一堆，剩下 10 个礼物。
     * - 接着第二秒选中第二堆礼物，剩下 8 个礼物。
     * - 然后选中第一堆礼物，剩下 5 个礼物。
     * - 最后，再次选中最后一堆礼物，剩下 3 个礼物。
     * 最后剩下的礼物数量分别是 [5,8,9,4,3] ，所以，剩下礼物的总数量是 29 。
     * 示例 2：
     *
     * 输入：gifts = [1,1,1,1], k = 4
     * 输出：4
     * 解释：
     * 在本例中，不管选中哪一堆礼物，都必须剩下 1 个礼物。
     * 也就是说，你无法获取任一堆中的礼物。
     * 所以，剩下礼物的总数量是 4 。
     *
     *
     * 提示：
     *
     * 1 <= gifts.length <= 103
     * 1 <= gifts[i] <= 109
     * 1 <= k <= 103
     * 通过次数
     * 25.2K
     * 提交次数
     * 35.3K
     * 通过率
     * 71.4%
     *
     *
     */

    /**
     *
     * 一遍过较为简单
     * > 2023/10/28 23:18:04
     * 解答成功:
     * 	执行耗时:16 ms,击败了29.56% 的Java用户
     * 	内存消耗:39.6 MB,击败了94.58% 的Java用户
     * @param gifts
     * @param k
     * @return
     */
    public long pickGifts(int[] gifts, int k) {
        for(int i = k; i != 0; i--){
            int index = 0;
            for (int j = 0;j<gifts.length;j++){
                index = gifts[index] > gifts[j] ? index : j;
            }
            gifts[index] = (int)Math.sqrt(gifts[index]);
        }
        long sum = 0;
        for (int i = 0;i<gifts.length;i++){
            sum = sum + (long)gifts[i];
        }
        return sum;
    }

    /**
     *
     * 看了题解后发现堆操作比较简单
     * > 2023/10/28 23:27:51
     * 解答成功:
     * 	执行耗时:7 ms,击败了46.80% 的Java用户
     * 	内存消耗:40.1 MB,击败了63.55% 的Java用户
     * @param gifts
     * @param k
     * @return
     */
    public long pickGifts1(int[] gifts, int k) {
        // 顺序队列
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i=0;i<gifts.length;i++){
            pq.add(gifts[i]);
        }
        for (int i = k ; i > 0 ; i--){
            int thisMaxNumber = pq.poll();
            pq.offer((int)Math.sqrt(thisMaxNumber));
        }
        long sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }
        return sum;



    }

}
