package PS.AlgorithmClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 중복순열 {

  private static int[] arr;
  private static int[] answer;
  private static boolean[] used;
  private static int n;
  private static int k;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    sb = new StringBuilder();
    arr = new int[n];
    answer = new int[k];
    used = new boolean[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    dfs(0);

  }

  public static void dfs(int depth) {
    if (depth == k) {
      for (int i = 0; i < k; i++) {
        System.out.print(answer[i]);
      }
      System.out.println();

      return;
    }
    for (int i = 0; i < n; i++) {
      answer[depth] = arr[i];
      dfs(depth + 1);


    }
  }
}
