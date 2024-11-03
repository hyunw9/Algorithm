package leetCode.dynamic_programming;

public class maximum_product_subarray {
  class Solution {
    public int maxProduct(int[] nums) {
      // dp 에는 최대 곱을 넣어주자.

      // 0 = 1 ;
      // 1 = dp[i-1] * arr[i] vs 2 vs -6
      int[] dp = new int[nums.length];
      int ans = nums[0];
      dp[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
        int max = 1;
        for (int j = 0; j <= i; j++) {
          max *= nums[j];
        }
        dp[i] = Math.max(max, nums[i]);
        ans = Math.max(ans, dp[i]);
      }
      // System.out.println(Arrays.toString(dp));
      return ans;
    }
  }
}
