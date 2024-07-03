package PS.Dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11053_증가하는부분수열 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int N;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());
        int max= 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                   max= Math.max(max,dp[i]);
                }
            }
        }
        bw.write(max+"");
        close();
    }

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }

}
