package PS.TwoPointer;

import java.io.*;
import java.util.*;
public class boj_25916_싫은데요 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr= new int[n];
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = 0;
        int sum = 0;
        int max =0;
        while(r < n){

            if(arr[r]+ sum <= m){
                sum+= sum+arr[r];
                max = Math.max(sum,max);
                r+=1;
            }else{
                sum-=arr[l];
                l++;
            }
            if(l>r){
                sum +=arr[r];
                r++;
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
