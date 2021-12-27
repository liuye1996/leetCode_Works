package easy0830positionsOfLargeGroups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: ye_liu
 * @Date: 2021/1/5 8:49
 */
public class Solution0830 {

    /**
     * https://leetcode-cn.com/problems/positions-of-large-groups/
     *
     * 830. 较大分组的位置
     * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
     *
     * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     *
     * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
     *
     * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
     *
     * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
     *
     * 示例 1：
     *
     * 输入：s = "abbxxxxzzy"
     * 输出：[[3,6]]
     * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
     * 示例 2：
     *
     * 输入：s = "abc"
     * 输出：[]
     * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
     * 示例 3：
     *
     * 输入：s = "abcdddeeeeaabbbcd"
     * 输出：[[3,5],[6,9],[12,14]]
     * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
     * 示例 4：
     *
     * 输入：s = "aba"
     * 输出：[]
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 仅含小写英文字母
     * 通过次数15,849提交次数31,801
     *
     */

    /**
     * 执行结果：通过
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了43.77%的用户
     */
    public List<List<Integer>> largeGroupPositions0(String s) {
        char[] sCharArray = s.toCharArray();
        int length = s.length();
        List<List<Integer>> resultList = new ArrayList(length);
        int startIndex = 0;
        for(int i=1;i<length;i++){
            if((sCharArray[i] != sCharArray[i-1]) && i-1-startIndex>=3-1){
                List<Integer> thisArea = new ArrayList(3);
                thisArea.add(startIndex);
                thisArea.add(i-1);
                resultList.add(thisArea);
                startIndex = i;
            }else if(sCharArray[i] != sCharArray[i-1]){
                startIndex = i;
            }else if(i==length-1&&i-startIndex>=3-1){
                List<Integer> thisArea = new ArrayList(3);
                thisArea.add(startIndex);
                thisArea.add(i);
                resultList.add(thisArea);
            }
        }
        return resultList;
    }

    /**
     * resultList.add(Arrays.asList(startIndex, i-1));
     * @param s
     * @return
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        char[] sCharArray = s.toCharArray();
        int length = s.length();
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        int startIndex = 0;
        for(int i=1;i<length;i++){
            if(sCharArray[i] != sCharArray[i-1]){
                if(i-1-startIndex>=3-1){
                    resultList.add(Arrays.asList(startIndex, i-1));
                }
                startIndex = i;
            }else if(i==length-1&&i-startIndex>=3-1){
                resultList.add(Arrays.asList(startIndex, i));
            }
        }
        return resultList;
    }


}
