package leetCode.dynamic_programming.knapsack;

public class coin_change_2 {
    class Solution {
        public int change(int amount, int[] coins) {
            int[][] dp = new int[coins.length+1][amount+1];
    
            for(int i = 0 ; i <= coins.length; i++){
                dp[i][0] = 1;
            }
    
            for(int i = 1; i <= coins.length; i++){
                for(int j = 1; j <= amount; j++){
    
                    if(j - coins[i-1]>= 0){
                        dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
    
            // System.out.println(Arrays.deepToString(dp));
            return dp[coins.length][amount];
        }
    }
}
