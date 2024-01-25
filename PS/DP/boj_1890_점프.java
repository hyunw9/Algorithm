package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1890_점프 {


  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[][] map = new int[n][n];
    long[][] dp = new long[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dp[0][0] = 1;
    for (int i = 0; i < n; i++) {

      for (int j = 0; j < n; j++) {
        if (i == n - 1 && j == n - 1) {
          continue;
        }
        if (dp[i][j] > 0) {
          int forward = map[i][j];
          int right = forward + j;
          int down = forward + i;

          if (down < n) {
            dp[down][j] = dp[down][j] + dp[i][j];
          }

          if (right < n) {
            dp[i][right] = dp[i][right] + dp[i][j];
          }

        }
      }

    }
    bw.write(dp[n - 1][n - 1] + "");
    close();
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
