package PS.binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1654_랜선자르기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    long max = 0;

    int[] arr = new int[K];
    long l = 1;
    long h = 0;
    for (int i = 0; i < arr.length; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
      h = Math.max(h,arr[i]);
    }

    while (l <= h) {

      long mid = (l + h) / 2;
      long cnt = 0;

      for (int line : arr) {

        if (line >= mid) {
          cnt += line / mid;
        }
      }

      if (cnt  < N) {//필요보다 적으면 많이짜른거
        h = mid -1;

      } else if (cnt >= N) {
        l = mid +1;
        max = Math.max(max, mid);

      }

    }
    bw.write(max+"");
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
