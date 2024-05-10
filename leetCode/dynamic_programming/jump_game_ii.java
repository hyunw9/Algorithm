package leetCode.dynamic_programming;

import java.util.Arrays;

public class jump_game_ii {

  public int jump(int[] nums) {
    // 0, max ,max ,max ,max
    // 0, 1, 1, max, max
    // 0 , 1, (1or2), 1, 1, 1
    int[]dp = new int[nums.length];
    Arrays.fill(dp,10000);
    dp[0]=0;
    for(int i = 0; i < nums.length; i++){
      int now = nums[i];
      for(int j = i+1 ; j <= i+now; j++){
        if(j >= dp.length) break;
        dp[j] = Math.min(dp[j],dp[i]+1);
      }
    }

    return dp[nums.length-1];
  }

}
