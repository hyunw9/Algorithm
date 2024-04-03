package PS.BFS;

import java.io.*;
import java.util.*;

public class boj_16928_뱀과사다리게임 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int[] ladder = new int[101];
    int[] snake = new int[101];
    int[] dx = {1, 2, 3, 4, 5, 6};
    boolean[] used = new boolean[101];
    ArrayDeque<int[]> dq = new ArrayDeque<>(); // {현위치, 요금}

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    Arrays.fill(ladder, 0);
    Arrays.fill(snake, 0);
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      ladder[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      snake[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
    }
    used[1] = true;
    dq.addLast(new int[] {1, 0});
    int min = Integer.MAX_VALUE;
    while (!dq.isEmpty()) {
      int[] now = dq.pollFirst();
      int num = now[0];
      int cost = now[1];

      if (num == 100) {
        min = Math.min(min, cost);
      }

      for (int i = 0; i < 6; i++) {
        int nextNum = dx[i] + num;
        if (nextNum > 100) continue;

        if (!used[nextNum]) {
          used[nextNum] = true;

          if (ladder[nextNum] > 0) {
            used[ladder[nextNum]] = true;
            dq.add(new int[] {ladder[nextNum], cost + 1});
          } else if (snake[nextNum] > 0) {
            used[snake[nextNum]] = true;
            dq.add(new int[] {snake[nextNum], cost + 1});
          } else {
            dq.add(new int[] {nextNum, cost + 1});
          }
        }
      }  
    }
    bw.write(min + "");
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
