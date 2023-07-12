package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1916_최소비용구하기 {
    public static class Node{
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        int end;
        int cost;
    }
    static int N;
    static int M;
    static boolean[] visited;
    static int[] dist;
    static ArrayList<Node>[] adjlist;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        adjlist = new ArrayList[N + 1];
        for (int i = 0; i < adjlist.length; i++) {
            adjlist[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            st= new StringTokenizer(br.readLine());
            int beginning = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjlist[beginning].add(new Node(dest,cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());
        dijkstra(start);
        /*for (int i = 1; i <= adjlist.length; i++) {
            for (int j =0; j < adjlist[i].size(); j++) {
                System.out.println(adjlist[i].get(j).end+" "+adjlist[i].get(j).cost);
            }
        }*/
        System.out.println(dist[dest]);


    }
    public static void dijkstra(int start){
        Arrays.fill(dist,987654321);
        dist[start]= 0;
        pq=new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost,o2.cost));
        pq.add(new Node(start,dist[start]));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.end]) continue;
            visited[now.end] = true;
            for (Node next : adjlist[now.end]) {
                if(dist[next.end]>now.cost+next.cost){
                    dist[next.end]=now.cost+next.cost;
                    pq.add(new Node(next.end,dist[next.end]));
                }
            }
        }
    }
}
