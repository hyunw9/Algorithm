package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_10844_쉬운계단수 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main (String[] args) throws IOException{
        init();
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 9;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + (dp[i-2]*2)-i;
        }
        bw.write(dp[N]%1000000000+"");
        close();
    }

    public static void init(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }
}
