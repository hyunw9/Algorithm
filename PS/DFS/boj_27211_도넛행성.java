package PS.Dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class boj_27211_도넛행성 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static boolean[][] map;
  private static ArrayDeque<Node> dq;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};
  private static int ans;
  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    dq = new ArrayDeque<>();
    map = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        if (st.nextToken().equals("0")) {
          map[i][j] = true;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j]) {
          map[i][j] = false;
          dq.addFirst(new Node(i, j));
          bfs();
          ans++;
        }
      }
    }
    bw.write(ans + "");
    close();
  }

  public static void bfs() {

    while (!dq.isEmpty()) {
      Node now = dq.pollLast();

      for (int i = 0; i < 4; i++) {
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];

        if (nx > m - 1) {
          nx = 0;
        } else if (nx < 0) {
          nx = m - 1;
        } else if (ny > n - 1) {
          ny = 0;
        } else if (ny < 0) {
          ny = n - 1;
        }
        if (!map[ny][nx]) {
          continue;
        }
        map[ny][nx] = false;
        dq.addFirst(new Node(ny, nx));
      }
    }
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

  private static class Node {

    int y;
    int x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
