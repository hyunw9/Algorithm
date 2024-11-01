package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_14430_자원캐기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr= new int[n][m];

        for(int i = 0 ;  i< n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                arr[i][j] =  Integer.parseInt(st.nextToken());
            }
        }
        int[][]dp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                if(i==0&&j==0){
                    continue;
                }else if(i==0){
                    dp[i][j] = dp[i][j-1]+arr[i][j];
                }else if(j ==0){
                    dp[i][j] = dp[i-1][j]+arr[i][j];
                }else{
                    dp[i][j]= Math.max(dp[i-1][j],dp[i][j-1])+arr[i][j];
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
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

/*
** 간략한 풀이 :
*/