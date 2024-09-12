package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_20152_GameAddiction {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int me = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int high = Math.max(me,target);
        int low = Math.min(me,target);
        long[][]dp = new long[high+1][high+1];
        dp[low][low] = 1;
        for(int i = low; i <= high; i ++){

            for(int j = low ;j<=high; j++ ){

                if(i>j) continue;
                else if(i==low && j == low){
                    continue;
                }
                if(i > low){
                    dp[i][j]+=dp[i-1][j];
                }
                if(j > low){
                    dp[i][j] += dp[i][j-1];
                }

            }
        }
        // for(int i = 0 ; i <=high; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        System.out.println(dp[high][high]);
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