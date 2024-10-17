package leetCode.tree;
import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}

public class binary_tree_preorder_traversal{
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        traverse(ans, root);
        return ans;
    }

    public void traverse(List<Integer> list, TreeNode node){

        if(node== null){
            return;
        }

            list.add(node.val);
            traverse(list,node.left);
            traverse(list,node.right);
    }
}

