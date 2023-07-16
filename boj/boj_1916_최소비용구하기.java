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
        //도시 개수
        N = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        //버스 개수
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];                               //방문 배열
        dist = new int[N + 1];                                      //거리 저장 배열
        adjlist = new ArrayList[N + 1];                             //인접리스트

        //인접리스트 생성
        for (int i = 0; i < adjlist.length; i++) {
            adjlist[i] = new ArrayList<>();
        }
        //인접리스트 초기화
        for (int i = 1; i <= M; i++) {
            st= new StringTokenizer(br.readLine());
            int beginning = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjlist[beginning].add(new Node(dest,cost));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());                   //시작점
        int dest = Integer.parseInt(st.nextToken());                    //도착점
        //다익스트라 시작
        dijkstra(start);

        //함수 시작 후 도착지 출력
        System.out.println(dist[dest]);



    }
    public static void dijkstra(int start){
        Arrays.fill(dist,987654321);                        //INF 값 모두 삽입
        dist[start]= 0;                                         // 시작부의 비용은 0
        pq=new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost,o2.cost));
        pq.add(new Node(start,dist[start]));                 //cost 순으로 정렬된 우선순위 큐에 삽입
        while(!pq.isEmpty()){
            Node now = pq.poll();                           //가장 높은 우선순위의 노드를 가져와서
            if(visited[now.end]) continue;                  //방문되었다면 넘기고
            visited[now.end] = true;
            for (Node next : adjlist[now.end]) {            //가져온 노드의 인접리스트의 노드를 순회하며
                if(dist[next.end]>now.cost+next.cost){      //그 노드의 다음 행선지의 값이 현재 노드의 값과 가져온 노드의 값보다 크다면
                    dist[next.end]=now.cost+next.cost;      //다음 행선지의 비용을 현재값+ 다음 값으로 갱신
                    pq.add(new Node(next.end,dist[next.end])); //후 PQ에 추가
                }
            }
        }
    }
}
