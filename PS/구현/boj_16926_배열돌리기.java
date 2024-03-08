package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_16926_배열돌리기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    int[][] map = new int[n][m];
    for(int i = 0 ; i< n ; i++){
      st= new StringTokenizer(br.readLine());
      for(int j= 0 ; j < m ; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int [][] answer = new int[n][m];
    int len = Math.min(m,n)/2;
    while(--t>=0) {
      for(int j=0; j<len; j++) {
        int temp = map[j][j];

        for(int k=j+1; k<m-j; k++)
          map[j][k-1] = map[j][k];

        for(int k=j+1; k<n-j; k++)
          map[k-1][m-1-j] = map[k][m-1-j];

        for(int k=m-2-j; k>=j; k--)
          map[n-1-j][k+1] = map[n-1-j][k];

        for(int k=n-2-j; k>=j; k--)
          map[k+1][j] = map[k][j];

        map[j+1][j] = temp;
      }
    }
    for(int i = 0 ; i < n; i++){
      for(int j = 0 ; j < m ; j++){
        bw.write(map[i][j]+" ");
      }
      bw.write("\n");
    }
//    4 4 2
//    1 2 3 4
//    5 6 7 8
//    9 10 11 12
//    13 14 15 16

    //4칸이면 절반만큼 큐를 만들면됨 . 2개
    //0,0 , 1,1 , 2 2 가 시작점임.

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
