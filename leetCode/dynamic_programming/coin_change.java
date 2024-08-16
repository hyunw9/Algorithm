package leetCode.dynamic_programming;

import java.util.Arrays;

public class coin_change {
  class Solution {
    public int coinChange(int[] coins, int amount) {

      int[] dp = new int[1000 + 1];

      Arrays.fill(dp, 987654321);
      dp[0] = 0;

      for (int i = 1; i < dp.length; i++) {

        for (int j = 0; j < coins.length; j++) {
          if (coins[j] <= i) {
            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
          }
        }
        // 12 / 10
      }
      // System.out.println(Arrays.toString(dp));
      return dp[amount] >= 987654321 ? -1 : dp[amount];
    }
  }
}
