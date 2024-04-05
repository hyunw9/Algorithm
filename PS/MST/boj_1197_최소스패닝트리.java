package PS.MST;

import java.io.*;
import java.util.*;

public class boj_1197_최소스패닝트리 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int v = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    arr = new int[v + 1];
    for (int i = 0; i <= v; i++) {
      arr[i] = i;
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    for (int i = 0; i < e; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      pq.add(new int[] {a, b, c});
    }

    int c = 0;
    while (!pq.isEmpty()) {

      int[] now = pq.poll();
      int na = now[0];
      int nb = now[1];
      int nowcost = now[2];
      if (find(na) != find(nb)) {
        union(na, nb);
        c += nowcost;
      }
    }

    // System.out.println(Arrays.toString(arr));
    bw.write(c + "");
    close();
  }

  private static int find(int x) {
    if (arr[x] == x) {
      return x;
    }
    return arr[x] = find(arr[x]);
  }

  private static void union(int a, int b) {
    int pa = find(a);
    int pb = find(b);

    if (pa != pb) {
      if (pa < pb) {
        arr[pb] = pa;
      } else {
        arr[pa] = pb;
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
