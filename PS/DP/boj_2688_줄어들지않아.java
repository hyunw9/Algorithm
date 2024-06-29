package PS.DP;

import java.io.*;
import java.util.*;
public class boj_2688_줄어들지않아 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int t = Integer.parseInt(br.readLine());
        long [][]dp = new long [65][10];
        //         0 1 2 3 4 5 6 7 8 9 이전 자리 숫자
        //1 일때는 0 1 2 3 4 5 6 7 8 9 
        //2 일때는 10 9 8 7 6 5 4 3 2 1  == 55  
        //3 일때는 55 45 36 28 21 15 10 6 3 1 0 == 
        Arrays.fill(dp[0],0);
        for(int i = 0 ; i <10 ; i ++){
            dp[1][i] = 1;
        }
        for(int i = 2 ; i <= 64; i++){
            for(int k = 0 ; k < 10; k++){
                for(int j = k; j < 10 ;  j++){
                    dp[i][k]+= dp[i-1][j];
                }
            }
            
        }
        // System.out.println(Arrays.deepToString(dp));

        for(int i = 0; i < t ; i++){
            int n = Integer.parseInt(br.readLine());
            long sum = 0;
            for(int j = 0 ; j < 10; j ++){
                sum+=dp[n][j];
            }        
            bw.write(sum+"\n");
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
