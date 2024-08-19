package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_4485_녹색옷입은애가젤다지 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    init();
    int count = 1;
    while (true) {

      int n = Integer.parseInt(br.readLine());
      
      if( n == 0) break;

      int[][] map = new int[n][n];
      for (int i = 0; i < n; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      int[][] res = new int[n][n];
      for (int i = 0; i < n; i++) {
        Arrays.fill(res[i], Integer.MAX_VALUE);
      }

      PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);
      res[0][0] = map[0][0];
      q.add(new int[] {0, 0,map[0][0]});
      while (!q.isEmpty()) {
        int[] p = q.poll();
        // System.out.println(Arrays.toString(p));
        int y = p[0];
        int x = p[1];

        // if(y==n-1 && x==n-1){
        //     break;
        // }
        for (int i = 0; i < 4; i++) {
          int ny = dy[i] + y;
          int nx = dx[i] + x;

          if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;

          if (res[ny][nx] > map[ny][nx] + res[y][x]) {
            res[ny][nx] = Math.min(res[ny][nx], map[ny][nx] + res[y][x]);
            q.add(new int[] {ny, nx, res[ny][nx]});
          }
        }
      }
      System.out.println(String.format("Problem %d: %d",count,res[n-1][n-1]));
      count++;
    }
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
