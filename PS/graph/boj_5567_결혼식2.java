package PS.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_5567_결혼식2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] friend;
  private static boolean[] used;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    ArrayList<Integer>[] list = new ArrayList[n + 1];
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }
    friend = new int[n + 1];
    used = new boolean[n + 1];

    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      list[start].add(end);
      list[end].add(start);
    }
    used[1] = true;
    friend[1] = 0;
    q.add(1);
    while (!q.isEmpty()) {
      int now = q.poll();

      for (int next : list[now]) {
        if (!used[next]) {
          used[next] = true;
          friend[next] = friend[now] + 1;
          q.add(next);
        }
      }
    }
    int answer = 0;
    for (int i = 2; i < friend.length; i++) {
      if (friend[i] >= 1 && friend[i] <= 2) {
        answer++;
      }
    }
    bw.write(answer + "");
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
