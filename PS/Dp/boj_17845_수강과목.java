package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_17845_수강과목 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] imp = new int[k];
        int [] c = new int[k];
        for(int i = 0 ; i < k ; i++){
            st = new StringTokenizer(br.readLine());
            imp[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        int[][]dp = new int[k+1][n+1];
        // dp[0][0] = 0;

        for(int i  = 1; i <= k; i++){

            for(int j = 1; j <= n ; j++){

                if(j - c[i-1] >=0){
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-c[i-1]]+imp[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        // for(int [] a : dp){
        //     System.out.println(Arrays.toString(a));
        // }
        System.out.println(dp[k][n]);
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