package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_1189_컴백홈 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int n ;
    private static int m ;
    private static int k ;
    private static char[][] map;
    private static boolean [][]used;
    private static int cnt;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    
    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        used= new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j = 0 ; j < m ; j++){
                map[i][j]= line.charAt(j);
            }
        }
        used[n-1][0] = true;

        dfs(n-1,0,1);
        System.out.println(cnt);
        close();
    }

    private static void dfs(int y , int x, int count){

        // System.out.println("y : " + y + " x : "+ x );
        if(y== 0 && x == m-1){
            if(count == k){
                cnt+=1;
            }
            return;
        }

        for(int i = 0 ; i <4; i++ ){
            int ny = dy[i]+ y;
            int nx = dx[i] + x;
            if( ny < 0 || nx < 0 || ny >= n || nx >= m|| used[ny][nx] || map[ny][nx]=='T') continue;

            if(!used[ny][nx]){
                used[ny][nx] = true;
                dfs(ny,nx,count+1);
                used[ny][nx] = false;
            }
        }


    };

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
** 간략한 풀이 : 평범한 dfs
*/