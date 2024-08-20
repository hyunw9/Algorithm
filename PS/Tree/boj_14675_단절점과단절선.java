package PS.Tree;

import java.io.*;
import java.util.*;

public class boj_14675_단절점과단절선 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    ArrayList<int[]> tree = new ArrayList<>();
    int[] degree = new int[n + 1];
    for (int i = 0; i < n - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      tree.add(new int[] {start, end});
      degree[end] += 1;
      degree[start] += 1;
    }
    int q = Integer.parseInt(br.readLine());
    for (int i = 0; i < q; i++) {
      st = new StringTokenizer(br.readLine());
      int cmd = Integer.parseInt(st.nextToken());
      int query = Integer.parseInt(st.nextToken());

      if (cmd == 1) {
        if (degree[query] >= 2) {
          System.out.println("yes");
        } else {
          System.out.println("no");
        }
      } else {
        System.out.println("yes");
      }
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
