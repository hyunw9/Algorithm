package PS.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15683_감시 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] dir ={0,1,2,3};
  private static boolean[] used;
  private static int[][] map ;
  private static int n;
  private static int m;
  private static int cnt;
  private static int min;


  public static void main(String[] args) throws IOException {
    init();
    //5는 회전이 안되므로 미리 설정해주고,
//    백트래킹으로 모든 경우의 수에 대해서 체크하면서 min 갱신하면 되지 않나 ?
    StringTokenizer st = new StringTokenizer(br.readLine());
     n = Integer.parseInt(st.nextToken());
     m = Integer.parseInt(st.nextToken());
    map = new int[n][m];
    used= new boolean[n+1];
    for(int i =0; i <n; i++){
      st= new StringTokenizer(br.readLine());
      for(int j =0 ; j<m;j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j]==5){
         spread(i,j);
        }else if(map[i][j]>0 &&map[i][j]<5 ) {
          cnt++;
        }
      }
    }
    for(int i =0; i <n; i++){
      for(int j =0 ; j<m;j++){
        if(map[i][j]>0 && map[i][j]<5){
          dfs(i,j,0,cnt,map[i][j]);
        }
      }
    }
    System.out.println(Arrays.deepToString(map));
    close();
  }

  public static void dfs(int y,int x,int depth, int target,int curr){
    if(depth == target){
      check();
      return;
    }
    for(int i = 0 ; i<4; i++){

    }


  };



  public static void spread(int i,int j){
    //6,6 이면, 6[J = #]. i[6] =#
    int y = i;
    int x =j ;
    while(--x>=0){
      if(map[y][x]==6) break;
      else if(map[y][x]>0) continue;
      map[y][x] = -1;
    }
    x=j;
    while(++x<m){
      if(map[y][x]==6) break;
      else if(map[y][x]>0) continue;
      map[y][x] = -1;
    }
    x=j;
    while(--y>=0){
      if(map[y][x]==6) break;
      else if(map[y][x]>0) continue;

      map[y][x] = -1;
    }
    y=i;
    while(++y<n){
      if(map[y][x]==6) break;
      else if(map[y][x]>0) continue;

      map[y][x] = -1;
    }
  }
  public static void check(){};

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
