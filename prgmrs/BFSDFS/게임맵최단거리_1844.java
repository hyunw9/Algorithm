package prgmrs.BFSDFS;

import java.util.*;

public class 게임맵최단거리_1844 {

  private static int[][]score;
  private static boolean[][]used;
  private static Queue<Curr> q;
  private static int[] dx = {0,0,-1,1};
  private static int[] dy = {-1,1,0,0};
  private static int answer;
  private static int n;
  private static int m;
  private static int max;

  public static class Curr{
    int y;
    int x;
    int score;

    public Curr(int y, int x,int score){
      this.y = y;
      this.x = x;
      this.score = score;
    }
  }
  public int solution(int[][] maps) {
    answer = 0;
    n = maps.length;
    m = maps[0].length;
    q = new LinkedList<>();
    score = new int[n][m];
    used = new boolean[n][m];
    used[0][0] = true;
    score[0][0]= 0;
    q.add(new Curr(0,0,1));



    return bfs(maps);
  }

  public static int bfs(int[][]maps ){
    while(!q.isEmpty()){
      Curr now = q.poll();
      if(now.y == n-1  && now.x == m-1){
        return now.score;
      }

      for(int i = 0 ; i < 4; i++){
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];

        //if(nx>0 && ny > 0 && nx<n && ny < )
        if(nx<0 || ny<0 || nx>=m||ny >=n) continue;
        if(used[ny][nx]) continue;
        if(maps[ny][nx]!= 1) continue;

        used[ny][nx]= true;

        //max = Math.max(max,score[ny][nx]);
        q.add(new Curr(ny,nx,now.score+1));
      }
    }
    //System.out.println(Arrays.deepToString(score));
    return -1;

  }

}
