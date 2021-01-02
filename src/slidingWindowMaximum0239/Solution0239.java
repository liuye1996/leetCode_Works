package slidingWindowMaximum0239;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: ye_liu
 * @Date: 2021/1/2 14:02
 */
public class Solution0239 {


    /**
     * https://leetcode-cn.com/problems/sliding-window-maximum/
     *
     * 239. 滑动窗口最大值
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     *
     * 输入：nums = [1], k = 1
     * 输出：[1]
     * 示例 3：
     *
     * 输入：nums = [1,-1], k = 1
     * 输出：[1,-1]
     * 示例 4：
     *
     * 输入：nums = [9,11], k = 2
     * 输出：[11]
     * 示例 5：
     *
     * 输入：nums = [4,-2], k = 2
     * 输出：[4]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     * 通过次数102,155提交次数207,612
     *
     */
    /**
     * 超出时间限制
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow0(int[] nums, int k) {
        int length = nums.length;
        int[] resultArray = new int[length-k+1];
        int index = -1;
        for (int i=0;i<length-k+1;i++){
            int max = Integer.MIN_VALUE;
            if (index >= i && index <= index+k-1){
                max = resultArray[i-1];
            }
            for (int j=i;j<i+k;j++){
                if (nums[j] > max){
                    max = nums[j];
                    index = j;
                }
                if (j==i+k-1){
                    resultArray[i] = max;
                }
            }
        }
        return resultArray;
    }

    /**
     * 继续做出优化，若index在范围内，只比较最后一个数
     *
     * 超出时间限制
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int length = nums.length;
        int[] resultArray = new int[length-k+1];
        int index = -1;
        for (int i=0;i<length-k+1;i++){
            // 若上一轮的最大值比最后一个数字小则跳过本次循环
            // 效率还是不够高
            if (index >= i && index <= index+k-1 && nums[i+k-1]>resultArray[i-1]){
                index = i+k-1;
                resultArray[i] = nums[i+k-1];
                continue;
            }
            int max = Integer.MIN_VALUE;
            for (int j=i;j<i+k;j++){
                if (nums[j] > max){
                    max = nums[j];
                    index = j;
                }
                if (j==i+k-1){
                    resultArray[i] = max;
                }
            }
        }
        return resultArray;
    }

    /**
     * https://leetcode-cn.com/problems/sliding-window-maximum/solution/hua-dong-chuang-kou-zui-da-zhi-by-leetco-ki6m/
     *
     *
     * 后期需要结合labuladuo的教程再看一遍
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

}
