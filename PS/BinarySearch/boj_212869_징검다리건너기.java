package PS.BinarySearch;

import java.io.*;
import java.util.*;
public class boj_212869_징검다리건너기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st=  new StringTokenizer(br.readLine());
        int[] arr= new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        dp[0]=1;
        for(int i = 0; i < n-1; i++){
            if(dp[i] == 1){
                for(int j = i+1; j< n; j++){
                    if((j-i)*(1+Math.abs(arr[i]-arr[j]))<=k){
                        dp[j] = 1;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
       
        // n-1이 0이라는 뜻은, 도달하지 못했다는 뜻 
        if(dp[n-1]==0) System.out.println("NO");
        else System.out.println("YES");

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
