package PS.TwoPointer;

import java.io.*;
import java.util.*;

public class boj_2470_두용액 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // -99 -2 -1 4 98
        // 0 1 min 값 보다 현재 값이 크면, r ++ ;
        //그럼 min 값 보다 현재 값이 작으면 l++
        int l = 0;
        int r = n-1;
        int min =Integer.MAX_VALUE; 
        int ansl = 0;
        int ansr = 0;
        while(l < r){

            int sum = arr[l]+arr[r];
            //0보다 클시 r--;
            //0보다 작을시 l++;
            if(Math.abs(sum)<min){
                min = Math.abs(sum);
                ansl = l;
                ansr = r;
            }
                
            if(sum > 0){
                r--;
            }else{
                l++;
            }

        }

        // System.out.println(Arrays.toString(arr));
        // System.out.println("l : "+ ansl + " r: "+ ansr);
        // System.out.println("l : " +arr[l]+"  r: "+  arr[r]);
        if(arr[ansl]<arr[ansr]){
            System.out.println(arr[ansl]+" "+arr[ansr]);
        }else{
            System.out.println(arr[ansr]+" "+arr[ansl]);
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
