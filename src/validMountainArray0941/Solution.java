package validMountainArray0941;

/**
 * @Author: ye_liu
 * @Date: 2020/11/3 14:13
 */
public class Solution {

    /**
     * 941. 有效的山脉数组
     * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
     *
     * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
     *
     * A.length >= 3
     * 在 0 < i < A.length - 1 条件下，存在 i 使得：
     * A[0] < A[1] < ... A[i-1] < A[i]
     * A[i] > A[i+1] > ... > A[A.length - 1]
     *
     * 示例 1：
     *
     * 输入：[2,1]
     * 输出：false
     *
     * 示例 2：
     *
     * 输入：[3,5,5]
     * 输出：false
     * 示例 3：
     *
     * 输入：[0,3,2,1]
     * 输出：true
     *
     * 提示：
     *
     * 0 <= A.length <= 10000
     * 0 <= A[i] <= 10000
     *
     * 通过次数34,047提交次数86,105
     *
     * @param A
     * @return
     */

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3){
            return false;
        }
        int i = 0;
        int length = A.length;
        while(i + 1 < length && A[i]<A[i+1]){
            i++;
        }
        if(i == 0 || i == length - 1 ){
            return false;
        }
        while(i+1<length && A[i]>A[i+1]){
            i++;
        }
        return i == length - 1;
    }

    /**
     *      * 执行用时：
     *      * 2 ms
     *
     *
     * @param args
     */
//    public boolean validMountainArray(int[] A) {
//        if (A == null || A.length < 3){
//            return false;
//        }
//        boolean isDownFlag = false;
//        for (int i = 1;i< A.length;i++){
//            if (!isDownFlag){
//                if (A[i-1]>A[i]){
//                    if (i==1){
//                        return false;
//                    }
//                    isDownFlag = true;
//                }else if (A[i-1] == A[i]){
//                    return false;
//                }
//            }else{
//                if (A[i-1]<=A[i]){
//                    return false;
//                }
//            }
//        }
//        if (!isDownFlag){
//            return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {

        int[] A = new int[]{3,5,5};
        Solution solution = new Solution();
        System.out.println(solution.validMountainArray(A));

    }
}
