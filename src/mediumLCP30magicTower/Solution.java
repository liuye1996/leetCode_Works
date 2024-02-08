package mediumLCP30magicTower;


import java.util.PriorityQueue;

/**
 * LCP 30. 魔塔游戏
 * 中等
 * 相关标签
 * 相关企业
 * 小扣当前位于魔塔游戏第一层，共有 N 个房间，编号为 0 ~ N-1。每个房间的补血道具/怪物对于血量影响记于数组 nums，其中正数表示道具补血数值，即血量增加对应数值；负数表示怪物造成伤害值，即血量减少对应数值；0 表示房间对血量无影响。
 *
 * 小扣初始血量为 1，且无上限。假定小扣原计划按房间编号升序访问所有房间补血/打怪，为保证血量始终为正值，小扣需对房间访问顺序进行调整，每次仅能将一个怪物房间（负数的房间）调整至访问顺序末尾。请返回小扣最少需要调整几次，才能顺利访问所有房间。若调整顺序也无法访问完全部房间，请返回 -1。
 *
 * 示例 1：
 *
 * 输入：nums = [100,100,100,-250,-60,-140,-50,-50,100,150]
 *
 * 输出：1
 *
 * 解释：初始血量为 1。至少需要将 nums[3] 调整至访问顺序末尾以满足要求。
 *
 * 示例 2：
 *
 * 输入：nums = [-200,-300,400,0]
 *
 * 输出：-1
 *
 * 解释：调整访问顺序也无法完成全部房间的访问。
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^5 <= nums[i] <= 10^5
 * 请问您在哪类招聘中遇到此题？
 * 1/5
 * 社招
 * 校招
 * 实习
 * 未遇到
 * 通过次数
 * 13.5K
 * 提交次数
 * 32.5K
 * 通过率
 * 41.7%
 */
public class Solution {

    /**
     * 作者：力扣官方题解
     *     链接：https://leetcode.cn/problems/p0NxJO/solutions/2628589/mo-ta-you-xi-by-leetcode-solution-gkmj/
     *     来源：力扣（LeetCode）
     *     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int magicTower0(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int ans = 0;
        long hp = 1, delay = 0;
        for (int num : nums) {
            if (num < 0) {
                pq.offer(num);
            }
            hp += num;
            if (hp <= 0) {
                ++ans;
                int curr = pq.poll();
                delay += curr;
                hp -= curr;
            }
        }
        hp += delay;
        return hp <= 0 ? -1 : ans;
    }



    public int magicTower(int[] nums) {
        // 先判断无法通过的情况
        int total = 1;
        for (int thisNum:nums) {
            total += thisNum;
        }
        if (total <= 0){
            return -1;
        }
        total = 1;
        int count = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (total + nums[i] <= 0){
                System.out.println("调整前："+ i + "为" + nums[i]);
                switchAllNums(nums, i);
                System.out.println("调整后："+ i + "为" + nums[i]);
                count++;
                i--;
            }else{
                total += nums[i];
            }
        }
        return count;
    }

    private void switchAllNums(int [] nums, int index){
        int indexNum = nums[index];
        for (int i = index;i<nums.length - 1;i++){
            nums[index] = nums[index+1];
        }
        nums[nums.length - 1] = indexNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{100,100,100,-250,-60,-140,-50,-50,100,150};
        System.out.println(solution.magicTower(nums1));

    }

}
