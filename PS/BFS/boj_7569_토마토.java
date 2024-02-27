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

public class boj_7569_토마토 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] dx = {0,0,-1,1};
  private static int[] dy = {-1,1,0,0};
  private static int[] dz = {1,-1};
  public static void main(String[] args) throws IOException {
    init();
    int days = 0;
    StringTokenizer st= new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken()) ;
    int n = Integer.parseInt(st.nextToken()) ;
    int h = Integer.parseInt(st.nextToken()) ;
    int[][][]arr = new int[h][n][m];
    Queue<int[]> q = new LinkedList<>();
    boolean[][][] used= new boolean[h][n][m];
    for(int i = 0 ; i < h;i++){

      for(int j = 0 ; j < n; j ++){
        st =new StringTokenizer(br.readLine());
        for(int k =0; k <m ; k++){
          arr[i][j][k] = Integer.parseInt(st.nextToken());
          if(arr[i][j][k] == 1) {
            used[i][j][k] = true;
            q.add(new int[]{i,j,k,0});
          }
        }
      }
    }
    while(!q.isEmpty()){
      int[] now = q.poll();
      days= Math.max(now[3],0);
      int z = now[0];
      int y = now[1];
      int x = now[2];

      for(int i = 0 ; i < 4; i++){
        int ny = dy[i] + y;
        int nx = dx[i] + x;
        if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
        if(used[z][ny][nx] || arr[z][ny][nx]==-1) continue;

        used[z][ny][nx] = true;
        arr[z][ny][nx]= 1;
        q.add(new int[]{z,ny,nx,now[3]+1});
      }
      for(int i = 0 ; i < 2; i++){
        int nz = dz[i]+ z;
        if(nz<0 || nz>= h) continue;
        if(used[nz][y][x]||arr[nz][y][x]==-1) continue;

        used[nz][y][x] = true;
        arr[nz][y][x] = 1;
        q.add(new int[]{nz,y,x,now[3]+1});
      }
    }

//    System.out.println(Arrays.deepToString(arr));
    boolean isRaw = false;
    for(int i = 0 ; i < h ; i ++){
      for(int j = 0 ; j < n;j++){
        for(int k = 0 ; k<m;k++){
          if(arr[i][j][k]==0){
            days=-1;
            isRaw = true;
            break;
          }
        }
        if(isRaw) break;
      }
      if(isRaw) break;
    }
    bw.write(days+"");
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
