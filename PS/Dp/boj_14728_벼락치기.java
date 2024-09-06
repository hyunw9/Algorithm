package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_14728_벼락치기 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    // private static HashMap<Integer,Integer> score ;
    private static int[] score;
    private static int[] time;
    private static int T;
    private static int n;
    private static int max;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        score = new int[n]; 
        time = new int[n];

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int spend = Integer.parseInt(st.nextToken());
            int get = Integer.parseInt(st.nextToken());
            time[i] = spend;
            score[i] = get;
        }
        int[][] dp = new int[n+1][T+1];
        dp[0][0] = 0;
        for(int i = 1 ; i <= n; i++){

            for(int t = 1; t<=T; t++){
                if(time[i-1]<=t){
                    dp[i][t] = Math.max(dp[i-1][t], dp[i-1][t-time[i-1]]+ score[i-1]);
                }else{
                    dp[i][t] = dp[i-1][t];
                }

            }
        }
      
        System.out.println(dp[n][T]);
        close();
    }

    // public static void dfs(int val, int idx, int cnt){
    //     if(val <= t){
    //         max = Math.max(max,cnt);
    //     }

    //     if(val>t){   
    //         return;
    //     }
    //     for(int i = idx ; i < n ; i++){
    //         if(!used[i]){
    //             used[i]= true;
    //             // 점수 넘는지 확인
    //             if(val + time[i] <= t)
    //                 dfs(val + time[i],i+1,cnt+ score.get(time[i]));
    //             used[i] = false;
    //         }
    //     }
    // }

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
* 처음에 백트래킹으로 풀었지만, 시간 초과가 발생한다. 최대 1000개까지 가능하기 때문에, O(n^2)이라 절대 실패.
* 최대 점수를 dp로 계산하는 방식으로 풀었다. 
*/