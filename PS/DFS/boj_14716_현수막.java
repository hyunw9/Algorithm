package PS.DFS;

import java.io.*;
import java.util.*;

public class boj_14716_현수막 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] dx= { -1,1,0,0,-1,-1,1,1};
    private static int[] dy= { 0,0,-1,1,-1,1,-1,1};
    private static boolean[][] visited;
    private static int[][]map;
    private static int cnt;
    private static int n;
    private static int m;


    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0 ;j <m; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j <m ; j++){
                if(map[i][j]==1 && !visited[i][j]){
                    cnt+=1;
                    dfs(i,j);
                }
            }
        }
        System.out.println(cnt);
        close();
    }
    private static void dfs(int y, int x){
        visited[y][x] = true;

        for(int i = 0 ; i < 8; i++){
            int ny = dy[i]+ y;
            int nx = dx[i]+ x;

            if(ny<0 || nx <0 || ny>=n || nx >=m|| visited[ny][nx]||map[ny][nx]==0) continue;
            dfs(ny,nx);
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
