package leetCode.dynamic_programming;

import java.util.HashMap;

public class decode_ways {
  class Solution {
    public int numDecodings(String s) {
      HashMap<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < 26; i++) {
        map.put((char) ('A' + i), (int) ('A' - 'A' + i + 1));
      }
      int[] dp = new int[s.length() + 1];
      dp[s.length()] = 1;

      for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == '0') {
          dp[i] = 0;
        } else {
          dp[i] = dp[i + 1];
          if (i + 1 < s.length()
              && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
            dp[i] += dp[i + 2];
          }
        }
      }
      // 1122
      //      [1+1,12], [1+1+2,1+12,11+2], [1+1+2+2, 1+1+22, 1+12+2, 11+2+2, 11+22]
      //      1 1,
      // 1
      return dp[0];
    }
  }
}
