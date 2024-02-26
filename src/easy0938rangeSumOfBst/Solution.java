package easy0938rangeSumOfBst;

public class Solution {


    /**
     * 938. 二叉搜索树的范围和
     * 简单
     * 相关标签
     * 相关企业
     * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
     * 输出：32
     * 示例 2：
     *
     *
     * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
     * 输出：23
     *
     *
     * 提示：
     *
     * 树中节点数目在范围 [1, 2 * 104] 内
     * 1 <= Node.val <= 105
     * 1 <= low <= high <= 105
     * 所有 Node.val 互不相同
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        int thisVal = 0;
        if (root == null){
            return thisVal;
        }
        if (root.val >= low && root.val <= high){
            thisVal = root.val;
        }
        thisVal += rangeSumBST(root.left, low, high);
        thisVal += rangeSumBST(root.right, low, high);
        return thisVal;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rangeSumBST(new TreeNode(10,
                new TreeNode(5, new TreeNode(3, null, null), new TreeNode(7, null, null)),
                new TreeNode(15, null, new TreeNode(18, null, null))),7,15);




    }

}





class TreeNode {
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