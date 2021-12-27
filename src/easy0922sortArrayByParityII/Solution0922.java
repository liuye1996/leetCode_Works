package easy0922sortArrayByParityII;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ye_liu
 * @Date: 2020/11/12 11:21
 */
public class Solution0922 {

    /**
     * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
     *
     * 922. 按奇偶排序数组 II
     * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
     *
     * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
     *
     * 你可以返回任何满足上述条件的数组作为答案。
     *
     *
     *
     * 示例：
     *
     * 输入：[4,2,5,7]
     * 输出：[4,5,2,7]
     * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
     *
     *
     * 提示：
     *
     * 2 <= A.length <= 20000
     * A.length % 2 == 0
     * 0 <= A[i] <= 1000
     *
     *
     * 通过次数48,353提交次数69,334
     *
     */
    /**
     *
     * 执行用时：8 ms, 在所有 Java 提交中击败了 10.75% 的用户
     * 内存消耗：43.2 MB, 在所有 Java 提交中击败了 5.05% 的用户
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {
        int length = A.length;
        if (length == 0){
            return A;
        }
        List<Integer> singleList = new ArrayList<>();
        List<Integer> doubleList = new ArrayList<>();
        for (int thisNum:A){
            if (thisNum % 2 == 0){
                doubleList.add(thisNum);
            }else{
                singleList.add(thisNum);
            }
        }
        int j = 0;
        int k = 0;
        for (int i = 0;i<length;i++){
            if (i % 2 == 0){
                A[i] = doubleList.get(j++);
            }else{
                A[i] = singleList.get(k++);
            }
        }
        return A;
    }


    public int[] sortArrayByParityII2(int[] A) {
        int length = A.length;
        int[] result = new int[length];
        int i = 0;
        for (int thisNum:A){
            if (thisNum % 2 ==0){
                result[i] = thisNum;
                i += 2;
            }
        }
        i = 1;
        for (int thisNum:A){
            if (thisNum % 2 ==1){
                result[i] = thisNum;
                i += 2;
            }
        }
        return result;
    }

}
