package PS.Djikstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class boj_1261_알고스팟 {


  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    init();
    String[] line = br.readLine().split(" ");

    int m = Integer.parseInt(line[0]);
    int n = Integer.parseInt(line[1]);

    int[][] map = new int[n][m];
    int[][] cmap = new int[n][m];
    boolean[][] used = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      String l = br.readLine();
      Arrays.fill(cmap[i], Integer.MAX_VALUE);
      for (int j = 0; j < m; j++) {
        if (l.charAt(j) == '1') {
          map[i][j] = 1;
        } else {
          map[i][j] = 0;
        }
      }
    }
    cmap[0][0] = 0;
    PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    q.add(new int[]{0, 0, 0});

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int y = now[0];
      int x = now[1];
      int c = now[2];
      if (y == n - 1 && x == m - 1) {
        bw.write(c + "");
        break;
      }

      for (int i = 0; i < 4; i++) {
        int ny = dy[i] + y;
        int nx = dx[i] + x;
        if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
          continue;
        }
        if (!used[ny][nx]) {
          used[ny][nx] = true;

          if (map[ny][nx] == 1) {
            q.add(new int[]{ny, nx, c + 1});
          } else {
            q.add(new int[]{ny, nx, c});
          }
        }
      }
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
