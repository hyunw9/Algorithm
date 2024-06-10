package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import leetCode.dailyQuestion.open_the_lock.Pair;

public class boj_5427_불 {

  static char[][] map;
  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};
  private static int wall = -1;
  private static int fire = 0;
  private static int path = 1;
  private static int sangeun = 2;

  public static void main(String[] args) throws IOException {

    init();
    int t = Integer.parseInt(br.readLine());
    while (--t >= 0) {
      String line = br.readLine();
      int m = Integer.parseInt(line.split(" ")[0]);
      int n = Integer.parseInt(line.split(" ")[1]);
      int[][] map = new int[n][m];
      for (int i = 0; i < n; i++) {
        line = br.readLine();
        for (int j = 0; j < m; j++) {
          char now = line.charAt(j);
          if (now == '#') {
            map[i][j] = wall;
          } else if (now == '*') {
            map[i][j] = fire;
          } else if (now == '.') {
            map[i][j] = path;
          } else {
            map[i][j] = sangeun;
          }
        }
      }
      Queue<Node> q = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (map[i][j] == fire) {
            q.add(new Node(i, j, 0, fire));
          }
        }
      }
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (map[i][j] == sangeun) {
            q.add(new Node(i, j, 0, sangeun));
          }
        }
      }
      boolean flag = false;

      while (!q.isEmpty()) {
        Node now = q.poll();
        for (int i = 0; i < 4; i++) {

          int ny = dy[i] + now.y;
          int nx = dx[i] = now.x;

          if (ny >= 0 && nx >= 0 && ny < n && nx < m) {
            if (now.state == fire && map[ny][nx] != wall && map[ny][nx] != fire) {
              q.add(new Node(ny, nx, 0, fire));
              map[ny][nx] = fire;
            } else if (now.state == sangeun && map[ny][nx] == path) {
              q.add(new Node(ny, nx, now.value + 1, sangeun));
              map[ny][nx] = sangeun;
            }
          } else {
            if(now.state == sangeun){
              bw.write((now.value+1)+"\n");
              System.out.println(now.value+1);
              flag = true;
              break;
            }
          }
        }
        if (flag) {
          //탈출 성공 !
          break;
        }
      }
      if (!flag) {
        bw.write("IMPOSSIBLE\n");
      }
      System.out.println(Arrays.deepToString(map));

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

  static class Node {

    int y;
    int x;
    int value;
    int state;

    public Node(int y, int x, int value, int state) {
      this.y = y;
      this.x = x;
      this.value = value;
      this.state = state;
    }
  }

}
