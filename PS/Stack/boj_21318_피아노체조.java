package PS.Stack;

import java.io.*;
import java.util.*;
public class boj_21318_피아노체조 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        init(); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i+1] = Integer.parseInt(st.nextToken());
        }    
        // 0 0 0 0 0 1 1 2 3 
        // 0 0 1 2 2 3
        int[] mistake = new int[n+1];
        mistake[1] = 0;
        for(int i = 2; i<=n; i++){
            if(arr[i]<arr[i-1]){
                mistake[i] = mistake[i-1]+1;
            }else{
                mistake[i] = mistake[i-1];
            }
        }

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        for(int i = 0 ;  i< q ; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y  = Integer.parseInt(st.nextToken());
            System.out.println(mistake[y]-mistake[x]);
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
