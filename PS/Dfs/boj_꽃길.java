package PS.Dfs;

import java.io.*;
import java.util.*;

public class boj_꽃길 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int n ; 
    private static int[][] map;
    private static boolean[][] used; 
    private static int min;
    
    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        used=  new boolean[n][n];
        min = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0,0);
        System.out.println(min);
        close();
    }

    private static void dfs(int y,int x, int cnt,int curr){
        System.out.println("I : "+ y + " j : "+ x + " cnt : "+ cnt + " curr : "+ curr);
        if(cnt==3){
            min = Math.min(min,curr);
            return;
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i-1 < 0 || i+1 >=n || j-1< 0 || j+1>= n|| used[i][j]) continue; 
                if(canPlant(i,j)){
                    check(i,j);
                    dfs(i,j,cnt+1, curr+plant(i,j));
                    uncheck(i,j);
                }
            }
        }
    }

    private static int plant(int i, int j){
        int a = 0 ; 
        a += map[i][j];
        a += map[i-1][j];
        a += map[i+1][j];
        a += map[i][j+1];
        a += map[i][j-1];
        return a; 
    }

    private static void check(int i , int j ){
        used[i][j] = true;
        used[i-1][j] = true;
        used[i+1][j] = true;
        used[i][j-1] = true;
        used[i][j+1] = true;
    }

    private static void uncheck(int i , int j){
        used[i][j] = false;
        used[i-1][j] = false;
        used[i+1][j] = false;
        used[i][j-1] = false;
        used[i][j+1] = false;
    }

    private static boolean canPlant(int i, int j ){
        return !used[i][j] && !used[i-1][j] && !used[i+1][j] && !used[i][j-1] && !used[i][j+1];
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