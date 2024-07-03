package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_2096_내려가기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    int[] min = new int[3];
    int[] max = new int[3];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());

      if (i == 0) {
        min[0] = max[0] = x;
        min[1] = max[1] = y;
        min[2] = max[2] = z;
      } else {
        int beforeDpx = min[0];
        int beforeDpz = min[2];
        min[0] = Math.min(min[0], min[1]) + x;
        min[2] = Math.min(min[1], min[2]) + z;
        min[1] = Math.min(beforeDpz, Math.min(beforeDpx, min[1])) + y;

        beforeDpx = max[0];
        beforeDpz = max[2];
        max[0] = Math.max(max[0], max[1]) + x;
        max[2] = Math.max(max[2], max[1]) + z;
        max[1] = Math.max(beforeDpz, Math.max(beforeDpx, max[1])) + y;
      }
    }
    bw.write(
        Math.max(max[0], Math.max(max[1], max[2]))
            + " "
            + Math.min(min[0], Math.min(min[1], min[2])));
    System.out.println(Arrays.toString(max));
    System.out.println(Arrays.toString(min));
    close();
    // System.out.println(Arrays.deepToString(maxDp));
    // System.out.println(Arrays.deepToString(min
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
