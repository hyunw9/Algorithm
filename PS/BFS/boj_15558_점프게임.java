package PS.BFS;

import java.io.*;
import java.util.*;

public class boj_15558_점프게임 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int n;
  private static int k;
  private static boolean flag;
  private static Queue<int[]> q;
  private static int[][] map;
  private static boolean[][] visited;
  private static int[] dx;
  private static int[] dy = {0, 0, 1};

  public static void main(String[] args) throws IOException {
    init();

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    dx = new int[3];
    dx[0] = -1;
    dx[1] = 1;
    dx[2] = k;

    char[] up = br.readLine().toCharArray();
    char[] down = br.readLine().toCharArray();

    map = new int[2][n];
    visited = new boolean[2][n];
    Arrays.fill(visited[0], false);
    Arrays.fill(visited[1], false);
    Arrays.fill(map[0], 2);
    Arrays.fill(map[1], 2);
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) {
          map[i][j] = up[j] - '0';
        } else {
          map[i][j] = down[j] - '0';
        }
      }
    }
    // System.out.println(Arrays.deepToString(map));
    q = new LinkedList<>();
    visited[0][0] = true;
    q.add(new int[] {0, 0, 0});

    bfs();

    if (flag) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
    close();
  }

  public static void bfs() {
    while (!q.isEmpty()) {
      int[] curr = q.poll();

      int y = curr[0];
      int x = curr[1];
      int time = curr[2];
      //   System.out.println("y : "+ y+ " x : "+ x + " cnt :"+ cnt);
      if (x + k >= n) {
        flag = true;
        return;
      }
      if (x < time) continue;

      if (x + 1 < n && !visited[y][x + 1] && map[y][x + 1] == 1) {
        visited[y][x + 1] = true;
        q.add(new int[] { y,x+1, time + 1});
      }

      if (x - 1 > time && !visited[y][x - 1] && map[y][x - 1] == 1) {
        visited[y][x - 1] = true;
        q.add(new int[] { y,x-1, time + 1});
      }
      if (x + k < n && !visited[(y + 1) % 2][x+k] && map[(y + 1) % 2][x+k] == 1) {
        visited[(y + 1) % 2][x+k] = true;
        q.add(new int[] { (y + 1) % 2,x + k, time + 1});
      }

      // if(nx<0 ||( nx<n&&map[ny][nx]==0) ) continue;
      // if(nx<n && used[ny][nx]) continue;
      // if(nx<time) continue;
      // if(nx<n) used[ny][nx] = true;

    }
    flag = false;
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
