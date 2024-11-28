package PS.  TwoPointer;

import java.io.*;
import java.util.*;

public class boj_9024_두수의합 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(--t>=0){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int found = find(arr,m);
            bw.write(found+"\n");
        }
        close();
    }

    public static int find(int[]arr, int key){
        int l =0 ;
        int r =arr.length-1;
        int res =0;
        ArrayList<Integer> list = new ArrayList<>();
        int min= Integer.MAX_VALUE;
        while(l<r){

            int sum = arr[l]+arr[r];
            int diff = Math.abs(key-(arr[r]+arr[l]));
            min = Math.min(min,diff);
            list.add(diff);
            if(sum>key){
                r-=1;
            }else{
                
                l+=1;
            }
        }

        for(int val : list){
            if(val== min){
                res+=1;
            }
        }
        
        return res;
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