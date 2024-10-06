package PS.Dfs;

import java.io.*;
import java.util.*;

public class boj_17265_나의인생에는수학과함께 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int n;
  private static char[][] map;
  private static boolean[][] used;
  private static int[] dx = {1,0};
  private static int[] dy = {0,1};
  private static int min = Integer.MAX_VALUE;
  private static int max = 0;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    map = new char[n][n];
    used = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = st.nextToken().charAt(0);
      }
    }

    used[0][0] = true;
    dfs(0, 0, map[0][0]-'0',true, ' ');
    for (int i = 0; i < n; i++) {
      System.out.println(Arrays.toString(map[i]));
    }
    System.out.println(max+" "+ min);
    // System.out.println('9' - '0');
    close();
  }

  public static void dfs(int y, int x, int val, boolean expect, char ops) {
    // System.out.println(" y : " + y + " x : " + x + " map[y][x] :" + map[y][x]);

    if (y == n - 1 && x == n - 1) {

        min = Math.min(min, val);
        max = Math.max(max, val);
      
      return;
    }

    for (int i = 0; i < 2; i++) {
      int nx = dx[i] + x;
      int ny = dy[i] + y;

      if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;

      char next = map[ny][nx];

      if (expect && (next == '+' || next == '-' || next == '*')) {
        dfs(ny, nx, val, false, next);
      } else if(!expect && Character.isDigit(next)) {
        int num = next - '0';
        int result = calculate(val, num, ops);
        dfs(ny, nx, result, true, ' ');
      }
    }
  }

  public static int calculate(int a, int b, char ops) {
    switch (ops) {
      case '+':
        return a + b;
      case '-':
        return a - b;
      case '*':
        return a * b;
      default:
        return b;
    }
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
