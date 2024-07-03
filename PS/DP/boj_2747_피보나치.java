package PS.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2747_피보나치 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());

    int[] dp = new int[46];
    dp[0] = 1;
    dp[1] = 1;

    for(int i = 2 ; i < dp.length;i++){
      dp[i] = dp[i-1]+dp[i-2];
    }
    bw.write(dp[n-1]+"");
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
