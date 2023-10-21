package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_11726_2xn타일링 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int size = Integer.parseInt(br.readLine());
        int[] dp = new int[size+1];
        dp[1]= 1;
        dp[2]= 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%10007;
        }

        bw.write(dp[size]+"");
        close();
    }

    public static void init(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }
}
