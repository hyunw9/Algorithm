package leetCode.tree;

public class binary_tree_diameter {
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
    private static int max;

    public int diameterOfBinaryTree(TreeNode root) {
      max = 0;
      traverse(root);
      return max;
    }

    public int traverse(TreeNode node) {
      if (node == null) {
        return 0;
      }

      int left = traverse(node.left);
      int right = traverse(node.right);
      max = Math.max(max, left + right);

      System.out.println("val : " + node.val + "left : " + left + " right : " + right);
      return 1 + Math.max(left, right);
    }
  }
}
