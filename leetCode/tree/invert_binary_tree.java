package leetCode.tree;

public class invert_binary_tree {
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
    public TreeNode invertTree(TreeNode root) {

      invert(root);
      return root;
    }

    public void invert(TreeNode node) {

      if (node == null) return;

      invertTree(node.left);
      invertTree(node.right);

      TreeNode tmpNode = node.left;
      node.left = node.right;
      node.right = tmpNode;
    }
  }
}
