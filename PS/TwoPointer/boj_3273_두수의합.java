package PS.TwoPointer;

import java.io.*;
import java.util.*;
public class boj_3273_두수의합 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int t = Integer.parseInt(br.readLine());
        int l = 0;
        int r = n-1;
        int cnt =0 ; 
        //초과시 r --;
        //미달시 l ++;
        Arrays.sort(arr);
        while(l <= r){

            int sum = arr[l]+arr[r];

            if(sum == t){
                cnt +=1;
                r--;
                l++;
            }else if(sum > t){
                r--;
            }else{
                l++;
            }

        }

        System.out.println(cnt);
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
