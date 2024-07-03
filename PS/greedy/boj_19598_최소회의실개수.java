package PS.Greedy;

import java.io.*;
import java.util.*;
public class boj_19598_최소회의실개수 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n; i++ ){
            st= new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }

       rooms.add(pq.poll()[1]);
       
       while(!pq.isEmpty()){
        int[] curr = pq.poll();

        if(curr[0]>=rooms.peek()){
            rooms.poll();
        }
        rooms.add(curr[1]);
       }
        bw.write(rooms.size()+"");

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
