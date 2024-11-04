package leetCode.dynamic_programming;

import java.util.Arrays;

public class longest_increasing_subsequence {
  class Solution {
    public int lengthOfLIS(int[] nums) {
      int[] dp = new int[nums.length];
      dp[nums.length - 1] = 1;
      int ans = dp[nums.length - 1];
      for (int i = nums.length - 2; i >= 0; i--) {

        int curr = nums[i];
        int max = 0;
        int idx = i;
        for (int j = i; j < nums.length; j++) {
          if (nums[j] > curr) {
            if (dp[j] > max) {
              max = dp[j];
            }
          }
        }
        dp[i] = Math.max(max + 1, 1);
        ans = Math.max(ans, dp[i]);
      }
      System.out.println(Arrays.toString(dp));
      return ans;
    }
  }
}
