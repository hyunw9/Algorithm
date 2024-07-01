package prgmrs.DP;

public class 가장큰정사각형찾기_12905 {
  public int solution(int[][] board) {
    int answer = 0;

    int[][] dp = new int[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dp[i][j] = board[i][j];
      }
    }
    int max = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (i < 1 || j < 1) {
          if (board[i][j] == 1) {
            dp[i][j] = 1;
            answer = Math.max(answer, dp[i][j]);
          }
        } else {

          if (board[i][j] == 1) {
            dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
            answer = Math.max(answer, dp[i][j]);
          }
        }
      }
    }
    return answer * answer;
  }
}
