package PS.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_16924_십자가찾기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static char[][] map;
  private static boolean[][] used;
  private static ArrayList<int[]> arr;
  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new char[n][m];
    used = new boolean[n][m];
    arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = line.charAt(j);
        if (map[i][j] == '*') {
          used[i][j] = false;
        } else {
          used[i][j] = true;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == '*') {

          search(i, j);
          //dfs(i,j,1);
        }
      }
    }

    //
    int size = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!used[i][j]) {
          size = -1;
          break;
        }
      }
    }
    //System.out.println(Arrays.deepToString(used));
    //System.out.println(Arrays.deepToString(map));

    if (size == -1) {
      bw.write(size + "");
    } else {
      size = arr.size();
      bw.write(size + "\n");
      for (int[] ans : arr) {
        bw.write(ans[0] + " " + ans[1] + " " + ans[2] + "\n");
      }
    }

    close();
    // *
    //***
    // *
  }

  public static void search(int y, int x) {
    int cnt = 0;
    while (true) {
      int pny = y + cnt;
      int pnx = x + cnt;
      int mny = y - cnt;
      int mnx = x - cnt;

      if (mny < 0 || mnx < 0 || pny >= n || pnx >= m) {
        cnt -= 1;
        break;
      }
      else if (map[y][pnx] == '*' && map[y][mnx] == '*' && map[pny][x] == '*' && map[mny][x] == '*') {
        if(cnt>0) arr.add(new int[]{y + 1, x + 1, cnt});
        cnt++;
//        cnt++;
      } else {
        cnt -= 1;
        break;
      }

    }
//    System.out.println("cnt: "+ cnt+ " y : "+ y + "x : "+ x);
    if (cnt > 0) {
     // arr.add(new int[]{y + 1, x + 1, cnt});
      int idx = 0;
      while (idx <= cnt) {
        if(x+idx>=m || x-idx <0 || y+idx>=n||y-idx<0) break;
        used[y][x + idx] = true;
        used[y][x - idx] = true;
        used[y + idx][x] = true;
        used[y - idx][x] = true;
        idx++;
      }
//      System.out.println(Arrays.deepToString(used));
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

}
