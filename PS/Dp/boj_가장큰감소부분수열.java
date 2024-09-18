package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_가장큰감소부분수열 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1 100 2 50 60 8 7 3 6 5
        // 첫번쨰건 무조건 가능 
        // 2번째부터 이전부터 현재의 합을 선택하기 vs 이전에 계산된 합을 고르기 
        // 1 100 0 0 0 0 0 0 0  
        int n = Integer.parseInt(st.nextToken());

        int[] arr= new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = arr[0];

        for(int i = 1; i < n ; i ++){
            int mv = 0;
            for(int j= 0 ; j < i; j++){
                if(arr[j]>arr[i]){
                    mv = Math.max(dp[j],mv);
                }
            }
            dp[i] = Math.max(mv+arr[i], arr[i]);

            
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(ans);

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