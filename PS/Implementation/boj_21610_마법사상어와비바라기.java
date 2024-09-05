package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_21610_마법사상어와비바라기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int n;
  private static int m;
  private static int[][] map;
  private static Queue<int[]> q;
  private static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
  private static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
  private static boolean[][] wasCloud;
  private static Queue<int[]> movedq;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    q = new LinkedList<>();

    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      for (int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    first();
    for (int i = 0; i < m; i++) {

      wasCloud = new boolean[n][n];
      movedq = new LinkedList<>();
      st = new StringTokenizer(br.readLine());
      int dir = Integer.parseInt(st.nextToken());
      int step = Integer.parseInt(st.nextToken());
      move(dir, step);
      giveThemRain();
      checkAndIncrease();
      makeCloud();
    //   printbool();
    //   print();
    //   System.out.println("-------------------------");
    }

    int answer = getSum();
    System.out.println(answer);
    close();
  }
  private static void printbool(){
    for(int i = 0; i < n; i++){
        System.out.println(Arrays.toString(wasCloud[i]));
    }
  }

  private static void print() {
    for (int i = 0; i < n; i++) {
      System.out.println(Arrays.toString(map[i]));
    }
  }

  private static int getSum() {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sum += map[i][j];
      }
    }
    return sum;
  }

  private static void move(int dir, int step) {
    while (!q.isEmpty()) {
      //   giveThemRain();
      int[] loc = q.poll();

      int curry = loc[0];
      int currx = loc[1];
        
      int newy = (curry + ((dy[dir] * step)%n + n)) % n;
      int newx = (currx + ((dx[dir] * step)%n + n)) % n;
    //   System.out.println(dir+" step: "+ step);
    //   System.out.println(curry+ " currx: "+ currx);
    //     System.out.println(newy + " newx : "+ newx);
      wasCloud[newy][newx] = true;

      movedq.offer(new int[] {newy, newx});
      //   print();
    }
  }

  private static void giveThemRain() {
    for (int[] a : movedq) {
      map[a[0]][a[1]] += 1;
    }
  }

  private static void checkAndIncrease() {
    while (!movedq.isEmpty()) {
        int[] curr =movedq.poll();
        int y = curr[0];
        int x = curr[1];

      int[] cx = {-1, 1, -1, 1};
      int[] cy = {-1, -1, 1, 1};

      int cnt = 0;
      for (int i = 0; i < 4; i++) {
        int ny = cy[i] + y;
        int nx = cx[i] + x;
        if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
        if (map[ny][nx] <= 0) continue;
        cnt += 1;
      }
    //   System.out.println("y : " + y + " x : " + x + " : cnt: " + cnt);
      map[y][x]+=cnt;
    }
  }

  private static void makeCloud() {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!wasCloud[i][j]) {
          if (map[i][j] >= 2) {
            // System.out.println("make cloud at || y :"+ i+ " x : "+ j);
            q.offer(new int[] {i, j});
            map[i][j] -= 2;
            // System.out.println("so, curr val : "+ map[i][j]);
          }
        }
      }
    }
  }

  private static void first() {
    q.offer(new int[] {n - 1, 0});
    q.offer(new int[] {n - 1, 1});
    q.offer(new int[] {n - 2, 0});
    q.offer(new int[] {n - 2, 1});
  }

  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}

/*
** 간략한 풀이 :
    구현 자체는 어렵지 않은 편, 근데 2번 움직임부터 오류가 발생했다. 
    방향설정에 관한 부분을 조금 익힐 필요가 있겠다. 
*/
