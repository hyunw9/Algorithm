package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class boj_14503_로봇청소기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] dx = {0,1,0,-1}; //북 동 남 서
  private static int[] dy = {-1,0,1,0};
  private static int ans = 1;
  private static boolean[][] used;
  private static int[][] map;
  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    st = new StringTokenizer(br.readLine());
    int ry = Integer.parseInt(st.nextToken());
    int rx = Integer.parseInt(st.nextToken());
    int rd = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(ry,rx,rd);
    bw.write(ans + "");
    close();
  }

  public static void dfs(int y,int x,int forward){
    map[y][x] = 2;
    int next = forward;
    for(int i = 0; i < 4; i++){
      next = (next+3) % 4;
      int nx = dx[next] + x;
      int ny = dy[next] + y;

      if(nx>=0&&ny>=0&&nx<m&&ny<n)  {
        if(map[ny][nx]==0){
          ans++;
          dfs(ny,nx,next);
          return;
       }
      }

    }
    int back = (forward + 2) % 4;
    int bx = x + dx[back];
    int by = y + dy[back];
    if(map[by][bx]!=1){
      dfs(by,bx,forward);
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
