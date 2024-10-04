package PS.BFS;

import java.io.*;
import java.util.*;

public class boj_2589_보물섬 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    private static int max ;
    private static char[][] graph;
    private static boolean[][] visited;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new char[n][m];

        for(int i =0 ; i < n ; i++){
            String line = br.readLine();

            for(int j = 0; j < m ; j++){
                graph[i][j] = line.charAt(j);
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(graph[i][j] == 'L') {
                    visited = new boolean[n][m];
                    System.out.println("start");
                    bfs(i,j,0);
               }
            }
        }
        System.out.println(max);
        close();
    }

    public static void bfs(int y, int x, int cnt){
        Queue<int[]> q = new LinkedList<>();

        visited[y][x] = true;
        q.offer(new int[]{y,x,0});

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int cy = curr[0];
            int cx = curr[1];
            int c = curr[2];

            max = Math.max(max, c);
            
            for(int i =0; i< 4; i++){
                int ny= cy + dy[i];
                int nx = cx + dx[i];
                
                if(ny < 0 || nx < 0|| ny >= n || nx >= m) continue;

                if(visited[ny][nx] || graph[ny][nx]=='W') continue;

                visited[ny][nx] = true;
                q.offer(new int[]{ny,nx,c +1});
            }

        }
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