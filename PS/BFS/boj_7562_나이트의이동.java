package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class boj_7562_나이트의이동 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[][]map ;
  private static Queue<Node> q;
  private static int cnt;
  private static int t;
  private static int ty;
  private static int tx;
  private static int[] dx = {1,2,2,1,-1,-2,-2,-1};
  private static int[] dy = {-2,-1,1,2,2,1,-1,-2};

  private static class Node{
    int y;
    int x;
    public Node(int y,int x){
    this.y=y;
    this.x=x;
    }
  }




  public static void main(String[] args) throws IOException {
    init();
    t= Integer.parseInt(br.readLine());
    q = new LinkedList<>();
    for(int i = 0; i < t ; i ++){
      int n = Integer.parseInt(br.readLine());
      map = new int[n][n];
      String line = br.readLine();
      int y = Integer.parseInt(line.split(" ")[0]);
      int x = Integer.parseInt(line.split(" ")[1]);
      map[y][x] = 1;
      q.add(new Node(y,x));
      line = br.readLine();
      ty = Integer.parseInt(line.split(" ")[0]);
      tx =Integer.parseInt(line.split(" ")[1]);

      while(!q.isEmpty()){

        Node now = q.poll();

        if(now.x == tx && now.y == ty){
          bw.write(map[ty][tx]-1+"\n");
        }
        for(int j = 0; j < 8 ; j ++){
          int nx = dx[j]+ now.x;
          int ny = dy[j]+ now.y;

          if(ny<0 || nx <0 || ny>=n||nx>=n) continue;
          if(map[ny][nx]>0) continue;
          map[ny][nx] = map[now.y][now.x]+1;
          q.add(new Node(ny,nx));

        }
    }
  }
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
