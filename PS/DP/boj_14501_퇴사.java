package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14501_퇴사 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    int[] day = new int[n+2];
    int[] price= new int[n+2];
    int[] dp = new int[n+2];
    int res = 0;
    for(int i = 1; i <=n; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      day[i]= Integer.parseInt(st.nextToken());
      price[i]= Integer.parseInt(st.nextToken());
    }
    for(int i = 1; i<=n+1;i++) {
      for(int j=1;j<i;j++){
        dp[i] = Math.max(dp[i],dp[j]);

        if(j+day[j]==i){
          dp[i]=Math.max(dp[i],dp[j]+price[j]);
        }
      }
      res = Math.max(res,dp[i]);
    }
    bw.write(res+"");
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
