package leetCode.SlidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class minimum_window_substring {

  class Solution {
    public String minWindow(String s, String t) {
      if (s.length() < t.length()) return "";
      HashMap<Character, Integer> map = new HashMap<>();

      for (char b : t.toCharArray()) {

        map.put(b, map.getOrDefault(b, 0) + 1);
      }

      int matched = 0;
      int l = 0;
      int r = 0;
      List<int[]> arr = new ArrayList<>();
      int minSize = 987654321;
      while (l <= r && r < s.length()) {

        char right = s.charAt(r);

        if (map.containsKey(right)) {
          map.put(right, map.get(right) - 1);
          if (map.get(right) == 0) {
            matched += 1;
          }
        }

        while (matched == map.size()) {

          int window = r - l + 1;
          if (window < minSize) {
            arr.add(new int[] {l, r});
          }

          char left = s.charAt(l);
          if (map.containsKey(left)) {
            map.put(left, map.get(left) + 1);
            if (map.get(left) > 0) {
              matched -= 1;
            }
          }
          l++;
        }
        r++;
      }
      // System.out.println(map);
      Collections.sort(arr, (o1, o2) -> (o1[1] - o1[0]) - (o2[1] - o2[0]));
      if (arr.size() == 0) {
        return "";
      }

      int[] result = arr.get(0);
      return s.substring(result[0], result[1] + 1);
    }
  }
}
