package easy2129capitalizeTheTitle;

public class Solution {


    /**
     * 2129. 将标题首字母大写
     * 简单
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
     *
     * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
     * 否则，将单词首字母大写，剩余字母变成小写。
     * 请你返回 大写后 的 title 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：title = "capiTalIze tHe titLe"
     * 输出："Capitalize The Title"
     * 解释：
     * 由于所有单词的长度都至少为 3 ，将每个单词首字母大写，剩余字母变为小写。
     * 示例 2：
     *
     * 输入：title = "First leTTeR of EACH Word"
     * 输出："First Letter of Each Word"
     * 解释：
     * 单词 "of" 长度为 2 ，所以它保持完全小写。
     * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
     * 示例 3：
     *
     * 输入：title = "i lOve leetcode"
     * 输出："i Love Leetcode"
     * 解释：
     * 单词 "i" 长度为 1 ，所以它保留小写。
     * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
     *
     *
     * 提示：
     *
     * 1 <= title.length <= 100
     * title 由单个空格隔开的单词组成，且不含有任何前导或后缀空格。
     * 每个单词由大写和小写英文字母组成，且都是 非空 的。
     * 请问您在哪类招聘中遇到此题？
     * 1/5
     * 社招
     * 校招
     * 实习
     * 未遇到
     * 通过次数
     * 15K
     * 提交次数
     * 22.7K
     * 通过率
     * 66.0%
     * @param title
     * @return
     */
    /**
     * 执行用时分布
     * 9
     * ms
     * 击败
     * 9.82%
     * 使用 Java 的用户
     * 消耗内存分布
     * 41.66
     * MB
     * 击败
     * 19.63%
     * 使用 Java 的用户
     * @param title
     * @return
     */
    public String capitalizeTitle(String title) {
        if (null == title || title.length() == 0){
            return title;
        }
        title = title.toLowerCase();
        int thisFirstIndex = 0;
        int thisLength = 0;
        for(int i = 0;i < title.length(); i++){
            if (title.charAt(i) == ' ' || i == title.length() - 1){
                if (i == title.length() - 1){
                    thisLength++;
                }
                if (thisLength > 2){
                    title = title.substring(0, thisFirstIndex) + Character.toUpperCase(title.charAt(thisFirstIndex)) + title.substring(thisFirstIndex + 1);
                }
                thisFirstIndex = i + 1;
                thisLength = 0;
            }else{
                thisLength++;
            }
        }
        return title;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.capitalizeTitle("ZW Cl pyR uoC"));

    }


}
