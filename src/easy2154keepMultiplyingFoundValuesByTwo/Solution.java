package easy2154keepMultiplyingFoundValuesByTwo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2154. 将找到的值乘以 2
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，另给你一个整数 original ，这是需要在 nums 中搜索的第一个数字。
 *
 * 接下来，你需要按下述步骤操作：
 *
 * 如果在 nums 中找到 original ，将 original 乘以 2 ，得到新 original（即，令 original = 2 * original）。
 * 否则，停止这一过程。
 * 只要能在数组中找到新 original ，就对新 original 继续 重复 这一过程。
 * 返回 original 的 最终 值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,3,6,1,12], original = 3
 * 输出：24
 * 解释：
 * - 3 能在 nums 中找到。3 * 2 = 6 。
 * - 6 能在 nums 中找到。6 * 2 = 12 。
 * - 12 能在 nums 中找到。12 * 2 = 24 。
 * - 24 不能在 nums 中找到。因此，返回 24 。
 * 示例 2：
 *
 * 输入：nums = [2,7,9], original = 4
 * 输出：4
 * 解释：
 * - 4 不能在 nums 中找到。因此，返回 4 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * 1 <= nums[i], original <= 1000
 *
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 28,741/38.6K
 * 通过率
 * 74.5%
 */

public class Solution {


    public int findFinalValue(int[] nums, int original) {
        boolean found = true;
        while (found){
            found = false;
            for (int num : nums) {
                if (num == original) {
                    original = original * 2;
                    found = true;
                    break;
                }
            }
        }
        return original;
    }

    /**
     * 方法一：排序
     * 思路与算法
     *
     * 如果我们不对数组 nums 进行任何操作，那么每次更新 original 后，都需要 O(n) 的时间完整遍历一遍。最终时间复杂度为 O(n
     * 2
     *  )。
     *
     * 我们可以对这一过程进行优化。具体而言，每次在数组中找到 original 后，original 的数值都会比更新前更大，因此我们可以先将数组 nums 升序排序，这样每次更新后的 original 数值在数组中的位置（如有）只可能位于更新前的后面，我们只需要一边从左至右遍历排序后的 nums 数组一边尝试更新 original 即可。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/keep-multiplying-found-values-by-two/solutions/1249143/jiang-zhao-dao-de-zhi-cheng-yi-2-by-leet-blv4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findFinalValue1(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == original) {
                original = original * 2;
            }
        }
        return original;
    }

    /**
     * 方法二：哈希表
     * 思路与算法
     *
     * 我们还可以采用更加直接地利用空间换取时间的方法：利用哈希集合存储数组 nums 中的元素，然后我们只需要每次判断 original 是否位于该哈希集合中即可。具体地：
     *
     * 如果 original 位于哈希集合中，我们将 original 乘以 2，然后再次判断；
     *
     * 如果 original 不位于哈希集合中，那么循环结束，我们返回当前的 original 作为答案。
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/keep-multiplying-found-values-by-two/solutions/1249143/jiang-zhao-dao-de-zhi-cheng-yi-2-by-leet-blv4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findFinalValue2(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(original)) {
            original = original * 2;
        }
        return original;
    }



}
