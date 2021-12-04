package easy0463islandPerimeter;

/**
 * @Author: ye_liu
 * @Date: 2020/10/30 19:05
 */
public class Solution {


    /**
     * https://leetcode-cn.com/problems/island-perimeter/
     *
     * 463. 岛屿的周长
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
     *
     * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     *
     * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     *
     *
     *
     * 示例 :
     *
     * 输入:
     * [[0,1,0,0],
     *  [1,1,1,0],
     *  [0,1,0,0],
     *  [1,1,0,0]]
     *
     * 输出: 16
     *
     * 解释: 它的周长是下面图片中的 16 个黄色的边：
     *
     *
     * 通过次数42,335提交次数42,335
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int countIslands = 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    countIslands++;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        count++;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        count++;
                    }
                }
            }
        }
        return 4 * countIslands - 2 * count;
    }



//    public int islandPerimeter(int[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//        int countIslands = 0;
//        int count = 0;
//        Map<Integer, List<Integer>> map1 = new HashMap<>();
//        Map<Integer, List<Integer>> map2 = new HashMap<>();
//        int length2 = grid[0].length;
//        int length1 = grid.length;
//        for (int i = 0;i<length1;i++){
//            for (int j = 0;j<length2;j++){
//                if (grid[i][j] == 1){
//                    countIslands++;
//                    List<Integer> thisList1 =  map1.getOrDefault(i, new LinkedList<>());
//                    thisList1.add(j);
//                    map1.put(i, thisList1);
//                    List<Integer> thisList2 =  map2.getOrDefault(j, new LinkedList<>());
//                    thisList2.add(i);
//                    map2.put(j, thisList2);
//                }
//            }
//        }
//        for (int i = 0;i<length1;i++){
//            for (int j = 0;j<length2;j++){
//
//                List<Integer> thisList1 =  map1.getOrDefault(i, new LinkedList<>());
//                if (thisList1.contains(j)&&(thisList1.contains(j - 1)||thisList1.contains(j + 1))){
//                    count++;
//                }
//                List<Integer> thisList2 =  map2.getOrDefault(j, new LinkedList<>());
//                if (thisList2.contains(i)&&(thisList2.contains(i - 1)||thisList2.contains(i + 1))){
//                    count++;
//                }
//            }
//        }
//        return 4 * countIslands -   count;
//    }

    public static void main(String[] args) {
        int grid[][] = new int[][]{{0,1}};
        int grid2[][] = new int[][]{{1,0}};
        int grid3[][] = new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        Solution solution = new Solution();
//        System.out.println(solution.islandPerimeter(grid));
//        System.out.println(solution.islandPerimeter(grid2));
        System.out.println(solution.islandPerimeter(grid3));
    }

}



