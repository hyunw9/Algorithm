package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16918_봄버맨 {


  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int r;
  private static int c;
  private static int n;
  private static char[][] map;
  private static int[][] bomb;
  private static int time;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};

  private static Queue<int[]> q;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    q = new LinkedList<>();
    map = new char[r][c];
    bomb = new int[r][c];
    for(int i =0; i<r; i++){
      String line = br.readLine();
      for(int j =0;j<c;j++){
        map[i][j]=line.charAt(j);
        if(map[i][j]=='O'){
          bomb[i][j] = 3;
          q.add(new int[]{i,j});
        }
      }
    }
    while(time++<n){

      if(time%2==0){
        fill(time);
      }else if(time%2==1){
        explode(time);
      }
    }


    for(int i=0;i<r;i++){
      for(int j = 0 ; j<c; j++) {
        bw.write(map[i][j]);
      }
      bw.write("\n");
    }
    close();
  }

  public static void fill(int t) {
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (map[i][j] == '.') {
          map[i][j] = 'O';
          bomb[i][j] = t+3;
          q.add(new int[]{i, j});
        }
      }
    }
  }

  public static void explode(int t) {
    for(int y = 0 ; y<r ; y++){
      for(int x = 0; x<c; x++){

      if (bomb[y][x]  == t) {
        if (map[y][x] == 'O') {
          map[y][x] = '.';
        }

        for (int i = 0; i < 4; i++) {
          int ny = dy[i] + y;
          int nx = dx[i] + x;

          if (ny < 0 || nx < 0 || ny >= r || nx >= c) {
            continue;
          }
          if (map[ny][nx] == '.') {
            continue;
          }
          if(map[ny][nx]=='O'&&bomb[ny][nx]!=time){
            bomb[ny][nx]=0;
            map[ny][nx] = '.';
          }
        }
      }}
    }
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
