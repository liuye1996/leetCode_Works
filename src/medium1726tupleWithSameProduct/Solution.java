package medium1726tupleWithSameProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: ye_liu
 * @Date: 2023/10/19 15:27
 */
public class Solution {


    /**
     * https://leetcode.cn/problems/tuple-with-same-product/description/
     *
     *
     *
     * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,3,4,6]
     * 输出：8
     * 解释：存在 8 个满足题意的元组：
     * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
     * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
     * 示例 2：
     *
     * 输入：nums = [1,2,4,5,10]
     * 输出：16
     * 解释：存在 16 个满足题意的元组：
     * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
     * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
     * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
     * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 1000
     * 1 <= nums[i] <= 104
     * nums 中的所有元素 互不相同
     * 通过次数
     * 21.2K
     * 提交次数
     * 33.9K
     * 通过率
     * 62.4%
     *
     *
     *
     */
    /**
     * Time Limit Exceeded
     *
     * 超时
     * @param nums
     * @return
     */
    public int tupleSameProduct(int[] nums) {
        AtomicInteger count = new AtomicInteger();
        Map<Integer, List<Integer>> listMap = new HashMap<>(nums.length);
        for(int i = 0 ; i < nums.length; i++){
            for(int j = 0; j< nums.length ; j++){
                if (i == j){
                    continue;
                }
                List<Integer> thisList = listMap.getOrDefault(nums[i], new ArrayList<>(nums.length));
                thisList.add(nums[i] * nums[j]);
                listMap.put(nums[i], thisList);
            }
        }
        listMap.forEach((number1, valueList1)->{
            listMap.forEach((number2, valueList2)->{
                if (number1.equals(number2)){
                    return;
                }
                valueList1.forEach(value1->{
                    valueList2.forEach(value2->{
                        if (value1.equals(value2)) {
                            count.getAndIncrement();
                        }
                    });
                });
            });
        });
        return count.get() - nums.length * (nums.length - 1);
    }

    /**
     * https://leetcode.cn/problems/tuple-with-same-product/solutions/1860225/by-dai-v3-prhk/
     * @param nums
     * @return
     */
    public int tupleSameProduct2(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int len=nums.length;
        int count=0;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                int key=nums[i]*nums[j];
                int val=map.getOrDefault(key,0);
                map.put(key,val+1);
                count+=val;
            }
        }
        return count<<3;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = new int[]{1,2,4,5,10};
        int nums2[] = new int[]{2,3,4,6};
        System.out.println(solution.tupleSameProduct2(nums));
        System.out.println(solution.tupleSameProduct2(nums2));
    }



}
