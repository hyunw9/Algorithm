package PS.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class boj_1106_호텔 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int c = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[] cost = new int[c+101];

    int[] dp = new int[c+101];

    Arrays.fill(dp,987654321);
    dp[0] = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int fee = Integer.parseInt(st.nextToken());
      int people = Integer.parseInt(st.nextToken());

      for(int j = people; j<c+101; j++){
        dp[j] = Math.min(dp[j],fee+ dp[j-people]);
      }
    }
    int min = Integer.MAX_VALUE;
    for(int i = c ; i < c + 101; i++){
      min= Math.min(dp[i],min);
    }
//    System.out.println(Arrays.toString(dp));
    bw.write(min+"");
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
