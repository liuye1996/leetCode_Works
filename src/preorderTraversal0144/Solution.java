package preorderTraversal0144;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ye_liu
 * @Date: 2020/10/27 9:37
 */
public class Solution {

    /**
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     *
     * 144. 二叉树的前序遍历
     * 给定一个二叉树，返回它的 前序 遍历。
     *
     *  示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [1,2,3]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 通过次数207,803提交次数305,188
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        preorder(root, resultList);
        return resultList;
    }

    private void preorder(TreeNode root, List<Integer> list){
        if (root != null){
            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
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
        System.out.println(solution.preorderTraversal(root));
        System.out.println(solution.preorderTraversal(root1));

    }
}



