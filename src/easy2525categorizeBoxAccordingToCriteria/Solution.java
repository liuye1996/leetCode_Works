package easy2525categorizeBoxAccordingToCriteria;

/**
 * @Author: ye_liu
 * @Date: 2023/10/20 9:51
 */
public class Solution {

    /**
     *
     * 2525.根据规则将箱子分类
     * 给你四个整数 length ，width ，height 和 mass ，分别表示一个箱子的三个维度和质量，请你返回一个表示箱子 类别 的字符串。
     *
     *
     *  如果满足以下条件，那么箱子是 "Bulky" 的：
     *
     *
     *
     *  箱子 至少有一个 维度大于等于 10⁴ 。
     *  或者箱子的 体积 大于等于 10⁹ 。
     *
     *
     *  如果箱子的质量大于等于 100 ，那么箱子是 "Heavy" 的。
     *  如果箱子同时是 "Bulky" 和 "Heavy" ，那么返回类别为 "Both" 。
     *  如果箱子既不是 "Bulky" ，也不是 "Heavy" ，那么返回类别为 "Neither" 。
     *  如果箱子是 "Bulky" 但不是 "Heavy" ，那么返回类别为 "Bulky" 。
     *  如果箱子是 "Heavy" 但不是 "Bulky" ，那么返回类别为 "Heavy" 。
     *
     *
     *  注意，箱子的体积等于箱子的长度、宽度和高度的乘积。
     *
     *
     *
     *  示例 1：
     *
     *
     * 输入：length = 1000, width = 35, height = 700, mass = 300
     * 输出："Heavy"
     * 解释：
     * 箱子没有任何维度大于等于 10⁴ 。
     * 体积为 24500000 <= 10⁹ 。所以不能归类为 "Bulky" 。
     * 但是质量 >= 100 ，所以箱子是 "Heavy" 的。
     * 由于箱子不是 "Bulky" 但是是 "Heavy" ，所以我们返回 "Heavy" 。
     *
     *  示例 2：
     *
     *
     * 输入：length = 200, width = 50, height = 800, mass = 50
     * 输出："Neither"
     * 解释：
     * 箱子没有任何维度大于等于 10⁴。
     * 体积为 8 * 10⁶ <= 10⁹。所以不能归类为 "Bulky" 。
     * 质量小于 100 ，所以不能归类为 "Heavy" 。
     * 由于不属于上述两者任何一类，所以我们返回 "Neither" 。
     *
     *
     *
     *  提示：
     *
     *
     *  1 <= length, width, height <= 10⁵
     *  1 <= mass <= 10³
     */
    /**
     *
     * 第一次提交
     * > 2023/10/20 10:39:03
     * 解答成功:
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:38.8 MB,击败了5.60% 的Java用户
     * @param length
     * @param width
     * @param height
     * @param mass
     * @return
     */
    public String categorizeBox(int length, int width, int height, int mass) {
        String category1 = null;
        String category2 = null;
        String result;
        long volume = (long) length * width * height;
        if (length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000){
            category1 = "Bulky";
        }
        if (mass >= 100){
            category2 = "Heavy";
        }
        if ("Bulky".equals(category1) && "Heavy".equals(category2)){
            result = "Both";
        }else if("Bulky".equals(category1)){
            result = "Bulky";
        }else if("Heavy".equals(category2)){
            result = "Heavy";
        }else{
            result = "Neither";
        }
        return result;
    }


    /**
     *
     * 第二次提交
     *> 2023/10/20 10:51:02
     * 解答成功:
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:38.5 MB,击败了68.80% 的Java用户
     * 	使用静态字符串确实可以少0.3mb
     *
     * @param length
     * @param width
     * @param height
     * @param mass
     * @return
     */
    private static final String BULKY = "Bulky";
    private static final String HEAVY = "Heavy";
    public String categorizeBox1(int length, int width, int height, int mass) {
        String category1 = null;
        String category2 = null;
        String result;
        long volume = (long) length * width * height;
        if (length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000){
            category1 = BULKY;
        }
        if (mass >= 100){
            category2 = HEAVY;
        }
        if (BULKY.equals(category1) && HEAVY.equals(category2)){
            result = "Both";
        }else if(BULKY.equals(category1)){
            result = BULKY;
        }else if(HEAVY.equals(category2)){
            result = HEAVY;
        }else{
            result = "Neither";
        }
        return result;
    }

    /**
     * 看过官方题解后在写
     *
     *> 2023/10/20 11:04:21
     * 解答成功:
     * 	执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:38.5 MB,击败了50.40% 的Java用户
     *
     */
    public String categorizeBox2(int length, int width, int height, int mass) {
        boolean isBulky = Math.max(length, Math.max(width, height)) >= 10000 || (long)length*width*height >= 1000000000;
        boolean isHeavy = mass >= 100;
        if (isBulky && isHeavy){
            return "Both";
        }else if(isBulky){
            return "Bulky";
        }else if(isHeavy){
            return "Heavy";
        }else{
            return "Neither";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        System.out.println(solution.categorizeBox2(1000, 35, 700,300));
        System.out.println(solution.categorizeBox2(200, 50, 800, 50));


    }




}
