package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_9252_LCS2 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        // StringTokenizer st = new StringTokenizer(br.readLine());
        String l1 = br.readLine();
        String l2 = br.readLine();
        int n = l2.length();
        int m = l1.length();
        int[][]dp = new int[l2.length()+1][l1.length()+1];
        for(int i=1; i<=n; i++){
            for(int j = 1; j <=m;j++){
                if(l1.charAt(j-1)==l2.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        int val = dp[n][m];
        int y = n;
        int x = m;
        StringBuilder sb=  new StringBuilder();
    
        while(val!=0){
            // System.out.println("y : "+ y +  " x : "+ x );
            if (dp[y][x] == dp[y-1][x-1] + 1 && l1.charAt(x-1) == l2.charAt(y-1)) {
                    sb.append(l2.charAt(y-1));    
                
                y-=1;
                x-=1;
            }else if(dp[y][x-1]>=dp[y-1][x]){
                x-=1;
            }else{
                y-=1;    
            }

            val = dp[y][x];
        }
        System.out.println(dp[n][m]);
        System.out.println(sb.reverse().toString());
        // System.out.println(Arrays.deepToString(dp));
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