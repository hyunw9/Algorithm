package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_2225_합분해 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][]dp = new int[k+1][n+1];
        for(int i = 0; i <= n ; i++){
            dp[1][i] = 1 % 1_000_000_000;
        }
        for(int i =1; i<= k; i++){
            dp[i][0] = 1;
        }

        if(k>=2){
            for(int i = 2; i <= k; i++){
                for(int j = 1; j<=n ;j++){
                    
                    dp[i][j] = (dp[i-1][j]+dp[i][j-1]) % 1_000_000_000;
                }
            }
        } 
        System.out.println(Arrays.deepToString(dp));
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