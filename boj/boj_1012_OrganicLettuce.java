package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1012_OrganicLettuce {
    
    public boj_1012_OrganicLettuce()  {
    }
    static int M ;
    static int N ;
    static int k ;
    static int [][]area ;
    static boolean [][]visited ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T =Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            M =Integer.parseInt(st.nextToken());
            N =Integer.parseInt(st.nextToken());
            k =Integer.parseInt(st.nextToken());
            area = new int[M][N];
            visited = new boolean[M][N];
            int bug = 0;
            for (int j = 0; j< k; j++) {
                st= new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                area[x][y] = 1;

            }
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (area[x][y] == 1 && !visited[x][y]){
                        bug++;
                        dfs(x,y);
                    }
                }

            }
            System.out.println("bug = " + bug);
        }


    }
    private static void dfs(int x, int y){
        int[] dx = { 0, 0, -1, +1};                //0,-1 상 , 0,+1 하 , -1,0 좌 , +1,0 우
        int[] dy = { -1, +1, 0, 0};
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int xn= dx[i]+ x;
            int yn= dy[i]+y;

            if((xn> -1 && xn<M )&& ((yn> -1 && yn <N) && !visited[xn][yn] && area[xn][yn]== 1)){
                dfs(xn,yn);
            }
        }
    }

}
/*
for (int i = 0; i < lettuce.length; i++) {
        for (int j = 0; j <lettuce.length ; j++) {
        System.out.println("lettuce"+ i  +" "+ j +"="+ lettuce[i][j]);
        }
        }*/
