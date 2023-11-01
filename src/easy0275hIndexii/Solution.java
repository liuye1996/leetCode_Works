package easy0275hIndexii;

import java.util.Arrays;

/**
 * @Author: ye_liu
 * @Date: 2023/10/29 15:26
 */
public class Solution {


    /**
     *275. H 指数 II
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
     *
     * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
     *
     * 请你设计并实现对数时间复杂度的算法解决此问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：citations = [0,1,3,5,6]
     * 输出：3
     * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
     *      由于研究者有3篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3 。
     * 示例 2：
     *
     * 输入：citations = [1,2,100]
     * 输出：2
     *
     *
     * 提示：
     *
     * n == citations.length
     * 1 <= n <= 105
     * 0 <= citations[i] <= 1000
     * citations 按 升序排列
     * 通过次数
     * 90.1K
     * 提交次数
     * 197.8K
     * 通过率
     * 45.5%
     */
    /**
     *
     * 官方题解
     *
     * 由于数组 citations\textit{citations}citations 已经按照升序排序，因此可以使用二分查找。
     *
     * 设查找范围的初始左边界 left\textit{left}left 为 000, 初始右边界 right\textit{right}right 为 n−1n-1n−1，其中 nnn 为数组 citations\textit{citations}citations 的长度。每次在查找范围内取中点 mid\textit{mid}mid，则有 n−midn-\textit{mid}n−mid 篇论文被引用了至少 citations[mid]\textit{citations}[\textit{mid}]citations[mid] 次。如果在查找过程中满足 citations[mid]≥n−mid\textit{citations}[\textit{mid}] \ge n - \textit{mid}citations[mid]≥n−mid，则移动右边界 right\textit{right}right，否则移动左边界 left\textit{left}left
     *
     * 作者：力扣官方题解
     * 链接：https://leetcode.cn/problems/h-index-ii/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;

    }


}
