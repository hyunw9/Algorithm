package prgmrs.DP;

import java.io.*;
import java.util.Arrays;

public class boj_1463_1로만들기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());

    int[] arr = new int[n + 1];
    arr[0] = 0;
    arr[1] = 0;
    for (int i = 2; i <= n; i++) {
      int now = arr[i - 1];
      if( i% 6 ==0){
        arr[i] = Math.min(arr[i/3], arr[i/2])+1;
      }
      else if (i % 3 == 0) {
        if(i==3){
          arr[i] = 1;
          continue;
        }
        arr[i] = Math.min(arr[i / 3], now) + 1;
      } else if (i % 2 == 0) {
        if (i == 2) {
          arr[i] = 1;
          continue;
        }
        arr[i] = Math.min(arr[i / 2], now) + 1;
      } else {
        arr[i] = now + 1;
      }
    }
    bw.write(arr[n] + "");
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
