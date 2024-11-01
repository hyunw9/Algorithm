package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_15990_123더하기5 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max=  Math.max(max,arr[i]);
        }
        long [][]dp = new long[100001][3];
        Arrays.fill(dp[3],1);
        dp[1][0] = 1;
        dp[2][1] = 1;

        for(int i =4; i <= 100000; i++){

            if(i >= 1){
                dp[i][0] = (dp[i-1][1]+dp[i-1][2])%1_000_000_009; 
            }
            if(i>=2){
                dp[i][1] += (dp[i-2][0]+dp[i-2][2])%1000000009;
            }
            if(i>=3){
                dp[i][2] +=(dp[i-3][0]+dp[i-3][1])%1000000009;
            }
        }
        
        for(int val : arr){
            long sum = dp[val][0]+dp[val][1]+ dp[val][2];
            System.out.println(sum%1_000_000_009);
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