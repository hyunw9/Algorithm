package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_17212_달나라토끼를위한구매대금지불도우미 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    // 1 2 5 7
    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11, 12
    // 1  1  2  1  1  2  1
    int[] dp = new int[n + 8];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    dp[3] = 2;
    dp[4] = 2;
    dp[5] = 1;
    dp[6] = 2;
    dp[7] = 1;
    if (n > 7) {
      for (int i = 8; i <= n; i++) {

        dp[i] = Math.min(dp[i - 1], Math.min(dp[i - 2], Math.min(dp[i- 5], dp[i - 7]))) + 1;
      }
    }

    System.out.println(dp[n]);
    close();
  }

  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}
