package PS.Dp;

import java.io.*;
import java.util.*;
public class boj_4097_수익 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        while(true){
        int n = Integer.parseInt(br.readLine());
        if (n == 0 ) break;
        int[] arr= new int [n];
        int[] dp = new int[n];
        for(int i  =0 ; i  < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[0]=arr[0];
        for(int i = 1; i < n; i++ ){
            dp[i] =Math.max(arr[i]+dp[i-1],arr[i]);
        }
        int max = 0;
        for(int a : dp){
            max = Math.max(max,a);
        }
        System.out.println(max);
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
