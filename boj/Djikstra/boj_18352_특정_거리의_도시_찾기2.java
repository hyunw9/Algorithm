package boj.Djikstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_18352_특정_거리의_도시_찾기2 {
     public static class Node{
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    static int N ;
    static int M ;
    static int K ;
    static int start;

    static boolean []visited;
    static int []dist ;
    static ArrayList<Node>[] adjlist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        visited= new boolean[N+1];
        dist = new int[N+1];                                                        //거리 정보 저장 배열
        adjlist = new ArrayList[N + 1];                                             //인접리스트
        StringBuilder sb=  new StringBuilder();
        for (int i = 1; i < N +1; i++) {
            adjlist[i] = new ArrayList<>();
        }
        //인접리스트에 값 추가
        for (int i = 1; i < M+1; i++) {
            st=new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjlist[from].add(new Node(to,1));
        }
        djikstra(start);
        for (int i = 0; i < dist.length; i++) {
            if(dist[i]==K){
                sb.append(i).append("\n");
            }
        }
        if(sb.length()==0) {
            sb.append(-1);
        }
        System.out.println(sb);

    }
    static void djikstra(int start){
        Arrays.fill(dist,987654321);                                                            //초기화
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost,o2.cost));//cost 기준 오름차순 정렬
        dist[start] = 0;
        pq.add(new Node(start,dist[start]));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.end]) continue;
            visited[now.end] = true;
            for (Node next :adjlist[now.end]) {                                                      //현재값,다음값이 현재 저장된 다음 거리 값보다 적다면 값 갱신 후 큐 추가
                if(dist[next.end]>now.cost+next.cost ){
                    dist[next.end] = now.cost+next.cost;
                    pq.add(new Node(next.end,dist[next.end]));
                }

            }
        }
    }
}
