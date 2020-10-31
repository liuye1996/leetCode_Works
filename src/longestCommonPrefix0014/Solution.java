package longestCommonPrefix0014;

/**
 * @Author: ye_liu
 * @Date: 2020/10/31 15:56
 */
public class Solution {


    /**
     *
     *
     * 14. 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     *
     * 通过次数388,032提交次数998,229
     *
     *
     * @param strs
     * @return
     */




    /**
     * 官方解法为两个两个字符串比较
     *
     * 2ms
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for(int i = 1;i<strs.length;i++){
            prefix = getPrefixByTwo(prefix, strs[i]);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    private String getPrefixByTwo(String lastPrefix, String compareStr){
        int length = Math.min(lastPrefix.length(), compareStr.length());
        int index  = 0;
        while (index< length && lastPrefix.charAt(index) == compareStr.charAt(index)){
            index++;
        }
        return lastPrefix.substring(0, index);
    }


        /**
        * 1ms
        */
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 1){
//            return strs[0];
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        int minLength = Integer.MAX_VALUE;
//        for(String str : strs){
//            minLength = str.length() < minLength ? str.length() : minLength;
//        }
//        for (int i=0;i<minLength;i++){
//            char compareChar = '0';
//            boolean isEquals = false;
//            for (String str : strs){
//                char thisChar = str.charAt(i);
//                if (compareChar == '0'){
//                    compareChar = thisChar;
//                }else if (compareChar == thisChar){
//                    isEquals = true;
//                }else{
//                    isEquals = false;
//                    break ;
//                }
//            }
//            if (isEquals){
//                stringBuilder.append(compareChar);
//            }else{
//                break ;
//            }
//        }
//        return stringBuilder.toString();
//    }


}
