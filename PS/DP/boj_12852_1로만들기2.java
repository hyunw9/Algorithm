package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_12852_1로만들기2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    int[] num = new int[n + 1];
    int[] trace = new int[n + 1];

    num[1] = 0;

    for (int i = 2; i <= n; i++) {
      num[i] = num[i - 1] + 1;
      trace[i] = i - 1;

      if (i % 3 == 0 && num[i / 3] + 1 < num[i]) {
        num[i] = num[i / 3] + 1;
        trace[i] = i / 3;
      }
      if (i % 2 == 0 && num[i / 2] + 1 < num[i]) {
        num[i] = num[i / 2] + 1;
        trace[i] = i / 2;
      }
    }
    bw.write(num[n] + "\n");

    while (n > 0) {
      bw.write(n + " ");
      n = trace[n];
    }
    close();
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
