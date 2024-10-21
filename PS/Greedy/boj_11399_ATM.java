package PS.Greedy;

import java.io.*;
import java.util.*;

public class boj_11399_ATM {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n ; i++){

            pq.offer(Integer.parseInt(st.nextToken()));

        }
        int res = 0 ;
        int sum = 0;
        while(!pq.isEmpty()){
            int val = pq.poll();
            System.out.println(sum );
            res = val + res;
            sum += res;


        }
        System.out.println(sum);
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