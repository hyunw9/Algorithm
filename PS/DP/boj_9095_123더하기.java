package PS.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_9095_123더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T =Integer.parseInt(st.nextToken());
        int[] dp ;
        int[] arr = new int[T+1];
        int max= 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
            max=Math.max(max,arr[i]);
            
        }
        dp= new int[max+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        for (int i = 0; i < T; i++) {
            sb.append(dp[arr[i]]+"\n");
        }
        System.out.println(sb);
    }
}
