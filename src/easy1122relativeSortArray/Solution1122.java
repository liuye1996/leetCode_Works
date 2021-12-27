package easy1122relativeSortArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ye_liu
 * @Date: 2020/11/15 12:26
 */
public class Solution1122 {


    /**
     *
     * https://leetcode-cn.com/problems/relative-sort-array/
     *
     * 1122. 数组的相对排序
     * 给你两个数组，arr1 和 arr2，
     *
     * arr2 中的元素各不相同
     * arr2 中的每个元素都出现在 arr1 中
     * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
     *
     * 示例：
     *
     * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * 输出：[2,2,2,1,4,3,3,9,6,7,19]
     *
     *
     * 提示：
     *
     * arr1.length, arr2.length <= 1000
     * 0 <= arr1[i], arr2[i] <= 1000
     * arr2 中的元素 arr2[i] 各不相同
     * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
     * 通过次数47,790提交次数67,520
     *
     *
      * @param arr1
     * @param arr2
     * @return
     */

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 初始化数组最大长度
        int upper = 0;
        for (int x : arr1) {
            upper = Math.max(upper, x);
        }
        int[] frequency = new int[upper + 1];
        // 数次数
        for (int x : arr1) {
            ++frequency[x];
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int x : arr2) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
            frequency[x] = 0;
        }
        // 利用数组顺序排序
        for (int x = 0; x <= upper; ++x) {
            for (int i = 0; i < frequency[x]; ++i) {
                ans[index++] = x;
            }
        }
        return ans;
    }


    /**
     * 执行结果：超出时间限制
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray0(int[] arr1, int[] arr2) {
        List<Integer> notInArr2List = new ArrayList<>();
        int length1 = arr1.length;
        int length2 = arr2.length;
        int index = 0;
        for (int i = 0;i<length1;i++){
            boolean flag = false;
            for (int j = 0;j<length2;j++){
                if (arr1[i] == arr2[j]){
                    flag = true;
                }
            }
            if (!flag){
                notInArr2List.add(arr1[i]);
            }
        }
        Collections.sort(notInArr2List);
        for (int i = 0;i<length2;i++){
            int thisNum = arr2[i];
            for (int j = 0;j<length1;i++){
                if (arr1[j] == thisNum){
                    arr1[j] = arr1[index];
                    arr1[index] = thisNum;
                    index++;
                }
            }
        }
        int notInIndex = 0;
        for (int i = index;i<length1;i++){
            arr1[i] = notInArr2List.get(notInIndex++);
        }

        return arr1;

    }


}
