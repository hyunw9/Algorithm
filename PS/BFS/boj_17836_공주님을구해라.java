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

public class boj_17836_공주님을구해라 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    int ans = 0;
    int[][] map = new int[n][m];
    Queue<int[]> q = new LinkedList<>();

    boolean[][][] used = new boolean[2][n][m];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());

      }
    }

      used[0][0][0] = true;

      q.add(new int[]{0,0,0,0});

    while(!q.isEmpty()){
      int[] now = q.poll();
      int y = now[0];
      int x = now[1];
      int status = now[2];
      int cost = now[3];
      if(cost>t){
        ans = Integer.MAX_VALUE;
        break;
      }
      if(y==n-1&&x==m-1){
        ans = cost;
        break;
      }
      for(int i= 0 ; i <4; i++){
        int ny= dy[i]+ y;
        int nx = dx[i]+x;

        if(ny<0||nx<0||ny>=n||nx>=m) continue;
        if(status == 0 ){
          if(map[ny][nx]==0 && !used[status][ny][nx]){
            used[status][ny][nx] = true;
            q.add(new int[]{ny,nx,status,cost+1});
          }else if(map[ny][nx]==2 && !used[status][ny][nx]){
            used[status][ny][nx] = true;
            q.add(new int[]{ny,nx,status +1, cost+1});
          }
        }else if(status == 1){
          if(!used[status][ny][nx]){
            used[status][ny][nx] = true;
            q.add(new int[]{ny,nx,status,cost+1});
          }
        }
    }
    }
    if(ans>t||ans==0){
      bw.write("Fail");
    }else{
      bw.write(ans+"");
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
