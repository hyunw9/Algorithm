package PS.DFS;

import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1925_그림 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static boolean[][] map ;
  private static boolean[][] used;
  private static int cnt;
  private static int width;
  private static int count;
  private static int[] dx = {0,0,-1,1};
  private static int[] dy = {-1,1,0,0};
  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    init();

    StringTokenizer st= new StringTokenizer(br.readLine());
     n = Integer.parseInt(st.nextToken());
     m = Integer.parseInt(st.nextToken());
    map = new boolean[n][m];
    used = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        if(st.nextToken().equals("1")){
          map[i][j] = true;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(map[i][j]){
          count++;
          dfs(i,j);
          cnt++;
          width = Math.max(width,count);
          count =0 ;
        }
      }
    }
    bw.write(cnt+"\n");
    bw.write(width+"");
    close();
  }

  public static void dfs(int y, int x){
    map[y][x] = false;

    for (int i = 0; i < 4; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(ny>n-1||nx>m-1||ny<0||nx<0) continue;
      if(!map[ny][nx]) continue;
      count++;
      dfs(ny,nx);
    }
  }


  public static void init(){
   br = new BufferedReader(new InputStreamReader(in));
   bw = new BufferedWriter(new OutputStreamWriter(out));
  }

  public static void close() throws IOException {
      br.close();
      bw.close();
    }

}
