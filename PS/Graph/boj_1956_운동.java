package PS.Graph;

import java.io.*;
import java.util.*;

public class boj_1956_운동 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int v = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());

    int[][] map = new int[v + 1][v + 1];

    for (int i = 1; i <= v; i++) {
      Arrays.fill(map[i],987654321);
      map[i][i] = 0;
    }

    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      map[a][b] = c;
    }

    for (int k = 1; k <= v; k++) {
      for (int i = 1; i <= v; i++) {
        for (int j = 1; j <= v; j++) {
          if (map[i][j] > map[i][k] + map[k][j]) {
            map[i][j] = map[i][k] + map[k][j];
          }
        }
      }
    }

    int res = 987654321;
    for(int i =1; i<=v; i++){
        for(int j =1; j<=v; j++){
            if(map[i][j]!=987654321 &&map[j][i]!=987654321&&i!=j){
                res = Math.min(map[i][j]+map[j][i],res);
            }
        }

    }
    if (res == 987654321) {
      System.out.println(-1);
    } else {
      System.out.println(res);
    }
    // System.out.println(Arrays.deepToString(map));
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
