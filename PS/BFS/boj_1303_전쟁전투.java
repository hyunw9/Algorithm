package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class boj_1303_전쟁전투 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[][] map ;
  private static boolean[][] used;
  private static int n;
  private static int m;
  private static int [] dx = {0,0,-1,1};
  private static int[] dy = {-1,1,0,0};
  private static int b;
  private static int w;
  private static Queue<int[]> q;
  public static void main(String[] args) throws IOException {
    init();
    String line = br.readLine();
    m = Integer.parseInt(line.split(" ")[0]);
    n = Integer.parseInt(line.split(" ")[1]);

    map = new int[n][m];
    used= new boolean[n][m];
    q=new LinkedList<>();
    for(int i = 0; i < n; i++){
      line = br.readLine();
      for(int j = 0; j<m ;j++){
        char now = line.charAt(j);
        if(now == 'B'){
          map[i][j]=0;
        }else{
          map[i][j]=1;
        }
      }
    }
    for(int i =0 ; i <n; i++){
      for(int j =0; j <m;j++){
        if(!used[i][j]){
          used[i][j] = true;
          q.add(new int[]{i,j,map[i][j]});
          int res = bfs();
          if(res == 1){
            if(map[i][j]==1){
              w +=1;
            }else{
              b+=1;
            }
          }else{
            if(map[i][j]==1){
              w += res*res;
            }else{
              b+= res*res;
            }
          }
        }
      }
    }
    bw.write(w+" "+b);
    close();
  }

  public static int bfs(){
    int sum =1;
    while(!q.isEmpty()){

      int[] now = q.poll();
      int y= now[0];
      int x = now[1];
      int team = now[2];
      for(int i = 0 ; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];

        if(nx<0 || ny<0 || nx>= m ||ny>=n) continue;
        if(used[ny][nx]||map[ny][nx]!=team) continue;
        used[ny][nx] = true;
        sum+=1;
        q.add(new int[]{ny,nx,team});
      }

    }
    return sum;
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
