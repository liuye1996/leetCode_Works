package easy1207uniqueOccurrences;

import java.util.*;

/**
 * @Author: ye_liu
 * @Date: 2020/10/28 10:16
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/unique-number-of-occurrences/
     *
     * 1207. 独一无二的出现次数
     * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
     *
     * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
     *
     *
     *
     * 示例 1：
     *
     * 输入：arr = [1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     * 示例 2：
     *
     * 输入：arr = [1,2]
     * 输出：false
     * 示例 3：
     *
     * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= arr.length <= 1000
     * -1000 <= arr[i] <= 1000
     * 通过次数21,007提交次数29,263
     *
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
//        List<Integer> countList = new ArrayList<>(arr.length);
//        for (Integer num :countMap.values()){
//            if (countList.contains(num)){
//                return false;
//            }else{
//                countList.add(num);
//            }
//        }
//        return true;

        Set<Integer> times = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> x : countMap.entrySet()) {
            times.add(x.getValue());
        }
        return times.size() == countMap.size();

    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,2,1,1,3};
        int[] arr2 = new int[]{1,2,2,1,3};
        Solution solution = new Solution();
        System.out.println(solution.uniqueOccurrences(arr1));
        System.out.println(solution.uniqueOccurrences(arr2));
    }
}
