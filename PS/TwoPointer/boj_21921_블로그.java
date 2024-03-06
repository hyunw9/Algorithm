package PS.TwoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_21921_블로그 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());

    int[] arr = new int[n];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int l = 0;
    int r = 0;
    int sum = 0;
    int max = 0;
    int cnt = 0;

    while (l <= r && r < n) {
      int winsize = r - l;

      if (winsize < x) {
        if (r < n) {
          sum += arr[r++];
        }
      } else if (winsize > x) {
        sum -= arr[l++];
      } else {
        sum -= arr[l++];

        if (r < n) {
          sum += arr[r];
        }
        r++;

      }
      if (sum > max) {
        max = sum;
        cnt = 1;
      } else if (sum == max) {
        cnt += 1;
      }
    }
    if (max == 0) {
      bw.write("SAD");
    } else {
      bw.write(max + "\n");
      bw.write(cnt + "");
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
