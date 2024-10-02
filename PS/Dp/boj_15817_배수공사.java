package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_15817_배수공사 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 상태 : 파이프 종류, 파이프 길이
        // 선택 : 파이프를 선택 할지 , 파이프를 선택 하지 않을지
        // 변주 : 파이프 개수가 여러개임 
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        
        int []p = new int[n];
        int []c = new int[n];
        int[] dp = new int[x+1];

        dp[0] = 1;

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n ; i++){
            int length = p[i-1];
            int count = c[i-1];

            for(int j = x; j >= 0 ; j--){
                for(int k =1; k<=count && j - k*length >= 0 ; k++){
                    dp[j] +=dp[j-k*length];
                }
                

            }

        }
        System.out.println(dp[x]);

        // for(int[]a : dp){
        //     System.out.println(Arrays.toString(a));
        // }
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