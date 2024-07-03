package PS.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_9251_LCS {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    char[] a = br.readLine().toCharArray();
    char[] b = br.readLine().toCharArray();

    int[][] dp = new int[a.length+1][b.length+1];

    for(int i = 0; i< a.length; i++){
      dp[i][0] = 0;
    }
    for(int i = 0 ; i < b.length; i++){
      dp[0][i] = 0;
    }
    for(int i = 1; i <= a.length; i++){
      for(int j = 1; j<=b.length; j++){
        if(a[i-1] == b[j-1]){
          dp[i][j] = dp[i-1][j-1]+1;
        }else{
          dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        }
      }
    }
    bw.write(dp[a.length][b.length]+"");
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
