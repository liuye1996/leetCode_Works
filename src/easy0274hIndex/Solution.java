package easy0274hIndex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ye_liu
 * @Date: 2023/10/29 15:26
 */
public class Solution {


    /**
     * 274. H 指数
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
     *
     * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。
     *
     *
     *
     * 示例 1：
     *
     * 输入：citations = [3,0,6,1,5]
     * 输出：3
     * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
     *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
     * 示例 2：
     *
     * 输入：citations = [1,3,1]
     * 输出：1
     *
     *
     * 提示：
     *
     * n == citations.length
     * 1 <= n <= 5000
     * 0 <= citations[i] <= 1000
     * 通过次数
     * 113.1K
     * 提交次数
     * 249.9K
     * 通过率
     * 45.2%
     */

    /**
     * > 2023/10/30 18:17:11
     * 解答成功:
     * 	执行耗时:1 ms,击败了87.52% 的Java用户
     * 	内存消耗:39.2 MB,击败了66.05% 的Java用户
     * @param citations
     * @return
     */
    public int hIndex2(int[] citations) {
        // 小到大排序
        Arrays.sort(citations);
        int h = 0;
        for(int i=citations.length - 1;i>=0;i--){
            if (citations[i]>h){
                h++;
            }
        }
        return h;
    }


    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }


}
