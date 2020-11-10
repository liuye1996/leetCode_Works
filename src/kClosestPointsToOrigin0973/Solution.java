package kClosestPointsToOrigin0973;

import java.util.*;

/**
 * @Author: ye_liu
 * @Date: 2020/11/9 9:14
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/k-closest-points-to-origin/solution/zui-jie-jin-yuan-dian-de-k-ge-dian-by-leetcode-sol/
     *
     * 973. 最接近原点的 K 个点
     * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
     *
     * （这里，平面上两点之间的距离是欧几里德距离。）
     *
     * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
     *
     * 示例 1：
     *
     * 输入：points = [[1,3],[-2,2]], K = 1
     * 输出：[[-2,2]]
     * 解释：
     * (1, 3) 和原点之间的距离为 sqrt(10)，
     * (-2, 2) 和原点之间的距离为 sqrt(8)，
     * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
     * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
     * 示例 2：
     *
     * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
     * 输出：[[3,3],[-2,4]]
     * （答案 [[-2,4],[3,3]] 也会被接受。）
     *
     * 提示：
     *
     * 1 <= K <= points.length <= 10000
     * -10000 < points[i][0] < 10000
     * -10000 < points[i][1] < 10000
     * 通过次数24,004提交次数40,244
     *
     */
    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 73 ms
     * , 在所有 Java 提交中击败了
     * 7.30%
     * 的用户
     * 内存消耗：
     * 47 MB
     * , 在所有 Java 提交中击败了
     * 68.40%
     * 的用户
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        if (K == points.length){
            return points;
        }
        Map<Integer, List<int[]>> distanceMap = new HashMap<>();
        Set<Integer> distanceSet = new LinkedHashSet<>();
        for (int i=0;i<points.length;i++){
            Integer distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            List<int[]> thisList = distanceMap.getOrDefault(distance, new LinkedList<>());
            thisList.add(points[i]);
            distanceMap.put(distance, thisList);
            distanceSet.add(distance);
        }
        Set<Integer> sortSet = new TreeSet<Integer>((o1, o2) -> o1.compareTo(o2));
        sortSet.addAll(distanceSet);
        List<Integer> sortList = new ArrayList<>(sortSet);
        int[][] result = new int[K][2];

        for (int i = 0, k = 0;i < sortList.size()&&i < K;i++,k++){
            List<int[]> thisSortList = distanceMap.get(sortList.get(k));
            int sortSize = thisSortList.size();
            for (int j = 0;j<sortSize;j++){
                result[i] = thisSortList.get(j);
                if (sortSize>1&&j!=sortSize-1){
                    i++;
                }
            }
        }
        return result;
    }

    /**
     * 官方解法
     * @param points
     * @param K
     * @return
     */
//    public int[][] kClosest(int[][] points, int K) {
//        Arrays.sort(points, new Comparator<int[]>() {
//            public int compare(int[] point1, int[] point2) {
//                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
//            }
//        });
//        return Arrays.copyOfRange(points, 0, K);
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] param = new int[][]{{3,3},{5,-1},{-2,4}};
//        solution.kClosest(param, 2);
        int[][] param = new int[][]{{0,1},{1,0}};
        solution.kClosest(param, 2);

    }
}
