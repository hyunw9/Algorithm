package PS.Bruteforce;

import java.io.*;
import java.util.*;

public class boj_1051_숫자정사각형 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    String line = br.readLine();
    int n = Integer.parseInt(line.split(" ")[0]);
    int m = Integer.parseInt(line.split(" ")[1]);
    int maxSize = Math.max(n, m);
    int square = 0;
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
      String curr = br.readLine();
      for (int j = 0; j < m; j++) {
        arr[i][j] = curr.charAt(j) - '0';
      }
    }
    for (int i = 0; i < maxSize; i++) {

      for (int j = 0; j < n; j++) {

        for (int k = 0; k < m; k++) {
          if (k + i >= m || j + i >= n) continue;
          if (arr[j][k] == arr[j][k + i]
              && arr[j + i][k] == arr[j + i][k + i]
              && arr[j][k] == arr[j + i][k]) {
            // System.out.println("i : "+ i+ " j : " + j + "arr[j][k] : " + arr[j][k] );
            square = Math.max(square, (i + 1) * (i + 1));
          }
        }
      }
    }

    // System.out.println(Arrays.deepToString(arr));
    bw.write(square + "");
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
