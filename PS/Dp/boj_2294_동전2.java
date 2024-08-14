package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_2294_동전2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] coins = new int[n];
    int[] dp = new int[k + 1];
    Arrays.fill(dp,987654321);
    dp[0] = 0;
    for (int i = 0; i < n; i++) {
      int val = Integer.parseInt(br.readLine());
      coins[i] = val;
    }
    Arrays.sort(coins);

    for (int i = 1; i <= k; i++) {

      // 가장 마지막 큰 코인을 찾아서, coin[val] + coin[curr%val];
      int val = 0;

      for (int coin : coins) {
        // System.out.println("coin: " + coin);
        if (coin <= i) {
            
            if(i==coin){
                dp[i]= 1;
            }
          dp[i] = Math.min(dp[i], dp[coin] + dp[(i - coin)]);
        } else {
          break;
        }
      }
    //   System.out.println("i: " + i + " val : " + val);
    }
    // System.out.println(Arrays.toString(dp));
    if(dp[k]>10000){
        System.out.println(-1);
    }else{
        System.out.println(dp[k]);
    }
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
