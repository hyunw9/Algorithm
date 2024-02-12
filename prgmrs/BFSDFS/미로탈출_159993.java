package prgmrs.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출_159993 {

  private static int[] dx = {0,0,-1,1};
  private static int[] dy= {-1,1,0,0};
  private static int n;
  private static int m;
  private static Queue<Node> q;
  private static int lever = 987654321;
  private static int exit=987654321;
  private static boolean[][] used;
  private static char[][] map ;

  static class Node{
    int y;
    int x;
    int c;
    public Node(int y,int x,int c){
      this.y= y;
      this.x= x;
      this.c=c;

    }
  }
  public int solution(String[] maps) {
    int answer = 0;
    n = maps.length;
    m= maps[0].length();
    q = new LinkedList<>();
    used= new boolean[n][m];
    map = new char[n][m];
    int leverY=0;
    int leverX=0;
    for(int i = 0 ; i < n; i++){
      for(int j = 0 ; j<m ;j++){
        map[i][j] = maps[i].charAt(j);
        if(map[i][j]=='S'){
          used[i][j]= true;
          q.add(new Node(i,j,0));
        }else if(map[i][j]=='L'){
          leverY=i;
          leverX=j;
        }
      }
    }
    bfsToLever();
    q= new LinkedList<>();
    used = new boolean[n][m];
    q.add(new Node(leverY,leverX,0));
    bfsToExit();

    if(lever == 987654321||exit==987654321) return -1;
    return lever+exit;
  }
  public void bfsToLever(){

    while(!q.isEmpty()){

      Node now = q.poll();
      //System.out.println(now.y + " "+now.x+" " + now.qualified);
      if(map[now.y][now.x]=='L'){
        lever= Math.min(lever,now.c);
      }

      for(int i= 0;i<4;i++){
        int nx = dx[i] + now.x;
        int ny= dy[i] + now.y;

        if(nx<0 || ny< 0 || nx>=m || ny>=n) continue;
        if(used[ny][nx]) continue;
        if(map[ny][nx]=='X') continue;

        used[ny][nx] = true;
        q.add(new Node(ny,nx,now.c+1));
      }
    }

  }
  public void bfsToExit(){
    while(!q.isEmpty()){

      Node now = q.poll();
      //System.out.println(now.y + " "+now.x+" " + now.qualified);
      if(map[now.y][now.x]=='E'){
        exit = Math.min(exit,now.c);
      }

      for(int i= 0;i<4;i++){
        int nx = dx[i] + now.x;
        int ny= dy[i] + now.y;

        if(nx<0 || ny< 0 || nx>=m || ny>=n) continue;
        if(used[ny][nx]) continue;
        if(map[ny][nx]=='X') continue;

        used[ny][nx] = true;
        q.add(new Node(ny,nx,now.c+1));
      }
    }
  }

}
