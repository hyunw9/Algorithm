package PS.DP;

import java.io.*;
import java.util.*;

public class boj_11052_카드구매하기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int[] dp = new int[n+1];
        int[] arr = new int[n+1];
        dp[0] = 0;
        arr[0] = 0;
        for (int i = 1; i <=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <=n; i++) {
            int div = i/2 ;
            int max = 0;
            for(int j = 1; j<=div;j++){
                max = Math.max(dp[j] + dp[i-j],max);
                // dp[i] = Math.max(arr[i],dp[div]+dp[i-div]);
            }
            dp[i] = Math.max(max,arr[i]);
        }

        bw.write(dp[n]+"");
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
