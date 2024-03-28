package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_14503_로봇청소기2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int NORTH = 0;
  private static int EAST = 1;
  private static int SOUTH = 2;
  private static int WEST = 3;
  private static int[] dx= {0,1,0,-1};
  private static int[] dy= {-1,0,1,0};
  private static int cleaned = 0;
  private static int[][] arr;
  private static int n;
  private static int m;


  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    Queue<int[]> q = new LinkedList<>();

    int starty = Integer.parseInt(st.nextToken());
    int startx = Integer.parseInt(st.nextToken());
    int startdir = Integer.parseInt(st.nextToken());
    arr = new int[n][m] ;
    for(int i = 0 ; i < n ; i ++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0 ;  j < m ; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    q.add(new int[]{starty,startx,startdir});

    while(!q.isEmpty()){

      int[] now = q.poll();
      int y = now[0];
      int x = now[1];
      int dir = now[2];
//      System.out.println("y : "+ y + " x: " + x+ " dir : "+ dir);
      if(arr[y][x]==0){
        arr[y][x] = 2;
        cleaned +=1;
      }
      if(needClean(y,x)){
        //안된 곳 있으므로 반시계방향 회전 필요

        for(int i= 0 ; i < 4; i++){
          dir -= 1 ;
          if(dir == -1){
            dir =3;
          }
          int ny = y + dy[dir];
          int nx = x + dx[dir];
          if(arr[ny][nx]==0){
            arr[ny][nx] = 2;
            cleaned +=1;
            q.add(new int[]{ny,nx,dir});
            break;
          }
        }
      }else{
        //청소 다 되어있으면 뒤로
        //근데 벽이면 종료
        //벽 아니면 뒤로 돌아감
        int by = y + (-1 * dy[dir]);
        int bx = x + (-1 * dx[dir]);
        if(arr[by][bx]!=1){
          q.add(new int[]{by,bx,dir});
          continue;
        }else{
          break;
        }
      }
    }
    //현재칸 미청소 -> 청소
    // 현재칸 청소됨 -> 암것도 안함
    // -> 주변 네칸 중 청소 안된 곳이 있으면 반시계방향 회전
        //-> 앞이 빈칸이면 전진
    //-> 주변 네칸이 다 청소되었으면,
    System.out.println(cleaned);
//    System.out.println(Arrays.deepToString(arr));
    close();
  }

  public static boolean needClean(int y,int x){
    if ( arr[y+1][x] == 0) {
      return true;
    }
    if( arr[y-1][x] ==0){
      return true;
    }
    if( arr[y][x+1]==0){
      return true;
    }
    if(arr[y][x-1]==0){
      return true;
    }
    return false;
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
