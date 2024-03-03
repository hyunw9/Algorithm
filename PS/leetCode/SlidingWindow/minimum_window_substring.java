package PS.leetCode.SlidingWindow;

import java.util.HashMap;

public class minimum_window_substring {

  class Solution {

    public String minWindow(String s, String t) {
      String sub = s;
      HashMap<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < t.length(); i++) {
        map.put(t.charAt(i), 1);
      }
      int l = 0;
      int r = 0;
      int window = 0;
      int count = 0;
      for (; r < s.length(); r++) {
        char now = s.charAt(r);
        window = r - l + 1;
        if (map.get(now) != null && map.get(now) > 0) {
          count += 1;
          map.put(now, map.get(now) - 1);
        }
        if (count > t.length()) {
          if (map.containsKey(s.charAt(l))) {
            map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
            l++;
            count--;
          } else if (!map.containsKey(s.charAt(l))) {
            l++;
          }
        }


      }
      return sub;
    }
  }
}
