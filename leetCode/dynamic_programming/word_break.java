package leetCode.dynamic_programming;

import java.util.List;

public class word_break {
  class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
      // word dict 의 내용들로 s 를 만들 수 있는가 ?
      boolean[] dp = new boolean[s.length() + 1];
      dp[s.length()] = true;
      for (int i = s.length() - 1; i >= 0; i--) {
        for (String w : wordDict) {
          if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
            dp[i] = dp[i + w.length()];
          }
          if (dp[i]) {
            break;
          }
        }
      }
      return dp[0];
    }
  }
}
