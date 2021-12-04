package easy0605canPlaceFlowers;

/**
 * @Author: ye_liu
 * @Date: 2021/1/2 13:47
 */
public class solution0605 {


    /**
     * https://leetcode-cn.com/problems/can-place-flowers/
     *
     *
     * 605. 种花问题
     * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     *
     * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
     *
     *
     *
     * 示例 1：
     *
     * 输入：flowerbed = [1,0,0,0,1], n = 1
     * 输出：true
     * 示例 2：
     *
     * 输入：flowerbed = [1,0,0,0,1], n = 2
     * 输出：false
     *
     *
     * 提示：
     *
     * 1 <= flowerbed.length <= 2 * 104
     * flowerbed[i] 为 0 或 1
     * flowerbed 中不存在相邻的两朵花
     * 0 <= n <= flowerbed.length
     * 通过次数65,861提交次数193,190
     *
     */
    public boolean canPlaceFlowers0(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if(n>length/2){
            return false;
        }
        int threeZeroCount = 0;
        int countCache = 0;
        for(int i=0;i<length;i++){
            if (flowerbed[i]==0){
                countCache++;
            }else if(flowerbed[i]==1||i==length-1){
                threeZeroCount+=(countCache-1)/2;
            }
        }
        return threeZeroCount>=n;
    }


    /**
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    // 还没遇到第一个 1
                    count += i / 2;
                } else {
                    // 前后两个 1 之间能插多少个
                    count += (i - prev - 2) / 2;
                }
                if (count >= n) {
                    // 已经大于 n 可以直接返回
                    return true;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            // 全是 0
            count += (m + 1) / 2;
        } else {
            // 计算最后一个 1 到最后能插多少个
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }



}
