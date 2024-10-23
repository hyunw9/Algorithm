package leetCode.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class subsets_ii {
  private static Set<ArrayList<Integer>> set;
  private static HashMap<Integer, Boolean> map;

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    map = new HashMap<>();

    set = new HashSet<>();
    Arrays.sort(nums);
    dfs(0, nums, new ArrayList<>(), ans);

    return ans;
    // not dupe . set 사용 필요
    // 이번 수 넣던지 안넣던지. 일단 조합 -> 이후 백트래킹

  }

  public static void dfs(int depth, int[] nums, ArrayList<Integer> arr, List<List<Integer>> ans) {
    ans.add(new ArrayList<>(arr));

    for (int i = depth; i < nums.length; i++) {
      if (i > depth && nums[i] == nums[i - 1]) continue;
      arr.add(nums[i]);
      dfs(i + 1, nums, arr, ans);
      arr.remove(arr.size() - 1);
    }
  }
}
