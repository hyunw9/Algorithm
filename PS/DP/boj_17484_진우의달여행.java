package PS.DP;

import java.io.*;
import java.util.*;
public class boj_17484_진우의달여행 {

    private static BufferedReader br;
  private static BufferedWriter bw;
  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n][m];
    int[][][] dp = new int[n][m][3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        if (i == 0) {
          Arrays.fill(dp[i][j], arr[i][j]);
        } else {
          Arrays.fill(dp[i][j], 987654321);
        }
      }
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (checkValid(i - 1, j + 1)) {
          dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
        }
        if (checkValid(i - 1, j)) {
          dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
        }
        if (checkValid(i - 1, j - 1)) {
          dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i][j];
        }
      }
    }
    int answer = 987654321;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < 3; j++) {
        answer = Math.min(answer, dp[n - 1][i][j]);
      }
    }

    System.out.println(answer);
    close();
  }

  public static boolean checkValid(int i, int j) {
    return (0 <= i && i < n) && (0 <= j && j < m);
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