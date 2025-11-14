package easy0009palindromeNumber;

/**
 *  https://leetcode.cn/problems/palindrome-number/description/
 *
 * 9. 回文数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 *
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 *
 *
 * 面试中遇到过这道题?
 * 1/5
 * 是
 * 否
 * 通过次数
 * 1,908,652/3.4M
 * 通过率
 * 56.3%
 */

class Solution {
    /**
     *
     *
     * pass
     * @param x
     * @return
     */

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        // 翻转数字
        String str = x+"";
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}