package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11722_가장긴감소하는수열 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr= new int[n];
    int[] dp = new int[n];
    for(int i = 0 ; i < n ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    dp[0]= 1;

    for(int i = 1; i<n; i++){
      int max = 0;
      for(int j = 0; j<i ;j++){
        if(arr[i]<arr[j]){
          max = Math.max(dp[j],max);
        }
      }
      dp[i] = max+1;
    }

//    System.out.println(Arrays.toString(dp));
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
