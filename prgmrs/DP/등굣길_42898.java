package prgmrs.DP;

public class 등굣길_42898 {
  public int solution(int m, int n, int[][] puddles) {
    int answer = 0;
    int[][] dp = new int[n+1][m+1];

    for(int[] arr : puddles){
      int x = arr[0];
      int y = arr[1];
      dp[y][x] = -1;
    }
    dp[1][1] = 1;
    for(int i = 1 ; i <= n ; i++){
      for(int j = 1 ; j <= m ; j ++){
        if(dp[i][j]==-1){
          dp[i][j] = 0;
          continue;
        }
        if(i != 1) dp[i][j] +=dp[i-1][j]%1000000007;
        if(j != 1) dp[i][j] += dp[i][j-1]%1000000007;
      }
    }
    return dp[n][m]%1000000007;
  }

}
