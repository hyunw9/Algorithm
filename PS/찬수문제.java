package PS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 찬수문제 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int target ;
  private static int x;
  private static int n;
  private static int m;
  private static int[][] map;
  private static boolean[][] used;
  private static int[] dx = {-1,1,0,0};
  private static int[] dy = {0,0,-1,1};
  private static Queue<Node> q;
  private static int durr = 0;

  private static class Node{
    int y;
    int x;
    public Node(int y , int x){
      this.y = y;
      this.x = x;
    }
  }

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
     n = Integer.parseInt(st.nextToken());
     m = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    int a = 0;
    int cnt =0;

    map = new int[n][m];
    used = new boolean[n][m];
    for(int i =  0 ; i < n; i++ ){
      st =new StringTokenizer(br.readLine());
      for(int j = 0 ; j < m ;j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        a+=map[i][j];
        cnt++;
      }
    }
    target = a/cnt ;

    System.out.println("a: "+a);
    System.out.println("cnt: "+cnt);
    System.out.println(a / cnt);
    used[0][0] = true;
    q = new LinkedList<>();
    q.add(new Node(0,0));
    /*6 8
    1 2 3 4 5 6 3 8
    1 2 3 4 5 6 3 8
    1 2 3 4 5 6 3 8
    1 2 3 4 5 6 3 8
    1 2 3 4 5 6 3 8
    1 2 3 4 5 6 3 8*/
    bfs();
    bw.write(durr+" "+ target);

    close();
  }

  public static void bfs(){
    //1 파는데는 3분 , 1 메꾸는데 2분
    //손으로 1 파는덴 7분, 메꾸는데 5분
    while(!q.isEmpty()) {
      Node now = q.poll();

      if (map[now.y][now.x] > target) { //땅이 타겟보다 높다면 파야됨
        if (x > 0) {
          while (map[now.y][now.x] >= target && x >= 0) {
            durr += 3;
            map[now.y][now.x] -= 1;
            x--;
          }
        } else {
          while (map[now.y][now.x] >= target) {
            durr += 7;
            map[now.y][now.x] -= 1;
          }
        }
      } else if (map[now.y][now.x] < target) { //낮다면 메꿔야 함
        if (x > 0) {
          while (map[now.y][now.x] <= target && x >= 0) {
            durr += 2;
            map[now.y][now.x] += 1;
            x--;
          }
        } else {
          while (map[now.y][now.x] <= target) {
            durr += 5;
            map[now.y][now.x] += 1;
          }
        }
        for (int i = 0; i < 4; i++) {
          int ny = now.y + dy[i];
          int nx = now.x + dx[i];

          if (ny < 0 || nx < 0 || ny >= n || nx >= m)
            continue;
          if (used[ny][nx])
            continue;

          used[ny][nx] = true;
          q.add(new Node(ny, nx));
        }
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
