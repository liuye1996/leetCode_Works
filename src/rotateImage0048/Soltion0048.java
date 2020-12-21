package rotateImage0048;

/**
 * @Author: ye_liu
 * @Date: 2020/12/19 13:50
 */
public class Soltion0048 {

    /**\
     *
     * https://leetcode-cn.com/problems/rotate-image/
     *
     * 48. 旋转图像\
     *
     * 给定一个 n × n 的二维矩阵表示一个图像。
     *
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     *
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 示例 1:
     *
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     * 示例 2:
     *
     * 给定 matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     * 通过次数121,595提交次数171,098
     *
     */

//    public void rotate(int[][] matrix) {
//        int length = matrix.length;
//        int stepLength = Math.round(length);
//        for (int i=0;i<stepLength;i++){
//            for (int j=0;j<stepLength;j++){
//                // 右上
//                int rightUp = matrix[j][length-1-i];
//                matrix[j][length-1-i] = matrix[i][j];
//                // 右下
//                int rightDown =
//                matrix[length-1-i][j] = rightUp;
//                // 左上
//                matrix[i][j] = matrix[length-1-j][i];
//                // 左下
//
//            }
//        }
//    }


    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            int start = i;
            int end = len - i - 1;
            for (int j = 0; j < end - start; j++) {
                int temp = matrix[start][start + j];
                matrix[start][start + j] = matrix[end - j][start];
                matrix[end - j][start] = matrix[end][end - j];
                matrix[end][end - j] = matrix[start + j][end];
                matrix[start + j][end] = temp;
            }
        }
    }







}
