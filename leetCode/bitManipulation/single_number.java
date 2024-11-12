package leetCode.bitManipulation;

import java.util.HashMap;

public class single_number {
  class Solution {
    public int singleNumber(int[] nums) {
      HashMap<Integer, Integer> map = new HashMap<>();

      for (int v : nums) {
        map.put(v, map.getOrDefault(v, 0) + 1);
      }
      int ans = 0;
      for (int v : map.keySet()) {
        if (map.get(v) == 1) ans = v;
      }
      return ans;
    }
  }
}
