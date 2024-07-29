package PS.TopologicalSort;

import java.io.*;
import java.util.*;

public class boj_14567_선수과목 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    ArrayList<Integer>[] arr = new ArrayList[n + 1];
    Queue<Integer> q = new LinkedList<>();

    for (int i = 0; i <= n; i++) {
      arr[i] = new ArrayList<>();
    }
    int[] degree = new int[n + 1];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      degree[b] += 1;
      arr[a].add(b);
    }

    int[] answer = new int[n + 1];
    int cnt = 1;

    for (int i = 1; i <= n; i++) {
      if (degree[i] == 0) {
        answer[i] = cnt;
        q.offer(i);
      }
      cnt += 1;
    }

    int semester = 1;
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        int curr = q.poll();
        answer[curr] = semester;
        for (int next : arr[curr]) {
          degree[next]--;
          if (degree[next] == 0) {
            q.offer(next);
          }
        }
      }
      semester++;
    }
    for (int i = 1; i <= n; i++) {
      bw.write(answer[i] + " ");
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
