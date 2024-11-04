package leetCode.dynamic_programming;

import java.util.Arrays;

public class longest_common_subsequence {
  class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
      int n = text1.length();
      int m = text2.length();
      int[][] dp = new int[n + 1][m + 1];
      char[] t1 = text1.toCharArray();
      char[] t2 = text2.toCharArray();

      for (int i = 1; i <= n; i++) {

        for (int j = 1; j <= m; j++) {
          if (t1[i - 1] == t2[j - 1]) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
          }
        }
      }
      System.out.println(Arrays.deepToString(dp));
      return dp[n][m];
    }
  }
}
