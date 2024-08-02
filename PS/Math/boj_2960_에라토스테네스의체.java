package PS.Math;

import java.io.*;
import java.util.*;

public class boj_2960_에라토스테네스의체 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    boolean[] arr = new boolean[n + 1];
    Arrays.fill(arr, true);
    arr[0] = true;
    arr[1] = true;

    int cnt = 0;
    int answer = 0;
    for (int i = 2; i <= n; i++) {

      if (arr[i] == true) {
        for (int j = i; j <= n; j = j + i) {
          if (arr[j] == true) {
            cnt += 1;
            //   System.out.println(j);
            arr[j] = false;
            if (cnt == m) {
              answer = j;
            }
          }
        }
      }
    }

    System.out.println(answer);
    close();
  }

  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}
