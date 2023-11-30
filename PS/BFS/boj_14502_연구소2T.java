package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14502_연구소2T {

  private static class Node{
    int y;
    int x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int[][] map;

  private static int n;
  private static int m;
  private static int max;

  private static int dx[] = {0,0,-1,1};

  private static int dy[] = {-1,1,0,0};

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
     n = Integer.parseInt(st.nextToken()); //세로
     m = Integer.parseInt(st.nextToken()); //가로
    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(0);
    bw.write(max+"");
    close();
  }

  public static void dfs(int wall){
    if(wall == 3){
      bfs();
      return;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(map[i][j]==0){
          map[i][j] = 1;
          dfs(wall+1);
          map[i][j] = 0;
        }
      }
    }
  }

  public static void bfs(){
    ArrayDeque<Node> viruses= new ArrayDeque<>();
    int[][] dupMap = new int[n][m];
    boolean[][] used = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dupMap[i][j] = map[i][j];
        if(dupMap[i][j]==2){
          viruses.addFirst(new Node(i,j));
          used[i][j] = true;
        }
      }
    }

    while(!viruses.isEmpty()){
      Node virus = viruses.pollLast();

      for (int i = 0; i < 4; i++) {

        int nx = dx[i] + virus.x;
        int ny = dy[i] + virus.y;

        if(nx>=0&&ny>=0&&ny<n&&nx<m){
          if(!used[ny][nx]&&dupMap[ny][nx]!=1){
            dupMap[ny][nx] = 2;
            used[ny][nx] = true;
            viruses.addFirst(new Node(ny,nx));
          }
        }

      }
    }
    getMax(dupMap);
  }

  public static void getMax(int[][] dupmap){
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if(dupmap[i][j]== 0) cnt+=1;
      }
    }
    max = Math.max(max,cnt);
  }

  public static void init(){
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }
}
