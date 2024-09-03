package PS.Dp;

import java.io.*;
import java.util.*;
public class boj_3067_coins {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(--t>=0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] c = new int[n+1];
            for(int i = 1 ; i <= n ; i++){
                c[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());

            // int[][] dp = new int[n+1][K+1];
            // dp[0][0] = 1;
            int[] dp = new int[K+1];
            dp[0] = 1;
            for(int i = 1; i <= n ; i++){
                for(int k = 1; k<= K; k++){
                    if(k>=c[i])
                    dp[k] += dp[k-c[i]];
                
                }
            }

            System.out.println(dp[K]);

        }
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
