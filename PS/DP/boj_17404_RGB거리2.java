package PS.DP;

import java.io.*;
import java.util.*;

public class boj_17404_RGB거리2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int answer= Integer.MAX_VALUE;
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    int[][] arr= new int[n][3];
    int[][] dp = new int[n][3];
    for(int i = 0 ; i < n ; i ++){
        st= new StringTokenizer(br.readLine());
        for(int j = 0 ; j < 3 ; j ++){
            arr[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    for(int k = 0 ; k <3 ; k++){

        for(int i = 0 ; i < 3; i++){
            if( i== k){
                dp[0][i] = arr[0][i];
            }else{
                dp[0][i] = 100000;
            }
        }

        for(int i = 1; i < n ; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+arr[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+arr[i][1];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0])+arr[i][2];
        }
        for(int i = 0 ; i < 3 ; i++){
            if ( i != k){
                answer = Math.min(answer,dp[n-1][i]);
            }
        }
    }
    bw.write(answer+"");
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
