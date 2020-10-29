package minDepth0111;


/**
 * @Author: ye_liu
 * @Date: 2020/10/28 10:43
 */
public class Solution {


    /**
     * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
     *
     * 111. 二叉树的最小深度
     * 给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明：叶子节点是指没有子节点的节点。
     *
     * 示例 1：
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     * 示例 2：
     *
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     *
     * 提示：
     *
     * 树中节点数的范围在 [0, 105] 内
     * -1000 <= Node.val <= 1000
     * 通过次数146,942提交次数328,160
     *
     * @param root
     * @return
     */
    /**
     * 通过
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.right == null && root.left != null){
            return 1 + minDepth(root.left);
        }
        if (root.right != null && root.left == null){
            return 1+ minDepth(root.right);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * 解答错误，left，right都为null时才是 叶子节点
     */
//    public int minDepth(TreeNode root) {
//        if (root == null){
//            return 0;
//        }
//        int leftDepth = minDepth(root.left) + 1;
//        int rightDepth = minDepth(root.right) + 1;
//        return leftDepth > rightDepth ? rightDepth : leftDepth;
//    }

    //      Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6, null, null)))));
        Solution solution = new Solution();
        System.out.println(solution.minDepth(root));
    }
}
