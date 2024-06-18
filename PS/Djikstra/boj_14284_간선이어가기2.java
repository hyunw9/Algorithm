package PS.Djikstra;

import java.io.*;
import java.util.*;
public class boj_14284_간선이어가기2 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int min;
    private static ArrayList<int[]>[] arr;
    private static int[]cost ;
    

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        cost = new int[n+1];
        Arrays.fill(cost,987654321);
        arr= new ArrayList[n+1];
        for(int i = 0 ; i <=n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[from].add(new int[]{to,c});
            arr[to].add(new int[]{from,c});

        }
        st= new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        cost[start] = 0;
        pq.add(new int[]{start,0});


        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int curr = now[0];
            int c = now[1];
            // if(curr ==dest){                                             
            //     break;
            // }

            for(int[] next :arr[curr]){
                if(cost[next[0]] >c+next[1]){
                    cost[next[0]] = c+next[1];
                    pq.add(new int[]{next[0], cost[next[0]]});
                }
            }
        }
        System.out.println(cost[dest]);
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