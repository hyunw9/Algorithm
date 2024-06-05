package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_15724_주지수 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] map = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int[][] sum = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        
        sum[i][j] += sum[i - 1][j] + sum[i][j - 1] -sum[i-1][j-1]+ map[i][j];
      }
    }
    for(int i = 0 ; i <= n ; i ++){
        System.out.println(Arrays.toString(sum[i]));
    }
    st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());

    for (int i = 0; i < t; i++) {
      st = new StringTokenizer(br.readLine());
      int y1 = Integer.parseInt(st.nextToken());
      int x1 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      System.out.println(sum[y2][x2]-sum[y1-1][x2]-sum[y2][x1-1]+sum[y1-1][x1-1]);
    }
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
