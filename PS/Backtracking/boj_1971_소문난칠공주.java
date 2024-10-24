package PS.Backtracking;

import java.io.*;
import java.util.*;

public class boj_1971_소문난칠공주 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static boolean[] used;
  private static int ans;
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static char[][] grid;
  private static int[] pick;
  public static void main(String[] args) throws IOException {
    init();
    grid = new char[5][5];
    used = new boolean[25];
    for (int i = 0; i < 5; i++) {
      String line = br.readLine();
      for (int j = 0; j < 5; j++) {
        grid[i][j] = line.charAt(j);
      }
    }
    pick = new int[7];
    search( 0, 0, 0);
    System.out.println(ans);
    close();
  }

  public static void search(int idx, int cnt, int s) {
    if (cnt == 7) {
      if (s >= 4) {
        ans += bfs();
      }
      return;
    }

    for (int i = idx; i < 25; i++) {
      if (used[i]) continue;

      pick[cnt] = i;
      used[i] = true;
      if (grid[i / 5][i % 5] == 'S') {
        search( i + 1, cnt + 1, s + 1);
      } else {
        search(i + 1, cnt + 1, s);
      }
      used[i] = false;
      pick[cnt] = 0;
    }
  }

  private static int bfs() {
    Queue<int[]> q = new LinkedList<>();

    boolean[][] visited = new boolean[5][5];
    int fy = pick[0] / 5;
    int fx = pick[0] % 5;
    visited[fy][fx] = true;
    q.add(new int[] {fy, fx});
    int cnt = 1;

    while (!q.isEmpty()) {
      int[] curr = q.poll();
      int y = curr[0];
      int x = curr[1];

      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];

        if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue;
        if (visited[ny][nx]) continue;
        if(!used[ny*5+nx]) continue;

        visited[ny][nx] = true;
        cnt += 1;
        q.offer(new int[] {ny, nx});
      }
    }
    System.out.println(cnt);
    if (cnt == 7) return 1;
    else return 0;
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

/*
 ** 간략한 풀이 :
 */
