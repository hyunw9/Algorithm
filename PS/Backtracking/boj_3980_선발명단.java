package PS.Backtracking;

import java.io.*;
import java.util.*;

public class boj_3980_선발명단 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int answer;
    
    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int k = 0; k < t; k++){
            answer =0;
            int[][] arr = new int[11][11];
            boolean[] player = new boolean[11];
            for(int i= 0; i < 11; i++){
                st  = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(arr,player, 0,0);
            System.out.println(answer);
        }
        close();
    }

    public static void dfs(int[][]arr, boolean[]player, int idx, int score){

        if( idx == 11){
            answer =Math.max(score,answer);
            return;
        }

        for( int i = 0; i < 11 ; i++){
            if(!player[i] && arr[idx][i]!=0){
                player[i] = true;
                dfs(arr,player,idx+1,score+arr[idx][i]);
                player[i] = false;
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
