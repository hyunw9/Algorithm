package leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_target_sum_ii {
  class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      Arrays.sort(candidates);
      List<List<Integer>> ans = new ArrayList<>();

      dfs(ans, new ArrayList<>(), 0, candidates, target, 0, 0);
      return ans;
    }

    public static void dfs(
        List<List<Integer>> ans,
        ArrayList<Integer> arr,
        int pointer,
        int[] candidates,
        int t,
        int sum,
        int d) {
      // System.out.println(arr);
      // System.out.println("sum : " + sum);
      // System.out.println("d : " + d);
      if (sum >= t) {
        if (sum == t) {
          ans.add(new ArrayList<>(arr));
        }
        return;
      }

      for (int i = pointer; i < candidates.length; i++) {

        if ((i > pointer && candidates[i] == candidates[i - 1]) || sum + candidates[i] > t) {
          continue;
        }

        arr.add(candidates[i]);
        sum += candidates[i];
        dfs(ans, arr, i + 1, candidates, t, sum, d + 1);
        sum -= candidates[i];
        arr.remove(arr.size() - 1);
      }
    }
  }
}
