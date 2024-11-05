package PS.BFS;

import java.io.*;
import java.util.*;

public class boj_5427_불 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static String[][] grid; 
    private static int[] dx ={0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    private static int[][] cost;
    private static Queue<int[]> fq;
    private static Queue<int[]> sq;
    private static int escape ;

    public static void main(String[] args) throws IOException {
      init();
      StringTokenizer st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      while(--t>=0){  
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        grid = new String[n][m];
        cost = new int[n][m];
        fq = new LinkedList<>();
        sq = new LinkedList<>();

        for(int i =0; i<n; i++){
          String line = br.readLine();
          for(int j = 0 ; j < m ; j++){
            grid[i][j] = String.valueOf(line.charAt(j));

            if(grid[i][j].equals("*")){
              cost[i][j] = 1;
              fq.offer(new int[]{i,j});
              
            }else if(grid[i][j].equals("@")){
              sq.offer(new int[]{i,j,1});
            }
          }
        }

        escape = bfs(n,m);
        if(escape == -1){
          bw.write("IMPOSSIBLE\n");
        }else{
          bw.write(escape+"\n");
        }
      }
        close();
    }

    private static int bfs(int n,int m){

      while(!fq.isEmpty()){

        int[] curr = fq.poll();

        int y = curr[0];
        int x = curr[1];

        for(int i = 0; i < 4; i++){
          int ny = dy[i] + y;
          int nx = dx[i]+ x;

          if(ny<0 || nx < 0 || ny>=n || nx>=m||cost[ny][nx]>0||grid[ny][nx].equals("#")) continue;
          cost[ny][nx] = cost[y][x]+1;
          fq.offer(new int[]{ny,nx});
        }
      }
      System.out.println(Arrays.deepToString(cost));
      while(!sq.isEmpty()){
        int [] curr = sq.poll();
        int y = curr[0];
        int x = curr[1];
        int c = curr[2];
        // System.out.println("y : "+ y + " x : "+ x + " c : "+ c);

        if(y<=0 ||x <=0 || y >= n-1 || x>=m-1){
          return c;
        }

        for(int i = 0; i < 4; i++){
          int ny = dy[i]+y;
          int nx = dx[i]+x;

          if(ny<0 || nx < 0 || ny>=n || nx>=m||(cost[ny][nx]>0 && cost[ny][nx]<=c+1)||grid[ny][nx].equals("#")) continue;
          cost[ny][nx] = c+1;
          sq.offer(new int[]{ny,nx,c+1});
        }
      }

      return -1;
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
*/