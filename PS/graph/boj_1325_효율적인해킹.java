package PS.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1325_효율적인해킹 {

  private static int[] cnt;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int max = 0;
    ArrayList<Integer>[] arr = new ArrayList[n + 1];
    cnt = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      arr[start].add(end);
    }
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= n; i++) {

      boolean[] used = new boolean[n + 1];
      used[i] = true;
      q.add(i);

      while (!q.isEmpty()) {
        int now = q.poll();
        for (int next : arr[now]) {
          if (!used[next]) {
            used[next] = true;
            q.add(next);
            cnt[next]++;
          }
        }
      }
    }

    for (int i = 1; i <= n; i++) {
      max = Math.max(max, cnt[i]);
    }

    for (int i = 1; i <= n; i++) {
      if (cnt[i] == max) {
        bw.write(i + " ");
      }
    }
    br.close();
    bw.close();
  }
}
