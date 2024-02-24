package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_3098_소셜네트워크 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    boolean[][] used = new boolean[n + 1][n + 1];
    Set<Integer>[] has = new HashSet[n + 1];
    ArrayList<Integer>[] arr = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = new ArrayList<>();
      has[i] = new HashSet<>();
      has[i].add(i);
      used[i][i] = true;
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      has[e].add(s);
      has[s].add(e);
      arr[s].add(e);
      arr[e].add(s);


    }
//    System.out.println(Arrays.deepToString(used));
    Queue<int[]> q = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    int day = 0;
    while (!check(n, has)) {
      day += 1;
      int added = 0;

      for (int i = 1; i <= n; i++) {

        for (int friend : arr[i]) {
          for (int frfriend : arr[friend]) {
            if (!has[i].contains(frfriend)) {
              added += 1;
              has[i].add(frfriend);
              has[frfriend].add(i);
              q.add(new int[]{i, frfriend});
            }
          }

        }
      }
      while (!q.isEmpty()) {
        int[] now = q.poll();
        arr[now[0]].add(now[1]);
        arr[now[1]].add(now[0]);
      }

      sb.append(added+"\n");
    }
    bw.append(day+"\n");
    bw.append(sb.toString());
    // 1 2
    // 2 1 3
    // 3 2

    close();
  }

  public static boolean check(int n, Set<Integer>[] sets) {
    for (int i = 1; i <= n; i++) {
      if (sets[i].size() < n) {
        return false;
      }
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
