package leetCode.dynamic_programming;

import java.util.Arrays;

public class Min_cost_climbing_stairs {
  class Solution {
    public int minCostClimbingStairs(int[] cost) {
      int n = cost.length;

      int[] dp = new int[n];

      if (n <= 2) {
        return Math.min(cost[0], cost[1]);
      }

      dp[n - 1] = cost[n - 1];
      dp[n - 2] = cost[n - 2];
      for (int i = n - 3; i >= 0; i--) {
        cost[i] += Math.min(cost[i + 1], cost[i + 2]);
      }
      System.out.println(Arrays.toString(cost));
      // dp[i] 는 i번째까지 최소 비용

      return Math.min(cost[0], cost[1]);
    }
  }
}
