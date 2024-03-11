package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_2156_포도주시식 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n + 1];
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    if (n == 1) {
      bw.write(arr[0] + "");
    } else if (n == 2) {
      bw.write(arr[0] + arr[1] + "");
    } else {
      dp[1] = arr[1];
      dp[2] = dp[1] + arr[2];
      for (int i = 3; i <= n; i++) {
        dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
        dp[i] = Math.max(dp[i - 1], dp[i]);
      }

      bw.write(dp[n] + "");
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
