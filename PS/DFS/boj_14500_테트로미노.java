package PS.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14500_테트로미노 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int [] dx = {-1,1,0,0};
  private static int [] dy = {0,0,-1,1};
  private static int n ;
  private static int m ;

  private static int [][] map;
  private static boolean[][] used;
  private static int max;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st= new StringTokenizer(br.readLine());
     n = Integer.parseInt(st.nextToken());
     m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    used = new boolean[n][m];
    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j =0;j<m;j++){
        map[i][j]= Integer.parseInt(st.nextToken());
      }
    }
    for(int i = 0; i <n;i++){
      for(int j = 0 ; j<m;j++){
        used[i][j] = true;
        dfs(i,j,1,map[i][j]);
        used[i][j] = false;
      }
    }
    //System.out.println(Arrays.deepToString(map));
    bw.write(max+"");
    close();
  }
  public static void dfs(int y, int x ,int depth, int curr){
    if(depth == 4){
      //System.out.println(curr);
      max = Math.max(max,curr);
      return;
    }
    for(int i = 0;i<4;i++){
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx<0 || ny < 0 || nx>=m || ny>=n) continue;
      if(!used[ny][nx]) {
        used[ny][nx] = true;

        if (depth == 2) {

          dfs(y, x, depth + 1, curr + map[ny][nx]);

          //dfs(ny,nx,depth+1,curr+map[ny][nx]);

        }
        dfs(ny, nx, depth + 1, curr + map[ny][nx]);
        used[ny][nx] = false;

      }
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
