package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14889_스타트와링크 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[][] map;
  private static int min = 987654321;
  private static int n;
  private static boolean[] used;

  public static void main(String[] args) throws IOException {
    init();
    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    used = new boolean[n];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(0,0);
    bw.write(min + "");
    close();
  }

  public static void dfs(int depth,int count) throws IOException {
    if (count == (n / 2)) {
      min = Math.min(min, getMinScore());
      return;
    }

    for (int i = depth; i < n; i++) {
      if (!used[i]) {
        used[i] = true;
        dfs(i+1,count+1);
        used[i] = false;
      }
    }
  }

  public static int getMinScore() throws IOException {
    int oneScore = 0;
    int twoScore = 0;

    for (int i = 0; i < used.length - 1; i++) {
      for (int j = i + 1; j < used.length; j++) {
        if (used[i] && used[j]) {
          oneScore += map[i][j] + map[j][i];
        } else if (!used[i] && !used[j]) {
          twoScore += map[i][j] + map[j][i];
        }
      }
    }
    int val =Math.abs(oneScore - twoScore);
    if(val == 0){
      bw.write(0+"");
      close();
      System.exit(0);
    }
    return val;
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }
/*뭐에서 시간 초과가 났을까 ? 바로 조합이다.
  dfs(i+1,count+1); 이 부분을
  dfs(depth+1,count+1); 로 작성하고 있었다.
    이 경우 i 값과 depth 값이 다른 경우가 생길 수 있어서 중복된 경우 탐색이 가능하다. */
}
