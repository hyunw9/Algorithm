package PS.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1965_상자넣기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] box = new int[n];
    for (int i = 0; i < n; i++) {
      box[i] = Integer.parseInt(st.nextToken());
    }
    int[] dp = new int[n];
    dp[0] = 1;

    for (int i = 1; i < n; i++) {
      for(int j = 0; j<i;j++){
        if(box[j]<box[i]){
          dp[i] = Math.max(dp[i],dp[j]+1);
        }
        if(dp[i]==0){
          dp[i]=1;
        }
      }
    }
    int ans = 0;
    for (int a : dp) {
      ans = Math.max(ans, a);
    }
//    System.out.println(Arrays.toString(dp));
    bw.write(ans + "");
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
