package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16234_인구이동 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[][] map;
  private static boolean[][] used;
  private static Queue<int[]> pop;
  private static Queue<int[]> q;
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static int n ;
  private static int r ;
  private static int l ;
  private static int ans;
  private static boolean isMoved;


  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
     n = Integer.parseInt(st.nextToken());
     l = Integer.parseInt(st.nextToken());
     r = Integer.parseInt(st.nextToken());
    map = new int[n][n];
    used = new boolean[n][n];
    q = new LinkedList<>();
    pop = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    //큐 두개 , 전체 반복
    //bfs 돌면서 차가 l이상 r미만이면 pop에 넣고, 다 돌면 평균 구하기
    //pop에서 poll하면서 값을 평균값으로 바꿔줌
    while(true) {
      isMoved = false;
      used = new boolean[n][n];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (!used[i][j]) {
            used[i][j] = true;
            q = new LinkedList<>();
            q.add(new int[]{i, j});
            pop = new LinkedList<>();
            pop.add(new int[]{i, j});
            int sum = bfs(map[i][j]);

            if(pop.size()>1){

              isMoved = true;
              int avg = getAvg(sum);
              move(avg);
            }
          }
        }
      }
      if(!isMoved){
        break;
      }
      ans++;
    }
    bw.write(ans+"");
    close();
  }

  public static void move(int avg){
    while (!pop.isEmpty()) {
      int [] now = pop.poll();
      map[now[0]][now[1]] = avg;
    }
  }

  public static int getAvg(int avg){
    return avg/pop.size();
  }

  public static int bfs(int avg){

    while(!q.isEmpty()){

      int[] now = q.poll();
      int x= now[1];
      int y= now[0];
      for(int i = 0;i<4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx<0||ny<0||nx>=n||ny>=n) continue;
        if(used[ny][nx]) continue;
        int diff = Math.abs(map[ny][nx]-map[y][x]);
        if(diff>= l  && diff<=r) {
          used[ny][nx] = true;
          q.add(new int[]{ny, nx});
          pop.add(new int[]{ny, nx});
          avg+=map[ny][nx];
        }
      }
    }
    return avg;
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
