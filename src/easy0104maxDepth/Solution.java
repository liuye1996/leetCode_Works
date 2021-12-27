package easy0104maxDepth;

/**
 * @Author: ye_liu
 * @Date: 2020/10/27 16:57
 */
public class Solution {


    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     *
     * 104. 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     *
     * 通过次数294,591提交次数391,620
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return left > right ? left : right;
    }



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
        TreeNode root = new TreeNode(3, new TreeNode(9,null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        TreeNode root1 = new TreeNode(1, new TreeNode(2,null, null), null);
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(root));
        System.out.println(solution.maxDepth(root1));

    }

}
