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

public class boj_16234_인구이동2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[][] map;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};
  private static Queue<int[]> q;
  private static Queue<int[]> pop;
  private static boolean[][] used;
  private static int n;
  private static int r;
  private static int l;
  private static int cnt;
  private static boolean isMoved;

  public static void main(String[] args) throws IOException {
    init();
    int ans = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    l = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    while (true) {
      isMoved = false;
      used = new boolean[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if(!used[i][j]) {
            used[i][j] = true;
            q = new LinkedList<>();
            pop=new LinkedList<>();
            cnt = 1;
            q.add(new int[]{i, j});
            pop.add(new int[]{i,j});
            int sum =bfs(map[i][j]);
            if(pop.size() > 1){
              move(map,used,sum,pop.size());
              isMoved = true;
            }
          }
        }
      }

      if(!isMoved) break;
      else ans+=1;
    }
    //bfs 돌면서 인근 이웃들 이동 가능한지 체크
    //그리고 체크했다면 인구수 추가
    //마지막에 체크한 인구수를 나눈 값으로 갱신
    bw.write(ans + "");
    close();
  }

  private static void move(int[][] map, boolean[][] used,int sum,int cnt) {

    int moved = sum / cnt;
    while(!pop.isEmpty()){
      int[] now = pop.poll();

      map[now[0]][now[1]] = moved;
    }


  }

  private static int bfs(int sum) {

    while (!q.isEmpty()) {
      int[] now = q.poll();
      int y = now[0];
      int x = now[1];
       sum = map[y][x];
      for (int i = 0; i < 4; i++) {

        int ny = dy[i] + y;
        int nx = dx[i] + x;

        if (nx < 0 || ny < 0 || ny >= n || nx >= n) {
          continue;
        }
//        if (used[ny][nx]) {
//          continue;
//        }
        if ( !used[ny][nx]&&Math.abs(map[y][x] - map[ny][nx]) >= l && Math.abs(map[y][x] - map[ny][nx]) <= r) {
          sum += map[ny][nx];
          used[ny][nx] = true;
          q.add(new int[]{ny, nx});
          pop.add(new int[]{ny,nx});
        }
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
