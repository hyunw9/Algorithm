package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_2615_오목 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[][] map;
  private static Set<int[]> answer;

  // private static int[] dx = {-1,0,1,1};
  // private static int[] dy = {1,1,1,0};
  // 왼대각아래 아래 오대각아래 오른쪽

  public static void main(String[] args) throws IOException {
    init();
    map = new int[19][19];
    for (int i = 0; i < 19; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      for (int j = 0; j < 19; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    // 아래로만 뻗어나가야 함
    boolean flag = false;

    for (int i = 0; i < 19; i++) {
      for (int j = 0; j < 19; j++) {
        if (!flag && map[i][j] > 0) {
          flag = search(map[i][j], i, j);
        }
        if (flag) {
          System.out.println(map[i][j]);
          System.out.println((i + 1) + " " + (j + 1));
          break;
        }
      }
      if (flag) break;
    }
    if (!flag) {
      System.out.println(0);
    }
    close();
  }

  public static boolean search(int team, int y, int x) {
    Queue<int[]> q = new LinkedList<>();
    // System.out.println("team: "+ team);
    // 왼대각아래 아래 오대각아래 오른쪽

    int cnt = 0;
    int i = 0;
    while (x + i < 19 && map[y][x + i] == team) {
      // System.out.println(map[y][x+i]);
      if (map[y][x + i] == team) {
        cnt += 1;
      }
      i++;
    }

    // System.out.println(cnt);
    if (x - 1 >= 0 && map[y][x - 1] == team && cnt == 5) return false;
    if (cnt == 5) return true;
    cnt = 0;
    i = 0;
    while (y + i < 19 && x + i < 19 && map[y + i][x + i] == team) {

      cnt += 1;
      i++;
    }
    if (y - 1 >= 0 && x - 1 >= 0 && map[y - 1][x - 1] == team && cnt == 5) return false;
    if (cnt == 5) return true;

    i = 0;
    cnt = 0;
    while (y + i < 19 && map[y + i][x] == team) {
      cnt += 1;
      i++;
    }
    if (y - 1 >= 0 && map[y - 1][x] == team && cnt == 5) return false;
    if (cnt == 5) return true;

    i = 0;
    cnt = 0;
    while (y - i >= 0 && x + i < 19 && map[y - i][x + i] == team) {
      cnt += 1;
      //   System.out.println(y+ " "+ x );
      //   System.out.println("loc :: y : "+ (y-i) + " x :" + (x+i) + " cnt: " + cnt);
      i++;
    }
    if (y + 1 < 19 && x - 1 >= 0 && map[y + 1][x - 1] == team && cnt == 5) return false;
    if (cnt == 5) return true;

    return false;
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
