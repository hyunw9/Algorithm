package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_11057_오르막수 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][]dp = new int[n+1][10];
        for(int i = 0;i < 10; i++){
            dp[0][i] = 1;
        }

        for(int i = 1; i <=n; i++){
            for(int j = 0; j<10; j++){
                int sum = 0;
                for(int k = j;k<10;k++){
                    sum+=dp[i-1][k];
                }
                dp[i][j]+= sum%10007;
            }
        }
        System.out.println(dp[n][0]);
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