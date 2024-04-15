package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1941_이다솜파 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static char[][] map;
  private static boolean[][] used;
  private static int answer;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    init();
    map = new char[5][5];
    used = new boolean[5][5];
    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String line = st.nextToken();
      for (int j = 0; j < 5; j++) {
        map[i][j] = line.charAt(j);
      }
    }
    System.out.println(Arrays.deepToString(map));
    dfs(0, 0, 0, 0);
    bw.write(answer + "");
    bw.close();
  }

  public static void dfs(int depth, int ids, int x, int y) throws IOException {

    if (depth == 7) {
      if (ids > 3) {
        answer++;
      }
      return;
    }
    for (int i = 0; i < 25; i++) {
      int nx = i % 5;
      int ny = i / 5;

      if (used[ny][nx]) {
        continue;
      }
      if (!valid(depth, ids)) {
        continue;
      }


      used[ny][nx] = true;
      if (map[ny][nx] == 'S') {
        dfs(depth + 1, ids + 1, nx, ny);

      } else {
        dfs(depth + 1, ids, nx, ny);
      }
      used[ny][nx] = false;

    }
  }

  public static boolean valid(int depth, int ids) {
    if (ids + (7 - depth) < 4) {
      return false;
    }
    return true;
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

