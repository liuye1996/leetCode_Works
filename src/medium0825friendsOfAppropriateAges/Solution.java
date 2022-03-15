package medium0825friendsOfAppropriateAges;


/**
 * 825. 适龄的朋友
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 *
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 *
 * 返回在该社交媒体网站上产生的好友请求总数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 * 示例 2：
 *
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 * 示例 3：
 *
 * 输入：ages = [20,30,100,110,120]
 * 输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 *
 *
 * 提示：
 *
 * n == ages.length
 * 1 <= n <= 2 * 104
 * 1 <= ages[i] <= 120
 * 通过次数13,694提交次数31,807
 *
 *
 */
/**
 * @Author: ye_liu
 * @Date: 2021/12/27 11:15
 *
 * 提交结果	执行用时	内存消耗	语言	提交时间	备注
 * 超出时间限制 N/A	N/A	Java	2021/12/27 13:52
 *
 */
public class Solution {

    public int numFriendRequests(int[] ages) {
        int count=0;
        int length = ages.length;
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                if(i==j){
                    continue;
                }
                // age[y] <= 0.5 * age[x] + 7
                if (ages[j] <= 0.5 * ages[i] +7){
                    continue;
                }
                // * age[y] > age[x]
                if (ages[j]>ages[i]) {
                    continue;
                }
                // * age[y] > 100 && age[x] < 100
                if (ages[j] > 100 && ages[i] < 100){
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    public int numFriendRequests2(int[] ages) {
        int count=0;

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numFriendRequests(new int[]{16,16}));
        System.out.println(solution.numFriendRequests(new int[]{16,17,18}));
        System.out.println(solution.numFriendRequests(new int[]{20,30,100,110,120}));



    }

}
