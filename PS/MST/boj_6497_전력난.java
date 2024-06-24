package PS.MST;

import java.io.*;
import java.util.*;

public class boj_6497_전력난 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr;
  private static int sum;

  public static void main(String[] args) throws IOException {
    init();
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int m = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      if (m == 0 && n == 0) break;
      arr = new int[m];
      for (int i = 0; i < m; i++) {
        arr[i] = i;
      }

      ArrayList<int[]> pq = new ArrayList<>();
      int tot = 0;
      for (int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        tot += c;
        pq.add(new int[] {f, t, c});
      }
      Collections.sort(pq, (o1, o2) -> o1[2] - o2[2]);
      for (int[] curr : pq) {

        int a = curr[0];
        int b = curr[1];
        int cost = curr[2];
        sum =0;
        if (find(a) != find(b)) {
          union(a, b);
          sum += cost;
        }
      }
      System.out.println(tot - sum);
    }

    close();
  }

  public static int find(int x) {
    if (arr[x] == x) return x;
    return arr[x] = find(arr[x]);
  }

  public static void union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b) {
      if (a < b) {
        arr[b] = a;
      } else {
        arr[a] = b;
      }
    }
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
