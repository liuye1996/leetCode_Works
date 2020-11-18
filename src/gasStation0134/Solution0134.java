package gasStation0134;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ye_liu
 * @Date: 2020/11/18 8:55
 */
public class Solution0134 {

    //在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
// 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
//
// 说明:
//
//
// 如果题目有解，该答案即为唯一答案。
// 输入数组均为非空数组，且长度相同。
// 输入数组中的元素均为非负数。
//
//
// 示例 1:
//
// 输入:
//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
//
//输出: 3
//
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。
//
// 示例 2:
//
// 输入:
//gas  = [2,3,4]
//cost = [3,4,3]
//
//输出: -1
//
//解释:
//你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
//我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
//开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
//开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
//你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
//因此，无论怎样，你都不可能绕环路行驶一周。
// Related Topics 贪心算法
// 👍 450 👎 0

    /**
     * https://leetcode-cn.com/problems/gas-station/
     *
     * 执行结果：通过 显示详情
     * 执行用时：49 ms, 在所有 Java 提交中击败了 23.97% 的用户
     * 内存消耗：38.7 MB , 在所有 Java 提交中击败了 81.65% 的用户
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        if (length == 1 && gas[0]>=cost[0]){
            return 0;
        }
        for (int i=0;i<length;i++){
            if (gas[i]>cost[i]){
                boolean isGo = false;
                int leaveGas = 0;
                for (int j=i;j<length;){
                    leaveGas += gas[j];
                    leaveGas -= cost[j];
                    if ( leaveGas < 0){
                        break;
                    }
                    if (isGo&&((i!=0&&j==i-1)||(i==0&&j==i))){
                        return i;
                    }
                    if (j==length-1){
                        j = 0;
                    }else{
                        j++;
                        isGo = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] gas = new int[]{1,2,3,4,5};
//        int[] cost = new int[]{3,4,5,1,2};

//        int[] gas = new int[]{2,3,4};
//        int[] cost = new int[]{3,4,3};

//        int[] gas = new int[]{5,1,2,3,4};
//        int[] cost = new int[]{4,4,1,5,1};

        int[] gas = new int[]{2};
        int[] cost = new int[]{2};
        Solution0134 solution0134 = new Solution0134();
        System.out.println(solution0134.canCompleteCircuit(gas, cost));

    }
}
