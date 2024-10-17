package leetCode.tree;

public class Depth_of_Binary_Tree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  class Solution {
    public int maxDepth(TreeNode root) {
      return traverse(root, 0);
    }

    public int traverse(TreeNode node, int depth) {
      if (node == null) {
        return 0;
      }

      int left = traverse(node.left, depth + 1);
      int right = traverse(node.right, depth + 1);

      int maxVal = Math.max(left, right);
      return maxVal + 1;
    }
  }
}
