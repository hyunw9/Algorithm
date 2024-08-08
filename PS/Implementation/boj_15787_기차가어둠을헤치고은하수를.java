package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_15787_기차가어둠을헤치고은하수를 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        int[] train = new int[n];

        for(int i =0 ; i < m; i++){

            st= new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            
            if( c == 1){
                int target = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                train[target-1] |= (1<<to-1);
            }else if(c == 2){
                int target = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                train[target-1] &= ~(1 << to-1); 
            }else if(c == 3){
                int target = Integer.parseInt(st.nextToken());
                train[target-1] = (train[target-1]  & ~(1 << 19)) << 1;
            }else if(c == 4){
                int target = Integer.parseInt(st.nextToken());
                train[target-1] = (train[target-1] & ~(1<< 0)) >> 1;
            }
        }
        for(int i = 0 ; i < n; i++){
            set.add(train[i]);
        }
        System.out.println(set.size());
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
