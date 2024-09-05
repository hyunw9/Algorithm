package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_9084_동전 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(--t>=0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] c = new int[n];
            st = new StringTokenizer(br.readLine());

            for(int i = 0 ; i < n ; i++){
                c[i] = Integer.parseInt(st.nextToken());
                
            }
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());            
            int[]dp = new int[K+1];
            dp[0]=1;
            for(int i = 1; i <= n ; i++){

                for(int k = 1 ; k <= K; k++){
                    if(c[i-1]<=k){
                        dp[k] += dp[k-c[i-1]];
                    }
                }
            }
            System.out.println(dp[K]);
            // System.out.println(Arrays.toString(dp));
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

/*
** 간략한 풀이 :
*/
