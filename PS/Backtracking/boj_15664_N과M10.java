package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import java.util.StringTokenizer;

public class boj_15664_N과M10 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static boolean[] used;
  private static int[] arr;
  private static int[] now;
  private static int n;
  private static int m;


  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n];
    now = new int[n];
    used = new boolean[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    dfs(0,0);

  }

  public static void dfs(int start, int cnt) throws IOException {

    if (cnt == m) {
      for (int i = 0; i < m; i++) {
        bw.write(now[i] + " ");
      }
      bw.write("\n");
      bw.flush();
      return;
    }
    int before = -1;

    for (int i = start; i < n; i++) {

      if (before != arr[i]) {
        if (!used[i]) {
          used[i] = true;
          now[cnt] = arr[i];
          before = arr[i];
          dfs(i,cnt + 1);
          used[i] = false;
        }
      }
    }
  }



  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }

}

