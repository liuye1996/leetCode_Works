package medium1465maximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts;

import java.util.Arrays;

/**
 * @Author: ye_liu
 * @Date: 2023/10/27 14:13
 */
public class Solution {

    /**
     * 1465. 切割后面积最大的蛋糕
     * 中等
     * 相关标签
     * 相关企业
     * 提示
     * 矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中：
     *
     *  horizontalCuts[i] 是从矩形蛋糕顶部到第  i 个水平切口的距离
     * verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离
     * 请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，并返回其 面积 。由于答案可能是一个很大的数字，因此需要将结果 对 109 + 7 取余 后返回。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
     * 输出：4
     * 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色的那份蛋糕面积最大。
     * 示例 2：
     *
     *
     *
     * 输入：h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
     * 输出：6
     * 解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色和黄色的两份蛋糕面积最大。
     * 示例 3：
     *
     * 输入：h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
     * 输出：9
     *
     *
     * 提示：
     *
     * 2 <= h, w <= 109
     * 1 <= horizontalCuts.length <= min(h - 1, 105)
     * 1 <= verticalCuts.length <= min(w - 1, 105)
     * 1 <= horizontalCuts[i] < h
     * 1 <= verticalCuts[i] < w
     * 题目数据保证 horizontalCuts 中的所有元素各不相同
     * 题目数据保证 verticalCuts 中的所有元素各不相同
     * 通过次数
     * 19.5K
     * 提交次数
     * 47.9K
     * 通过率
     * 40.7%
     */
    /**
     * 解题思路：找出间隔最长的长和宽并相乘即可 较简单  但是在返回值处计算需要注意int溢出
     *> 2023/10/27 14:52:24
     * 解答成功:
     * 	执行耗时:21 ms,击败了5.56% 的Java用户
     * 	内存消耗:52.9 MB,击败了18.89% 的Java用户
     * @param h
     * @param w
     * @param horizontalCuts
     * @param verticalCuts
     * @return
     */
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // 先从小到大排序
        horizontalCuts = Arrays.stream(horizontalCuts).sorted().toArray();
        verticalCuts = Arrays.stream(verticalCuts).sorted().toArray();
        int horMax = 0;
        int verMax = 0;
        // 水平
        for (int i = 0;i<horizontalCuts.length;i++){
            int thisDisance = 0;
            if (i == 0 && horizontalCuts.length == 1){
                thisDisance = Math.max(horizontalCuts[i], h - horizontalCuts[i]);
            }else if (i == 0){
                thisDisance = horizontalCuts[i];
            } else{
                if (i == horizontalCuts.length -1){
                    thisDisance = Math.max(h - horizontalCuts[i], horizontalCuts[i] - horizontalCuts[i-1]);
                }else {
                    thisDisance = horizontalCuts[i] - horizontalCuts[i-1];
                }
            }
            horMax = Math.max(thisDisance, horMax);
        }
        // 横向
        for (int i = 0;i<verticalCuts.length;i++){
            int thisDisance = 0;
            if (i == 0 && verticalCuts.length == 1){
                thisDisance = Math.max(verticalCuts[i], w - verticalCuts[i]);
            }else if (i == 0){
                thisDisance = verticalCuts[i];
            } else{
                if (i == verticalCuts.length -1){
                    thisDisance = Math.max(w - verticalCuts[i], verticalCuts[i] - verticalCuts[i-1]);
                }else {
                    thisDisance = verticalCuts[i] - verticalCuts[i-1];
                }
            }
            verMax = Math.max(thisDisance, verMax);
        }
        return (int)((long) horMax * verMax % (int)(1e9 + 7));
    }

    /**
     * 根据现有代码优化
     *
     * > 2023/10/27 14:58:36
     * 解答成功:
     * 	执行耗时:15 ms,击败了85.56% 的Java用户
     * 	内存消耗:53 MB,击败了10.00% 的Java用户
     *
     * @param h
     * @param w
     * @param horizontalCuts
     * @param verticalCuts
     * @return
     */
    public int maxArea1(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // 先从小到大排序
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int horMax = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length-1]);
        int verMax = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length-1]);
        // 水平
        for (int i = 1;i<horizontalCuts.length;i++){
            horMax = Math.max(horizontalCuts[i] - horizontalCuts[i-1], horMax);
        }
        // 横向
        for (int i = 1;i<verticalCuts.length;i++){
            verMax = Math.max(verticalCuts[i] - verticalCuts[i-1], verMax);
        }
        // 需要注意此处的int溢出
        return (int)((long) horMax * verMax % (int)(1e9 + 7));
    }


    public static void main(String[] args) {


//        System.out.println(new Solution().maxArea(6, 3, new int[]{5,4,1,2,3}, new int[]{2,1}));
        System.out.println(new Solution().maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2}));
        System.out.println(new Solution().maxArea1(1000000000, 1000000000, new int[]{2}, new int[]{2}));


    }

}
