package reverseInteger0007;

/**
 * @Author: ye_liu
 * @Date: 2021/1/4 15:49
 */
public class Solution0007 {


    /**
     * https://leetcode-cn.com/problems/reverse-integer/
     *
     * 7. 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * 通过次数549,774提交次数1,577,324
     */

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：11 ms, 在所有 Java 提交中击败了5.47%的用户
     * 内存消耗：36 MB, 在所有 Java 提交中击败了22.02%的用户
     *
     * 效率太低
     */
    public int reverse0(int x) {
        boolean isMinus = x < 0;
        if (x == Integer.MIN_VALUE){
            return 0;
        }
        if (isMinus){
            x = -x;
        }
        String xString = x + "";
        int length = xString.length();
        if (length==1){
            return x;
        }
        char[] xCharArray = xString.toCharArray();
        for(int i = 0 ;i<=(length-1)/2;i++){
            char tmp = xCharArray[i];
            xCharArray[i] = xCharArray[length-1-i];
            xCharArray[length-1-i] = tmp;
        }
        xString = String.valueOf(xCharArray);
        long xLong = Long.parseLong(xString);
        if (xLong > Integer.MAX_VALUE){
            return 0;
        }
        x = Integer.parseInt(xString);
        return isMinus? -x : x;
    }

    public int reverse(int x) {

        return 0;
    }

    public static void main(String[] args) {
        Solution0007 solution0007 = new Solution0007();
        solution0007.reverse(-2147483648);

    }

}
