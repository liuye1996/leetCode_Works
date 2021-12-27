package easy0283moveZeroes;

/**
 * @Author: ye_liu
 * @Date: 2020/11/19 9:22
 */
public class Solution0283 {

    // https://leetcode-cn.com/problems/move-zeroes/
    //给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    //
    // 示例:
    //
    // 输入: [0,1,0,3,12]
    //输出: [1,3,12,0,0]
    //
    // 说明:
    //
    // 必须在原数组上操作，不能拷贝额外的数组。
    // 尽量减少操作次数。
    //
    // Related Topics 数组 双指针
    // 👍 817 👎 0
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length <= 1 || nums == null){
            return;
        }
        int index = 0;
        for (int thisNum : nums){
            if (thisNum != 0){
                nums[index++] = thisNum;
            }
        }
        for (int i = index;i<length;i++){
            nums[index++] = 0;
        }
    }


    /**
     *
     * 解答出错
     *
     * [1,0,1]
     * @param nums
     */
//    public void moveZeroes(int[] nums) {
//        int length = nums.length;
//        if (length == 0){
//            return;
//        }
//        List<Integer> zeroIndexList = new ArrayList<>();
//        for (int i = 0;i<length;i++){
//            if (nums[i]==0){
//                zeroIndexList.add(i);
//            }
//        }
//        int index = zeroIndexList.get(0);
//        for (int i=0;i<zeroIndexList.size();i++){
//            System.out.println(i==zeroIndexList.size()-1);
//            for (int j = zeroIndexList.get(i)+1;j<=(i==zeroIndexList.size()-1?length-1:zeroIndexList.get(i+1));j++){
//                nums[index++] = nums[j];
//            }
//        }
//        for (int i=0;i<zeroIndexList.size();i++){
//            nums[length-i-1] = 0;
//        }
//    }

    public static void main(String[] args) {
        Solution0283 solution0283 = new Solution0283();
        int[] nums = new int[]{1,0,1};
        solution0283.moveZeroes(nums);



    }


}
