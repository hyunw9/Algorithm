package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15665_N과M11 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int[] arr;
  private static boolean[] used;
  private static int[] answer;
  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException{
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    arr = new int[n];
    used = new boolean[n];
    answer = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    dfs(0);
    close();
  }
  public static void dfs(int depth) throws IOException {
    if(depth == m){
      for (int i = 0; i < m; i++) {
        bw.write(answer[i]+" ");
      }
      bw.write("\n");
      return;
    }
    int before = -1;

    for (int i = 0; i < n; i++) {
        if(before != arr[i]){
          used[i] = true;
          answer[depth] = arr[i];
          before = arr[i];
          dfs(depth + 1);
          used[i] = false;
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
