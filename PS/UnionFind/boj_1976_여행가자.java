package PS.UnionFind;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import java.util.StringTokenizer;

public class boj_1976_여행가자 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr;
  private static int cnt = 1;
  private static int num = 0;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int[] route = new int[m+1];
    arr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = i;
    }
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        int now = Integer.parseInt(st.nextToken());
        if (now == 1) {
          union(i, j);
        }
      }
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= m; i++) {
      route[i] = Integer.parseInt(st.nextToken());
    }

    boolean flag = false;
    for (int i =1; i < route.length-1; i++) {
      int now = find(route[i]);
      int next = find(route[i+1]);
      if (now != next) {

        flag = true;
        break;
      }
    }

    if (flag) {
      bw.write("NO");
    } else {
      bw.write("YES");
    }
    close();
  }

  public static int find(int x) {
    if (arr[x] == x) {
      return x;
    }
    return arr[x] = find(arr[x]);
  }

  public static void union(int l, int r) {
    arr[find(l)] = find(r);
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }
  /*
5
5
0 1 0 0 0
1 0 0 0 1
0 0 0 1 0
0 0 1 0 1
0 1 0 1 0
3 5 4 2 1
YES*/

}
