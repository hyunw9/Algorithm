package PS.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_파도반수열_9461 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
  init();
  int n = Integer.parseInt(br.readLine());
  long[] dp = new long[101];
  dp[1] = 1;
  dp[2] = 1;
  dp[3] = 1;
  dp[4] = 2;
  dp[5] = 2;
  dp[6] = 3;
  dp[7] = 4;
  dp[8] = 5;
  dp[9] = 7;
  dp[10] = 9;
  for(int i = 11; i<=100;i++){
    dp[i] = dp[i-2] + dp[i-3];
  }
    for (int i = 0; i < n; i++) {
      long a = Long.parseLong(br.readLine());
      bw.write(dp[(int) a]+"\n");
    }

    bw.close();
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
