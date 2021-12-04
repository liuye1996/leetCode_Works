package easy0383ransomNote;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ye_liu
 * @Date: 2021/12/4 15:13
 */
public class Solution {


    /**
     *
     * 383. 赎金信
     * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
     *
     * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
     *
     * 如果可以构成，返回 true ；否则返回 false 。
     *
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     *
     *
     *
     * 示例 1：
     *
     * 输入：ransomNote = "a", magazine = "b"
     * 输出：false
     * 示例 2：
     *
     * 输入：ransomNote = "aa", magazine = "ab"
     * 输出：false
     * 示例 3：
     *
     * 输入：ransomNote = "aa", magazine = "aab"
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= ransomNote.length, magazine.length <= 105
     * ransomNote 和 magazine 由小写英文字母组成
     * 通过次数97,894提交次数155,130
     *
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    /**
     * 执行结果: 通过
     *
     * 执行用时：20 ms, 在所有 Java 提交中击败了5.04%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了18.19%的用户
     * 通过测试用例：126 / 126
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> magazineCount = new HashMap<>();
        char[] magazineCharArray = magazine.toCharArray();
        for (char c : magazineCharArray) {
            int thisCount = magazineCount.getOrDefault(String.valueOf(c), 0);
            magazineCount.put(String.valueOf(c), thisCount + 1);
        }
        Map<String, Integer> ransomNoteCount = new HashMap<>();
        char[] ranCharArray = ransomNote.toCharArray();
        for (char c : ranCharArray) {
            int thisCount = ransomNoteCount.getOrDefault(String.valueOf(c), 0);
            thisCount++;
            ransomNoteCount.put(String.valueOf(c), thisCount);
            if (thisCount > magazineCount.getOrDefault(String.valueOf(c), 0)){
                return false;
            }
        }
        return true;
    }

    /**
     * 126 / 126 个通过测试用例
     * 状态：通过
     * 执行用时: 1 ms
     * 内存消耗: 38.9 MB
     */
    public boolean canConstruct2(String ransomNote, String magazine) {
        if (magazine.length()<ransomNote.length()){
            return false;
        }
        int[] magCount = new int[26];
        for(char c:magazine.toCharArray()){
            magCount[c - 'a']++;
        }
        for(char c: ransomNote.toCharArray()){
            magCount[c - 'a']--;
            if (magCount[c-'a']<0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a", "b"));
        System.out.println(solution.canConstruct("aa", "ab"));
        System.out.println(solution.canConstruct("aa", "aab"));
        System.out.println(solution.canConstruct("a", "aaab"));

    }

}
