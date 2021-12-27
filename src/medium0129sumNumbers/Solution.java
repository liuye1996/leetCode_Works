package medium0129sumNumbers;

/**
 * @Author: ye_liu
 * @Date: 2020/10/29 10:17
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
     *
     * 129. 求根到叶子节点数字之和
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     *
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     *
     * 计算从根到叶子节点生成的所有数字之和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     *     1
     *    / \
     *   2   3
     * 输出: 25
     * 解释:
     * 从根到叶子节点路径 1->2 代表数字 12.
     * 从根到叶子节点路径 1->3 代表数字 13.
     * 因此，数字总和 = 12 + 13 = 25.
     * 示例 2:
     *
     * 输入: [4,9,0,5,1]
     *     4
     *    / \
     *   9   0
     *  / \
     * 5   1
     * 输出: 1026
     * 解释:
     * 从根到叶子节点路径 4->9->5 代表数字 495.
     * 从根到叶子节点路径 4->9->1 代表数字 491.
     * 从根到叶子节点路径 4->0 代表数字 40.
     * 因此，数字总和 = 495 + 491 + 40 = 1026.
     * 通过次数45,625提交次数69,712
     * @param root
     * @return
     */

    /**
     * 将sum直接返回传递
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return getLeafVal(root, 0);
    }

    private int getLeafVal(TreeNode root, int lastVal) {
        if (root == null){
            return 0;
        }
        int thisVal = lastVal * 10 + root.val;
        if (root.right == null && root.left == null){
            return thisVal;
        }
        return getLeafVal(root.left, thisVal) + getLeafVal(root.right, thisVal);
    }

    /**
     * 通过，还可以再优化，直接对sum进行操作,递归返回sum
     */
//    public int sumNumbers(TreeNode root) {
//        List<Integer> leafList =  new ArrayList<>();
//        int lastVal = 0;
//        getlesfList(root, lastVal, leafList);
//        int sum = 0;
//        for (Integer num : leafList) {
//            sum += num;
//        }
//        return sum;
//    }
//
//    private void getlesfList(TreeNode root, int lastVal, List<Integer> leafList) {
//        if (root == null){
//            return ;
//        }
//        lastVal = lastVal * 10 + root.val;
//        if (root.right == null && root.left == null){
//            leafList.add(lastVal);
//        }
//        if (root.left != null){
//            getlesfList(root.left, lastVal, leafList);
//        }
//        if (root.right != null){
//            getlesfList(root.right, lastVal, leafList);
//        }
//    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
