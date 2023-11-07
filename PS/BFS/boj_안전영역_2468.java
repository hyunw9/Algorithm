package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_안전영역_2468 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int[][] map;
  private static boolean[][] flooded;
  private static boolean[][] used;
  private static int max = Integer.MIN_VALUE;
  private static int safetyZone;
  private static int size;

  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    size = Integer.parseInt(st.nextToken());
    map = new int[size][size];
    flooded = new boolean[size][size];
    used = new boolean[size][size];

    //2차원 배열 생성
    for (int i = 0; i < size; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < size; j++) {
        int now = Integer.parseInt(st.nextToken());
        map[i][j] = now;
        max = Math.max(max, now);
      }
    }
    //높이는 1부터 100
    for (int i = 1; i <= 100; i++) {
      //배열 초기화
      for (int j = 0; j < size; j++) {
        Arrays.fill(flooded[j], false);
        Arrays.fill(used[j],false);
      }

      //만약 현재 인덱스보다 2차원 배열의 값이 높으면, 안전지대가 형성되는 것이므로
      for (int j = 0; j < size; j++) {
        for (int k = 0; k < size; k++) {
          if (map[j][k] >= i) {
            flooded[j][k] = true;
          }
        }
      }
      int tmp = 0;
      for (int j = 0; j < size; j++) {
        for (int k = 0; k < size; k++) {
          //현 위치가 방문하지 않았고, 안전지대라면
          if(!used[j][k]&&flooded[j][k]) {
            dfs(j, k);
            tmp++;
          }
        }
      }
      safetyZone = Math.max(safetyZone,tmp);
    }
    bw.write(safetyZone+"");
    close();
  }

  public static void dfs(int i, int j) {

    used[i][j] = true;

    for (int k = 0; k < 4; k++) {
      int nx = dx[k] + j;
      int ny = dy[k] + i;

      if (nx >= size || ny >= size)
        continue;

      if (nx < 0 || ny < 0 || used[ny][nx]||!flooded[ny][nx])
        continue;

      dfs(ny, nx);
    }
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }
}
