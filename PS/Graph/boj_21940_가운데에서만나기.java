package PS.Graph;

import java.io.*;
import java.util.*;

public class boj_21940_가운데에서만나기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    // 왕복시간은 자신이 살고 있는 도시에서 도시
    // $X$로 이동하는 시간과 도시
    // $X$에서 다시 자신이 살고 있는 도시로 이동하는 시간을 합한 것이다.
    // 준형이와 친구들이 도로를 이용하여 갈 수 있는 도시만 선택한다.
    // 준형이와 친구들의 왕복시간 들 중 최대가 최소가 되는 도시
    // $X$를 선택한다.
    // 준형이와 친구들이 이동할 수 있는 도시가 최소한 하나 이상이 있음을 보장한다.

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] map = new int[n + 1][m + 1];
    // 초기화
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == j) map[i][j] = 0;
        else {
          map[i][j] = 987654321;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      map[start][end] = c;
    }
    int q = Integer.parseInt(br.readLine());
    int[] cities = new int[q];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < q; i++) {
      cities[i] = Integer.parseInt(st.nextToken());
    }
    for (int k = 1; k <= n; k++) {

      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          if (map[i][j] > map[i][k] + map[k][j]) {
            map[i][j] = map[i][k] + map[k][j];
          }
        }
      }
    }
    HashMap<Integer, Integer> hmap = new HashMap<>();
    int[] maxArr = new int[n + 1];
    // 준형이와 친구들이 도시 X까지 왕복하는데 걸리는 시간들 중
    //  최댓값(도시 X에 대한 왕복시간 중 최댓값)들을 구하고

    // 최댓값들 중에서 최솟값인 도시 X를 선택한다.

    // 와 같은 식으로 좀 더 직관적인 문장으로 수정하면 요구사항을 더 잘 파악할 수 있을 것 같습니다.
    int min = Integer.MAX_VALUE;
    ArrayList<Integer> best = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      int maxTime = 0;
      boolean reachable = true;
      for (int city : cities) {

        if (map[city][i] == 987654321 || map[i][city] == 987654321) {
          reachable = false;
          break;
        }
        maxTime = Math.max(maxTime, map[i][city] + map[city][i]);
      }
      if (reachable && maxTime < min) {
        min = maxTime;
        best.clear();
        best.add(i);
      } else if (reachable && maxTime == min) {
        best.add(i);
      }
    }
    Collections.sort(best);
    for (Integer i : best) {
      bw.write(i + " ");
    }
    close();
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
