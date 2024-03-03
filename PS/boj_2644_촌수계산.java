package PS;

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

public class boj_2644_촌수계산 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static ArrayList<Integer>[] map;
  private static int cnt;
  private static int[] visited;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    visited = new int[n + 1];
    map = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      map[i] = new ArrayList<>();
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int num = Integer.parseInt(st.nextToken());
    for (int i = 1; i <= num; i++) {
      st = new StringTokenizer(br.readLine());
      int np = Integer.parseInt(st.nextToken());
      int nc = Integer.parseInt(st.nextToken());
      map[np].add(nc);
      map[nc].add(np);
    }
    Queue<Integer> q = new LinkedList<>();
//    visited[p] ;
    q.add(p);

    while (!q.isEmpty()) {
      int now = q.poll();

      for (int a : map[now]) {

        if (visited[a] == 0) {
          visited[a] = visited[now] + 1;
          q.add(a);
        }
      }
    }

    if(visited[c]==0) bw.write("-1");
    else{
      bw.write(visited[c]+"");
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
