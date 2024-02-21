package prgmrs.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기_87694 {

  static int[] dx = {0,0,-1,1};
  static int[] dy= {-1,1,0,0};
  static int[][] cost ;
  static boolean[][] used;
  static int max;
  static int[][] map;
  public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

    //1,1 부터 , 7,4 까지 채우는데, x 가 1이거나, y가 4일때만 채우기 ?
    for(int[] rect : rectangle){
      for(int a  : rect){
        max=Math.max(max,a);
      }
    }
    map = new int[max*2+1][max*2+1];
    cost =new int[max*2+1][max*2+1];
    used = new boolean[max*2+1][max*2+1];
    int curx = 0;
    int cury = 0;
    for(int i = 0 ; i < rectangle.length; i++){
      int x= rectangle[i][0]*2;
      int y= rectangle[i][1]*2;
      int destY= rectangle[i][3]*2;
      int destX = rectangle[i][2]*2;
      //y축 먼저 이동
      for(int j = x ; j<=destX; j++){
        for(int k = y ; k<=destY;k++){
          if(j==x || j==destX||k==y||k==destY){
            if(map[k][j]!=2) map[k][j] = 1;

          }
          else map[k][j] = 2;
        }
      }

    }

    // System.out.println(Arrays.deepToString(map));

    int answer = bfs(characterX*2, characterY*2,itemX*2,itemY*2);
    return answer;
  }
  public int bfs(int sX,int sY, int tX,int tY){
    Queue<int[]> q = new LinkedList<>();
    used[sY][sX] = true;
    q.add(new int[]{sY,sX});

    while(!q.isEmpty()){
      int[]now = q.poll();
      int y=now[0];
      int x=now[1];
      if(y==tY&&x==tX){
        return cost[y][x]/2;
      }
      for(int i = 0 ; i < 4; i++){
        int nx = dx[i] + x;
        int ny = dy[i]+ y;

        if(nx<=0||ny<=0||nx>=cost[0].length||ny>=cost.length) continue;
        if(used[ny][nx])continue;
        if(map[ny][nx]!=1) continue;
        used[ny][nx] = true;
        cost[ny][nx] = cost[y][x]+1;
        q.add(new int[]{ny,nx});
      }
    }
    return 0;

  }

}
