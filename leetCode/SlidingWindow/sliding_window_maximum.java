package leetCode.SlidingWindow;

import java.util.TreeMap;

public class sliding_window_maximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
    // Treemap으로 오른쪽꺼만 출력하면서 나가면 되지 않나  ?
    int ans[] = new int[nums.length - k + 1];

    TreeMap<Integer, Integer> map = new TreeMap<>();
    int l = 0;
    int r = 0;
    for (int i = r; i < k; i++) {
      map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
      r += 1;
    }
    ans[0] = map.lastKey();
    while (r < nums.length) {
      map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
      map.put(nums[l], map.get(nums[l]) - 1);
      if (map.get(nums[l]) <= 0) map.remove(nums[l]);
      l += 1;
      r += 1;
      ans[r - k] = map.lastKey();
    }
    return ans;
  }
}
