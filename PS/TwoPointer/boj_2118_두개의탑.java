package PS.TwoPointer;

import java.io.*;
import java.util.*;

public class boj_2118_두개의탑 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        // StringTokenizer st = new StringTokenize r(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[]arr = new int[n];
        
        int tot = 0;
        
        for(int i = 0 ; i <n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            tot+=arr[i];
        }

        int l =0;
        int r = 1;

        int rsum = arr[l];
        int lsum = tot-rsum;

        int max = 0;
        while(l<n){

            int val = Math.min(rsum,lsum);

            if(val>=max){
                // System.out.println(max);
                max= val;
            
            }
            if(rsum < lsum){
                rsum +=arr[r];
                lsum -=arr[r];
                r+=1;
                r%=n;
            }else{
                rsum-=arr[l];
                lsum+=arr[l];
                l+=1;
            }
        }
        System.out.println(max);
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