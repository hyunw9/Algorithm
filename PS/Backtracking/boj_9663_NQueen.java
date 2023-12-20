package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_9663_NQueen {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static boolean[] vertical;
  private static boolean[] horizental;
  private static boolean[] right;
  private static boolean[] left;

  private static int n;
  private static int answer;

  public static void main(String[] args) throws IOException {
    init();
    n = Integer.parseInt(br.readLine());
    vertical = new boolean[n];
    horizental = new boolean[n];
    right = new boolean[n * 2 - 1];
    left = new boolean[n * 2 - 1];
    dfs(0);
    bw.write(answer + "");
    bw.close();
  }

  public static void dfs(int cnt) throws IOException {

    if (cnt == n) {
      answer += 1;
      return;
    }

    for (int i = 0; i < n; i++) {
      if (vertical[i] || left[cnt + i] || right[cnt+ (n - i - 1)]) {
        continue;
      }
      vertical[i] = true;
      left[cnt + i] = true;
      right[cnt + (n - i - 1)] = true;

      dfs(cnt + 1);
      vertical[i] = false;
      left[cnt + i] = false;
      right[cnt + (n - i - 1)] = false;

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
