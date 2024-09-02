package PS.Dp;
// package PS.DP;

import java.io.*;
import java.util.*;

public class boj_12865_평범한배낭 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int n;
    private static int K;
    private static int[]w;
    private static int[]v;
    private static int[][]dp;


    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        w= new int[n+1];
        v= new int[n+1];
        dp = new int[n+1][K+1];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(w));
        for(int i = 1 ; i <= n; i++){
            for(int k = 1; k<= K; k++ ){
                if(w[i-1]<=k){
                    dp[i][k] = Math.max(dp[i-1][k],dp[i-1][k-w[i-1]]+v[i-1]);
                }else{
                    dp[i][k] = dp[i-1][k];
                }
            }
        }
        System.out.println(dp[n][K]);

        
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
