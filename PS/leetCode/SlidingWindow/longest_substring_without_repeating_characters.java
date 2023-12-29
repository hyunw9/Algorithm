package PS.leetCode.SlidingWindow;

import java.util.HashMap;

public class longest_substring_without_repeating_characters {
  public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    int max = 0;

    for (int i = 0, j = 0; i < s.length(); i++) {
      if (map.containsKey(s.charAt(i))) {
        j = Math.max(map.get(s.charAt(i)), j);
      }
      max = Math.max(max, i - j + 1);
      map.put(s.charAt(i), i + 1);
    }
    return max;
  }

}
