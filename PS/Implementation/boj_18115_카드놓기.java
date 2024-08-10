package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_18115_카드놓기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        StringTokenizer st = new StringTokenizer(new StringBuilder(br.readLine()).reverse().toString());
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =1 ; i <= n ; i++){
            int cmd = arr[i-1];

            if(cmd == 1){
                dq.addFirst(i);
            }else if(cmd ==2){
                int top = dq.pollFirst();
                dq.addFirst(i);
                dq.addFirst(top);
            }else{
                dq.addLast(i);
            }
        }
        for(int a : dq){
            bw.write(a+" ");
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