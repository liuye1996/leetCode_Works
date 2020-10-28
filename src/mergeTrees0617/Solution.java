package mergeTrees0617;


/**
 * @Author: ye_liu
 * @Date: 2020/10/27 19:16
 */
public class Solution {


    /**
     * https://leetcode-cn.com/problems/merge-two-binary-trees/comments/
     *
     * 617. 合并二叉树
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     *
     * 示例 1:
     *
     * 输入:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * 输出:
     * 合并后的树:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     * 注意: 合并必须从两个树的根节点开始。
     *
     * @param t1
     * @param t2
     * @return
     */

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        TreeNode newTreeNode = new TreeNode(t1.val + t2.val);
        newTreeNode.left = mergeTrees(t1.left, t2.left);
        newTreeNode.right = mergeTrees(t1.right, t2.right);
        return newTreeNode;
    }

    /**
     *
     * 传递有问题，应该使用新treeNode接新的node
     *
     *
     */
//    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
//        if (t1 != null && t2 != null){
//            t1.val = t1.val + t2.val;
//            mergeTrees(t1.left, t2.left);
//            mergeTrees(t1.right, t2.right);
//        }else if(t1 != null && t2 == null){
//            mergeTrees(t1.left, null);
//            mergeTrees(t1.right, null);
//        } else if (t1 == null && t2 !=null){
//            t1 = new TreeNode(t2.val);
//            t1 = mergeTrees(t1, t2.left);
//            if (t1 == null){
//                t1 = mergeTrees(t1, t2.right);
//            }else {
//                mergeTrees(t1, t2.right);
//            }
//        }
//        return t1;
//    }



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
        TreeNode root = new TreeNode(1, new TreeNode(3,new TreeNode(5, null, null), null), new TreeNode(2, null, null));
        TreeNode root1 = new TreeNode(2, new TreeNode(1,null, new TreeNode(4, null, null)), new TreeNode(3, null, new TreeNode(7, null, null)));
        Solution solution = new Solution();
        TreeNode result = solution.mergeTrees(root, root1);
        System.out.println(printfTreeNode(result));

    }

    private static Integer printfTreeNode(TreeNode treeNode){
        if (treeNode == null) {
            return null;
        }
        System.out.println(printfTreeNode(treeNode.left));
        System.out.println(printfTreeNode(treeNode.right));
        return treeNode.val;
    }

}
