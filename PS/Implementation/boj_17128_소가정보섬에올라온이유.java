package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_17128_소가정보섬에올라온이유 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr =new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ps = new int[n];

        for(int i = 0 ; i < n ; i++){
            int sum = 1;
            for(int j  = 0; j < 4; j++){
                sum *= arr[(i+j) % n];
            }
            ps[i] = sum;
        }
        // System.out.println("init : "+ Arrays.toString(ps));
        int tot = 0;
        for(int val : ps){
            tot+=val;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m ; i++){
            int tweak = Integer.parseInt(st.nextToken())-1;
            // ArrayList<Integer> idx = new ArrayList<>();
            for(int j = 0 ; j < 4; j++){
                if(tweak < 0){
                    tweak+= n;
                }
                ps[tweak]*=-1;
                tot += (ps[tweak]*2); 
                tweak--;
            }
        
            System.out.println(tot);
        }
        
        // System.out.println(Arrays.toString(ps));
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