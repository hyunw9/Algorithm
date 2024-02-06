package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_4883_삼각그래프 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int tc = 0;
    while (true) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0) {
        break;
      }
      tc++;

      int[][] map = new int[n][3];
      for (int i = 0; i < n; i++) {

        StringTokenizer st = new StringTokenizer(br.readLine());
        map[i][0] = Integer.parseInt(st.nextToken());
        map[i][1] = Integer.parseInt(st.nextToken());
        map[i][2] = Integer.parseInt(st.nextToken());
      }

      int[][] dp = new int[n][3];
      dp[0][0] = map[0][0];
      dp[0][1] = map[0][1];
      dp[0][2] = map[0][2];
      for (int i = 1; i < n; i++) {

        if( i== 1){
          for(int j = 0 ; j < 3 ; j ++){
            if(j ==0) {
              dp[i][j] = dp[i - 1][1] + map[i][j];
            }else if(j == 1){
              dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j]+dp[i-1][j+1]))+map[i][j];
            }else if(j==2){
              dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j-1]+dp[i-1][j]))+map[i][j];
            }
          }
        }
        else{
        for (int j = 0; j < 3; j++) {
          //좌측일 경우, 위랑 위오른쪽 에서밖에 못받음
          if (j == 0) {
            dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + map[i][j];
          }
          //가운데일 경우 , 왼쪽과 위 좌측, 위 , 위 우측에서 받음
          else if (j == 1) {
            if (i == 1) {
              dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j + 1]), dp[i][j - 1]);
            } else {
              dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]),
                  Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + map[i][j];
            }
            //우측일경우 // 왼쪽과 위, 위 좌측에서 받음
          } else if (j == 2) {

            dp[i][j] =
                Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + map[i][j];
          }
        }
        }
      }
      //System.out.println(Arrays.deepToString(dp));
      bw.write(tc + ". " + dp[n - 1][1] + "\n");
    }
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
