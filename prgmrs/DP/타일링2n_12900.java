package prgmrs.DP;
import java.util.*;

public class 타일링2n_12900 {

    public int solution(int n) {
        //n == 1
        //  1 
        //  n==2 2
        //  2 
        //  n==3
        //  l l l , --l, l-- 3
        //  n == 4
        //  llll, l--l, ll--, --ll, ---- 5
        //  
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        int answer = 0;
        for(int i = 2; i < dp.length ; i ++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}

