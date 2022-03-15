package medium0454fourSumCount;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ye_liu
 * @Date: 2020/11/27 9:05
 */
public class Solution0454 {


    /**
     * 454. 四数相加 II
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
     *
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
     *
     * 例如:
     *
     * 输入:
     * A = [ 1, 2]
     * B = [-2,-1]
     * C = [-1, 2]
     * D = [ 0, 2]
     *
     * 输出:
     * 2
     *
     * 解释:
     * 两个元组如下:
     * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     * 通过次数33,003提交次数57,831
     *
     */
    public int fourSumCount1(int[] A, int[] B, int[] C, int[] D) {
        int length = A.length;
        int count=0;
        for (int i=0;i<length;i++){
            for (int j = 0;j<length;j++){
                for (int p=0;p<length;p++){
                    for (int q=0;q<length;q++){
                        if (A[i]+B[j]+C[p]+D[q] == 0){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }



}
