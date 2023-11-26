package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10819_차이를최대로 {

  private static BufferedWriter bw;
  private static BufferedReader br;
  private static int[] arr;
  private static int max;
  private static int n;
  private static boolean[] used;
  private static int[] selected;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    arr = new int[n];
    used = new boolean[n];
    selected = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    dfs(0);
    bw.write(max + "");
    close();
  }

  public static void dfs(int depth) {
    if (depth == n) {
      max= Math.max(max,getSum());
      return;
    }
    for (int i = 0; i < n; i++) {
      if (!used[i]) {
        used[i] = true;
        selected[depth]= arr[i];
        dfs(depth+1);
        used[i] = false;
      }
    }
  }

  public static int getSum(){
    int sum =0;
    for (int i = 0; i < selected.length-1; i++) {
      sum+=Math.abs(selected[i]-selected[i+1]);
    }
    return sum;
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
