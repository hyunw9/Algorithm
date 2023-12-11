package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_16922_로마숫자만들기 {


  private static BufferedReader br;
  private static BufferedWriter bw;

  private static boolean[] nums;
  private static int[] roman = {1, 5, 10, 50};
  private static int n;
  private static int cnt;

  public static void main(String[] args) throws IOException {
    init();
    n = Integer.parseInt(br.readLine());
    nums = new boolean[66 * n];
    dfs(0, 0,0);
    bw.write(cnt + "");

    close();
  }

  private static void dfs(int depth, int num,int idx) {
    if (depth == n) {
      if(!nums[num]) {
        nums[num] = true;
        cnt++;
      }
      return;
    }
    for (int i = idx; i < roman.length; i++) {
        dfs(depth + 1, num + roman[i],i);
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
