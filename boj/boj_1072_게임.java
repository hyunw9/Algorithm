package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1072_게임 {
    static ArrayList<Node>[] adjlist;
    static int [] dist ;
    static boolean[] visited;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost,o2.cost));
    public static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        adjlist= new ArrayList[V+1];
        dist = new int[V+1];
        visited = new boolean[V+1];
        for (int i = 0; i < V+1; i++) {
            adjlist[i]= new ArrayList<>();

        }

        for (int i = 0; i < E; i++) {
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjlist[u].add(new Node(v,w));
        }
        djikstra(start);
        StringBuilder sb= new StringBuilder();
        for (int i = 1; i <=V ; i++) {
            if(dist[i]==987654321){
                sb.append("INF\n");
            }else{
                sb.append(dist[i]+"\n");
            }
        }
        System.out.println("sb = " + sb);
    }
    public static void djikstra(int start){
        Arrays.fill(dist,987654321);
        dist[start]=0;
        pq.add(new Node(start,0));

        while (!pq.isEmpty()){

            Node now = pq.poll();

            if(visited[now.end]) continue;
            visited[now.end]= true;

            for (Node next : adjlist[now.end]) {
                if(dist[next.end]>now.cost+next.cost){
                    dist[next.end] = now.cost+next.cost;
                    pq.add(new Node(next.end,dist[next.end]));
                }

            }

        }
    }
}
