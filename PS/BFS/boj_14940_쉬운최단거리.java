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

public class boj_14940_쉬운최단거리 {

  private static class Node{

    private int y;
    private int x;

    public Node(int y ,  int x){
      this.y = y;
      this.x= x;
    }
  }

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[][] map ;
  private static int[][] cost;
  private static boolean[][]used;
  private static int[] dx = {0,0,-1,1};
  private static int[] dy = {-1,1,0,0};
  private static Queue<Node> queue;
  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
     n = Integer.parseInt(st.nextToken());
     m = Integer.parseInt(st.nextToken());
    queue = new LinkedList<>();
    map = new int[n][m];
    cost = new int[n][m];
    used = new boolean[n][m];

    for (int i = 0 ; i < n ; i++){
      st = new StringTokenizer(br.readLine());
      for (int j = 0 ; j < m ; j ++){
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j]==2){
          used[i][j] = true;
          cost[i][j] = 0;
          queue.add(new Node(i,j));
        }
      }
    }
    bfs();
    for (int i = 0 ; i < n; i ++){

      for (int j = 0 ; j < m ; j ++){

        if(map[i][j] == 1 && cost[i][j]==0) {
          bw.write("-1 ");
        }else{
          bw.write(cost[i][j]+" ");
        }
      }
      bw.write("\n");
    }
    close();
  }

  public static void bfs(){

    while(!queue.isEmpty()){
      Node now = queue.poll();

      for(int i = 0; i< 4; i++){

        int ny = now.y + dy[i];
        int nx = now.x + dx[i];

        if(nx<0 || ny <0 || nx >=m || ny >=n) continue;
        if(used[ny][nx]) continue;
        if(map[ny][nx] == 0) continue;

        cost[ny][nx] = cost[now.y][now.x] +1;
        used[ny][nx] = true;
        queue.add(new Node(ny,nx));
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
