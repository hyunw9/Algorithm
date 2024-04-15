package PS.DP;

import java.io.*;
import java.util.*;

public class boj_10055_가장큰증가하는부분수열 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int [] arr = new int[n];
        int [] dp = new int[n];
        int max = 0;
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for(int i = 1 ; i < n ; i++){
            int before = 0 ; 
            int val = 0;
            
            if(arr[i-1]>arr[i]){
                for(int j = 0 ; j <i; j++){
                    if(arr[j]<arr[i]&&val<arr[j]){
                        before+=arr[j];
                        val = arr[j];
                    }
                }

                dp[i] = Math.max(dp[n-1],before)+arr[i];
        }else{
            dp[i]= dp[i-1]+ arr[i];
        }
        }
        for(int val : dp){
            max = Math.max(val,max);
        }
        System.out.println(Arrays.toString(dp));
        bw.write(max+"");
        // 1 100 2 50 60 3 5 6 7 8
        // 1 
        // 1,0 
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