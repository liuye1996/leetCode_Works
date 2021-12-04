package medium0006convert;

/**
 * @Author: ye_liu
 * @Date: 2020/10/31 13:52
 */
public class Solution {

    /**
     *
     *
     * 6. Z 字形变换
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * 通过次数184,665提交次数377,183
     *
     * @param s
     * @param numRows
     * @return
     */


    /**
     *
     *
     *  效率较低需要优化
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        //用二维数组存储，先求出列数
        if (numRows <= 1) {
            return s;
        }
        int length = s.length();
        int column = computeColumnNum(length, numRows);
        int moveIndex = 0;
        int[][] collection = new int[numRows][column];
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < column;j++){
            for(int i = 0; i < numRows;i++){
                int a = j % (numRows-1);
                if ( a == 0) {
                    collection[i][j] = moveIndex++;
                }else if (i == (numRows - a - 1)){
                    collection[i][j] = moveIndex++ ;
                }else{
                    collection[i][j] = -1;
                }
            }
        }
        for (int i = 0;i < numRows;i++){
            for (int j = 0;j <column;j++){
                int index = collection[i][j];
                if (index != -1&&index<length){
                    stringBuilder.append(s.charAt(index));
                }
            }
        }
        return stringBuilder.toString();
    }

    public int computeColumnNum(int length, int numRows) {
        int rounding  = length / (numRows + (numRows - 2));
        int remainder = 0;
        int mod = length % (numRows + (numRows - 2));
        if (mod != 0) {
            if (mod < numRows) {
                remainder = 1;
            }
            else {
                remainder = mod % numRows + 1;
            }
        }
        return rounding * (numRows - 1) + remainder;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.convert("PAYPALISHIRING", 3));
//        System.out.println(solution.convert("PAYPALISHIRING", 4));

    }

}
