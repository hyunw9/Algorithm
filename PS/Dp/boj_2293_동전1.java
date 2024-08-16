package PS.Dp;

import java.io.*;
import java.util.*;
public class boj_2293_동전1 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k+1];
        int[] coins = new int[n];
        Arrays.fill(dp,0);
        dp[0]=1;
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());

            for(int j = coins[i] ; j<=k ; j++){
                dp[j] += dp[j-coins[i]];
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(dp[k]);
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
