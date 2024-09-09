package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_29704_벼락치기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] p = new int[n];
        int[] f = new int[n];

        int[][] dp = new int[n+1][T+1];
        // for(int i = 0 ; i <= n ; i++){
        //     Arrays.fill(dp[i],987654321);
        // }
        int total = 0;
        for(int i = 0 ;i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            p[i] = num;
            f[i] = money;
            total+=money;
        }
        dp[0][0] = 0;
        for(int i = 1; i<= n ;i++){
            for(int t=1; t<=T; t++){

                if(p[i-1]<=t){

                    dp[i][t] = Math.max(dp[i-1][t], dp[i-1][t-p[i-1]]+f[i-1]);
                }else{
                    dp[i][t] =dp[i-1][t];
                }
            }
        }
        System.out.println(total-dp[n][T]);
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
