package PS.BFS;

import java.io.*;
import java.util.*;
public class boj_2206_벽부수고이동하기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for ( int i = 0 ; i < n; i++){
            String[] line = br.readLine().split("");
            for ( int j = 0 ; j < m ; j++){
                map[i][j]= Integer.parseInt(line[j]);
            }
        }
        int[][][] visited = new int[n][m][2];

        Queue<int[]> q = new LinkedList<>();
    
        visited[0][0][0] = 1;

        q.add(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int y = curr[0];
            int x=  curr[1];
            int w = curr[2];

            if(y == n-1 && x == m-1){
                System.out.println(visited[y][x][w]);
                return;
            }
            for( int i = 0 ; i < 4 ; i++){
                int ny = dy[i]+y;
                int nx = dx[i]+x;

                if( ny < 0 || ny>=n || nx <0 || nx>=m) continue;
                if(map[ny][nx]==1 && w ==0){
                    visited[ny][nx][1] = visited[y][x][0]+1;
                    q.add(new int[]{ny,nx,1});
                }
            
                if( map[ny][nx]==0 && visited[ny][nx][w]==0){
                    visited[ny][nx][w] = visited[y][x][w]+1;
                    q.add(new int[]{ny,nx,w});
                }
            }
            
        }
        System.out.println(-1);
        close();
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
