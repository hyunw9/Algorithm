package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_1309_동물원 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 3;
    for(int i = 2; i<=n;i++){
      dp[i] = (2*dp[i-1] + dp[i-2]) % 9901;
    }
    bw.write(dp[n]+"");
    close();
  }
  //https://www.acmicpc.net/problem/1309

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
