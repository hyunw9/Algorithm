package PS.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_23562_ㄷ만들기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[][] map = new int[n][m];
    st = new StringTokenizer(br.readLine());
    int wb = Integer.parseInt(st.nextToken());
    int btow = Integer.parseInt(st.nextToken());
    int cost = 0;
    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        if (line.charAt(j) == '#') {
          map[i][j] = 1;
        } else {
          map[i][j] = 0;
        }
      }
    }
    int max = Math.min(m, n);
    for (int i = 1; i < max / 3; i++) {
      //정사각형 크기
      int x = 0;
      int y = 0;

      //맵 돌면서 흰색 부분을 전부 블랙으로 만들어줌 비용도 추가


      //진짜 필요한 부분의 비용을 계산해줌.


//      나머지 부분 다 흰색으로 제거



      //최솟값 계산
    }

    bw.write(cost + "");
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
