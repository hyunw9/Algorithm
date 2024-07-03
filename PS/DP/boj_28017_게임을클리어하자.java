package PS.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_28017_게임을클리어하자 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] dp = new int[n];
    Arrays.fill(dp,Integer.MAX_VALUE);
    for(int i = 0 ; i < n; i++){
      st = new StringTokenizer(br.readLine());

      for(int j=0;j<m;j++){
        int now = Integer.parseInt(st.nextToken());
//        System.out.println("now: "+now);
//        System.out.println(Arrays.toString(dp));
          dp[j] = Math.min(dp[j], now);
      }
    }
    int sum=0;
    for(int v : dp){
      sum+=v;
    }
    bw.write(sum+"");
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
