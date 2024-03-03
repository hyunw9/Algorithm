package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_10844_쉬운계단수 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main (String[] args) throws IOException{
        init();
        int size = Integer.parseInt(br.readLine());
        long[][] dp = new long[size][10];
        for(int i = 0 ; i< 10; i++){
            if(i>0) dp[0][i] = 1;
            else dp[0][i] = 0;
        }
        for(int i = 1 ; i < size; i ++){
            for(int j = 0 ; j<dp[i].length; j++){

                if(j+1>=dp[i].length) {
                    dp[i][j] =( dp[i-1][j-1])%1000000000;
                }else if(j>0){
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])%1000000000;
                }else {

                     dp[i][j] = (dp[i-1][j+1])%1000000000;
                }

            }
        }
        long sum = 0;
        for(long a : dp[size-1]){
            sum+=a;
        }
        //System.out.println(Arrays.deepToString(dp));

        //      0 1 2 3 4 5 6 7 8 9
        // 1    0 1 1 1 1 1 1 1 1 1
        // 2    1 1 2 2 2 2 2 2 2 1
        // 3    1 3 3 4 4 4 4 4 3 2
        // 4
        bw.write(sum%1000000000+"");
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
