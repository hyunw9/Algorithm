package PS.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_13305_주유소 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int answer;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    long[] prices = new long[n];
    long[] roads = new long[n - 1];

    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n - 1; i++) {
      roads[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      prices[i] = Integer.parseInt(st.nextToken());
    }

    long sum = 0;
    long min = prices[0];
    for (int i = 0; i < n - 1; i++) {
      if (prices[i] < min) {
        min = prices[i];
      }
      sum += min * roads[i];
    }
    bw.write(sum + "");
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
