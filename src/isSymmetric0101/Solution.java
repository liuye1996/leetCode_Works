package isSymmetric0101;

/**
 * @Author: ye_liu
 * @Date: 2020/10/27 14:05
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {

        return check(root, root);

    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p ==null || q == null){
            return false;
        }

        return p.val == q.val && check(p.left, q.right) &&check(p.right, q.left);


    }


//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//        TreeNode(int x) { val = x; }
//    }

    static class TreeNode {
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
        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(3,null, null), new TreeNode(4,null, null)), new TreeNode(2, new TreeNode(4, null, null), new TreeNode(3, null, null)));
        TreeNode root1 = new TreeNode(1, new TreeNode(2,null, new TreeNode(3,null, null)), new TreeNode(2,null, new TreeNode(3,null, null)));
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));
        System.out.println(solution.isSymmetric(root1));

    }

}
