package PS.graph;

import java.io.*;
import java.util.*;

public class boj_2252_줄세우기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    //1. 인접리스트 생성
    ArrayList<Integer>[] arr = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = new ArrayList<>();
    }
    //rank 용 배열
    int[] rank = new int[n + 1];
    boolean[] used = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      rank[i] = 0;
    }
    //값과 랭크 추가
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int front = Integer.parseInt(st.nextToken());
      int back = Integer.parseInt(st.nextToken());
      rank[back]++;
      arr[front].add(back);
    }
    for (int i = 1; i <= n; i++) {
      if (rank[i] == 0) {
        dq.addLast(i);
        used[i] = true;
      }
    }
    while (!dq.isEmpty()) {
      int now = dq.pollFirst();

      bw.write(now + " ");

      for (int v : arr[now]) {
        if (!used[v]) {
          rank[v]--;
          if (rank[v] == 0) {
            used[v] = true;
            dq.addLast(v);
          }
        }
      }
    }
    for (int v : dq) {
      bw.write(v + " ");
    }
    close();
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
