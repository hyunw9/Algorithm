package PS.Tree;

import java.util.*;
import java.io.*;

public class boj_1068_트리 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int cnt;
  private static boolean[] used;
  private static ArrayList<Integer>[] adj;


  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    adj = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }
    used = new boolean[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int root = -1;
    for (int i = 0; i < n; i++) {
      int curr = Integer.parseInt(st.nextToken());
      if (curr == -1) {
        root = i;
      } else {
        adj[i].add(curr);
        adj[curr].add(i);
      }
    }
    int d = Integer.parseInt(br.readLine());
    if (d == root) {
      System.out.println(0);
      return;
    } else {
      dfs(root, d);
      bw.write(cnt + "");
    }
//    System.out.println("root: "+ root);
//    System.out.println(Arrays.deepToString(adj));
    close();
  }

  public static void dfs(int curr, int delete) {
    used[curr] = true;
    int node = 0;
    for (int c : adj[curr]) {
      if (c != delete && !used[c]) {
        node += 1;
        dfs(c, delete);
      }
    }
    if (node == 0) {
      cnt += 1;
    }
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
