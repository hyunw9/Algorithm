package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15486_퇴사 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    //부분해가 최대 해가 되어야 함 .
    //
    int n = Integer.parseInt(br.readLine());
    //T=1 일 경우에 그 다음날 보상을 받아야 한다.
    //마지막 날에 T가 1일 경우, 그 다음날에 보상을 받아야 하므로 N + 1 만큼 배열을 선언해준다.
    int[][] arr = new int[n + 2][2];
    int[] dp = new int[n + 2];
    Arrays.fill(dp, 0);
    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }
    int max = -1;
    for (int i = 1; i <= n + 1; i++) {
      int next = i+arr[i][0] ;
      max = Math.max(max,dp[i]);

      if(next <n +2) {
        dp[next] = Math.max(dp[next], max+ arr[i][1]);
        //여태 최대값 + 기존 보상
      }
    }
    for(int a : dp){
      max = Math.max(max,a);
    }
    bw.write(max+"");
    close();
  }
  // 1  2  3  4  5  6  7  8  9  10
  // 5  4  3  2  1  1  2  3  4  5
  //50 40 30 20 10 10 20 30 40 50

  // 1  2  3  4  5  6  7  8  9  10
  //               50 60    80
  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
