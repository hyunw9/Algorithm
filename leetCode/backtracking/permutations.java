package leetCode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class permutations {
  class Solution {
    public static boolean[] used;
    public static List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
      // List<List<Integer>> tst = new ArrayList<>();
      // tst = new ArrayList<>();
      ans = new ArrayList<>();
      used = new boolean[nums.length];
      dfs(nums, 0, 0, new LinkedList<>());
      return ans;
    }

    public void dfs(int[] nums, int idx, int depth, List<Integer> curr) {
      if (depth >= nums.length) {
        ArrayList<Integer> list = new ArrayList<>(curr);
        // System.out.println(list);
        ans.add(list);
        // System.out.println(ans);
        return;
      }

      for (int i = 0; i < nums.length; i++) {
        if (!used[i]) {
          used[i] = true;
          curr.add(nums[i]);
          dfs(nums, i, depth + 1, curr);
          curr.remove(curr.size() - 1);
          used[i] = false;
          // curr.remove(curr.size());
        }
      }
    }
  }
}
