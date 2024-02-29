package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_9465_스티커 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int t = Integer.parseInt(br.readLine());
    while(--t>=0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[][] arr = new int[2][n];
      for (int i = 0; i < 2; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      //  이전거 vs 이전 아래 + 현재거 .
      int[][] dp = new int[2][n];
      dp[0][0] = arr[0][0];
      dp[1][0] = arr[1][0];
      for (int i = 1; i < n; i++) {
        dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1] + arr[0][i]);
        dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] + arr[1][i]);
      }
      bw.write(Math.max(dp[0][n-1],dp[1][n-1])+"\n");
    }
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
