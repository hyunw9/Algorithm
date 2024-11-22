package PS.simulation;

import java.io.*;
import java.util.*;

public class boj_20165_인내의도미노장인호석 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[][] map;
  private static char[][] grid;
  private static HashMap<String, int[]> dirMap;
  private static int n;
  private static int m;
  private static int score;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    int round = Integer.parseInt(st.nextToken());
    dirMap = new HashMap<>();
    dirMap.put("E", new int[] {0, 1});
    dirMap.put("W", new int[] {0, -1});
    dirMap.put("S", new int[] {1, 0});
    dirMap.put("N", new int[] {-1, 0});

    map = new int[n][m];
    grid = new char[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        grid[i][j] = 'S';
      }
    }

    while (--round >= 0) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      String dir = st.nextToken();
      slide(r, c, dir);
      st = new StringTokenizer(br.readLine());
      r = Integer.parseInt(st.nextToken());
      c = Integer.parseInt(st.nextToken());
      stand(r, c);
    }
    System.out.println(score);
    for (int i = 0; i < n; i++) {
        for(int j = 0 ; j < m ; j++){
            System.out.print(grid[i][j]+" ");
        }
      System.out.println();
    }
    close();
  }

  public static void slide(int r, int c, String dir) {
    // 1,2,3
    Queue<int[]> q = new LinkedList<>();
    if (grid[r - 1][c - 1] == 'F') return;

    score += 1;
    grid[r - 1][c - 1] = 'F';
    q.offer(new int[] {r, c, map[r - 1][c - 1]});

    while (!q.isEmpty()) {
      int[] curr = q.poll();
      int y = curr[0];
      int x = curr[1];
      int times = curr[2];
      
      int ny = y;
      int nx = x;
      for (int i = 0; i < times - 1; i++) {

        ny += dirMap.get(dir)[0];
        nx += dirMap.get(dir)[1];
        if (ny <= 0 || nx <= 0 || ny > n || nx > m) continue;
        if (grid[ny - 1][nx - 1] == 'F') continue;
        grid[ny - 1][nx - 1] = 'F';
        score += 1;
        q.offer(new int[] {ny, nx, map[ny - 1][nx - 1]});
      }
    }
  }

  public static void stand(int y, int x) {
    if (grid[y - 1][x - 1] == 'F') grid[y - 1][x - 1] = 'S';
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
