package PS.PriorityQueue;

import java.io.*;
import java.util.*;

public class boj_1202_보석도둑 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long weight = 0;

        //무거운거부터 꺼냄 
        PriorityQueue<int[]>pq = new PriorityQueue<>((o1,o2)->{
            if(o1[0]==o2[0])
                return o2[1]-o1[1];
            return o2[0]-o1[0];
        });
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i< n ; i ++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{m,v});
        }

        PriorityQueue<Integer> bag = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i = 0 ; i < k ; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            bag.offer(w);
        }

        while(!bag.isEmpty()){

            int cap = bag.poll();
            int maxw = 0;
            int maxv = 0;
            while(!pq.isEmpty()){
                int[] jew = pq.poll();
                System.out.println(Arrays.toString(jew));
                if(jew[0]>cap) break;
                if(maxw<jew[0]){
                    if(set.contains(maxw)) continue;
                    maxw=jew[0];
                    maxv=jew[1];
                }
            }
            System.out.println(maxw);
            if(!set.contains(maxw)){
                weight += maxv;
                set.add(maxw);
            }

        }




        
        System.out.println(weight);
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
