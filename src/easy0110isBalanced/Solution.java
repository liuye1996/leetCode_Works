package easy0110isBalanced;

/**
 * @Author: ye_liu
 * @Date: 2020/10/27 9:51
 */
public class Solution {



    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            return true;
        }
        // 判断其左右子树是否平衡
        if(Math.abs(treeHeight(root.left) - treeHeight(root.right)) > 1) {
            return false;
        }
        // 递归判断其左右子树的子树是否平衡
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int treeHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lh = treeHeight(root.left) + 1;
        int rh = treeHeight(root.right) + 1;
        return lh  > rh ? lh : rh;
    }


//    public boolean isBalanced(TreeNode root) {
//        if (root==null){
//            return true;
//        }
//        if (root.left==null&&root.right==null){
//            return true;
//        }
//        List<Integer> leftCountList = new ArrayList<>();
//        List<Integer> rightCountList = new ArrayList<>();
//        int leftCount1 = 0;
//        int leftCount2 = 0;
//        if (root.left!=null) {
//            next(root.left, leftCount1, leftCount2, leftCountList);
//        }
//        int rightCount1 = 0;
//        int rightCount2 = 0;
//        if (root.right!=null) {
//            next(root.right, rightCount1, rightCount2, rightCountList);
//        }
//        int maxLeft = leftCountList.isEmpty()?0:leftCountList.stream().reduce(Integer::max).get();
//        int maxRight = rightCountList.isEmpty()?0:rightCountList.stream().reduce(Integer::max).get();
//        return Math.abs(maxLeft - maxRight) <= 1 ;
//    }
//
//    private void next(TreeNode treeNode, int count1, int count2, List<Integer> countList){
//        if (treeNode.left!=null){
//            count1++;
//            next(treeNode.left, count1, count2, countList);
//        }else {
//            countList.add(count1);
//            count1 = 0;
//        }
//        if( treeNode.right!=null){
//            count2++;
//            next(treeNode.right, count1, count2, countList);
//        }else{
//            countList.add(count2);
//            count2 = 0;
//        }
//    }

    /**
     * [3,9,20,null,null,15,7]
     * @param args
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9,null, null), new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)));
        TreeNode root1 = new TreeNode(1, new TreeNode(2,null, null), null);
        Solution solution = new Solution();
        System.out.println(solution.isBalanced(root));
        System.out.println(solution.isBalanced(root1));

    }

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

}
