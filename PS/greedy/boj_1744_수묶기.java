package PS.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1744_수묶기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int max;
  private static int n;
  private static boolean[] used;

  public static void main(String[] args) throws IOException {
    init();
    n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    used = new boolean[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    dfs(arr, 0, 0);
    if(arr.length== 1){
      max = arr[0];
    }
    bw.write(max + "");

    close();
  }

  public static void dfs(int[] arr, int depth, int num) {
    if (depth == n) {
      max = Math.max(max, num);
      //System.out.println(num);
      return;
    } else if (depth > n) {
      return;
    }

    for (int i = depth; i < n; i++) {
      if (i + 1 < n) {
        if(arr[i]*arr[i+1]>arr[i]+arr[i+1]&&!used[i]&&used[i+1]) {
          used[i] = true;
          used[i+1] = true;
          dfs(arr, i + 2, num + arr[i] * arr[i + 1]);
          used[i] = false;
          used[i] = false;
        }else{
          used[i]=  true;
          dfs(arr, i + 2, num + arr[i] + arr[i + 1]);
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
    bw.close();
  }

}
