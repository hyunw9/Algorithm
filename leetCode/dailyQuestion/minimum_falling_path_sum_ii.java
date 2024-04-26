package leetCode.dailyQuestion;

import java.util.Arrays;

public class minimum_falling_path_sum_ii {

  public int minFallingPathSum(int[][] grid) {

    int len = grid[0].length;
    int[][] dp = new int[len][len];
    for(int i = 0 ; i< len ; i++){
      Arrays.fill(dp[i],Integer.MAX_VALUE);
    }
    for(int i = 0 ; i< len ; i++){
      dp[0][i] = grid[0][i];
    }

    for(int i = 1 ; i< len; i++){

      for(int j = 0 ; j < len;j++){

        for(int k = 0 ; k < len ; k++){
          if(k == j) continue;
          dp[i][j] = Math.min(dp[i][j],dp[i-1][k]);
        }
        dp[i][j]+= grid[i][j];
      }
    }
    // System.out.println(Arrays.deepToString(dp));
    int min = Integer.MAX_VALUE;
    for(int i : dp[len-1]){
      min = Math.min(min,i);
    }
    return min;
  }

}
