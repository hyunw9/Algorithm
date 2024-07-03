package PS.binarySearch;

import java.io.*;
import java.util.*;
public class boj_11663_선분위의점 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr= new int [n];
        Arrays.sort(arr);
        for(int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(binarySearch(end,true)-binarySearch(start,false)+"\n");
        }
        close();
    }
    public static int binarySearch(int num,boolean left){
        int l = 0;
        int r =arr.length-1;
        
        if(!left){
            while(l<=r){
                int mid = (l+r)/2;

                if(arr[mid]<num){
                    l = mid+1;
                }else{
                    r = mid -1;
                }
            }
            return l;
        }else{
            while(l<=r){
                int mid = (l+r)/2;

                if(arr[mid]>num){
                    r = mid-1;
                }else{
                    l = mid +1;
                }
            }
            
            return r+1;
        }

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
