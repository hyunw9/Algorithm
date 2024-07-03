package PS.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2660_회장뽑기2 {

  static final int INF = 987654321;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[][] map = new int[n + 1][n + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i != j)
          map[i][j] = INF;
      }
    }

    String line;
    while (!(line = br.readLine()).equals("-1 -1")) {
      StringTokenizer st = new StringTokenizer(line);
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      map[a][b] = 1;
      map[b][a] = 1;

    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (map[i][k] + map[k][j] < map[i][j]) {
            map[i][j] = map[i][k] + map[k][j];
          }
        }
      }
    }
    for (int i = 0; i <= n; i++) {
      System.out.println(Arrays.toString(map[i]));
    }


  }
}
