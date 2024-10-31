package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_1495_기타리스트 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int init = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] v = new int[n+1];
        for(int i = 1 ; i < n+1; i++){
            v[i] = Integer.parseInt(st.nextToken());
        }
        long[][] dp = new long[n+1][max+1];
        dp[0][init] =1;
        for(int i = 1; i <=n; i++){

            for(int j = 0; j <= max ; j++){
                if(dp[i-1][j]>0){
                    int p = j +v[i];
                    int m= j - v[i];

                    if(p<=max){
                        dp[i][p]+=dp[i-1][j];
                    }
                    if(m>=0){
                        dp[i][m] += dp[i-1][j];
                    }
                }
            }
        
        }
        int res = -1;

        for(int i = 0; i <= max; i++){
            if(dp[n][i]>0){
                res = Math.max(res,i);
            }
        }
        // System.out.println(Arrays.toString(dp[n]));
        System.out.println(res);
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