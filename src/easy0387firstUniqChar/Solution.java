package easy0387firstUniqChar;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: ye_liu
 * @Date: 2020/10/24 20:08
 */
public class Solution {


    /**
     *
     * https://leetcode-cn.com/problems/first-unique-character-in-a-string/submissions/
     * 387. 字符串中的第一个唯一字符
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     *
     *
     * 示例：
     *
     * s = "leetcode"
     * 返回 0
     *
     * s = "loveleetcode"
     * 返回 2
     *
     *
     * 提示：你可以假定该字符串只包含小写字母。
     * @param s
     * @return
     */

    public int firstUniqChar(String s) {
        int length = s.length();
        HashMap<Character, Integer> countMap = new HashMap<>(length);
        for (int i= 0 ;i<length ;i++){
            char thisChar = s.charAt(i);
            countMap.put(thisChar, countMap.getOrDefault(thisChar, 0) + 1 );
        }
        for (int i= 0 ;i<length ;i++) {
            char thisChar = s.charAt(i);
            if(countMap.get(thisChar)==1){
                return i;
            }
        }
        return -1;
    }


    /**
     * 测试用例过长的时候会超时
     */
//    public int firstUniqChar(String s) {
//        char[] stringChar = s.toCharArray();
//        int length = stringChar.length;
//        if (length == 2 && stringChar[0] == stringChar[1]){
//            return -1;
//        }
//        for(int i = 0;i<length;i++){
//            boolean isUniq = true;
//            for (int j = 0;j<length;j++){
//                if(i == j){
//                    continue;
//                }
//                if (stringChar[i] == stringChar[j]){
//                    isUniq = false;
//                }
//            }
//            if (isUniq){
//                return i;
//            }
//        }
//        return -1;
//    }


    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 627 ms
     * , 在所有 Java 提交中击败了
     * 5.20%
     * 的用户
     * 内存消耗：
     * 39 MB
     * , 在所有 Java 提交中击败了
     * 92.37%
     * 的用户
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {

        char[] chars = s.toCharArray();
        int length = chars.length;
        List<Character> stringList = new String(chars).chars().mapToObj(i -> (char) i).collect(Collectors.toList());

        for (int i = 0; i< length;i++){
            Character thisChar = chars[i];
            stringList.remove(thisChar);
            if (!stringList.contains(thisChar) && stringList.indexOf(thisChar)!=0){
                return i;
            }
            stringList.add(thisChar);
        }
        return -1;
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 31 ms
     * , 在所有 Java 提交中击败了
     * 58.33%
     * 的用户
     * 内存消耗：
     * 39.1 MB
     * , 在所有 Java 提交中击败了
     * 88.42%
     * 的用户
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {

        for (int i = 0; i< s.length();i++){
            char thisChar = s.charAt(i);
            if (s.indexOf(thisChar) == s.lastIndexOf(thisChar)){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "loveleetcode";
        String s3 = "cc";
        String s4 = "cocob";
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar(s1));
        System.out.println(solution.firstUniqChar(s2));
        System.out.println(solution.firstUniqChar(s3));
        System.out.println(solution.firstUniqChar(s4));

    }



}
