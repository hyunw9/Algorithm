package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1753_최단경로 {

    //cost 기준으로 오름차순 정렬
    static PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.cost,o2.cost)));
    static boolean[] visited ;                                                          //방문 저장 배열
    static int [] dist;                                                                 //거리 정보 저장 배열
    static ArrayList<Node>[] adjlist ;                                                  //인접리스트. 각 []안에는 ArrayList<Node> 로 이루어짐
    private static final int INF = 987654321;                                           //무한대 값

    //받는 정보에는 (u,v,w)고, u는 인덱스로 구분, v,w 를 저장해줄 클래스 입니다.
    public static class Node{
        //생성자
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
        int end;
        int cost;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //변수 입력
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        //초기화
        dist = new int[V+1];
        visited = new boolean[V+1];
        adjlist = new ArrayList[V+1];

        for (int i = 0; i < V+1; i++) {
            adjlist[i] = new ArrayList<>();
        }
        //각 줄을 돌며 해당하는 인덱스에 값을 추가하며 인접리스트 생성
        for (int i = 0; i < E; i++) {
            st= new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjlist[u].add(new Node(v,w));
        }


        dijkstra(start);
        StringBuilder sb= new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if(dist[i]==INF){
                sb.append("INF\n");
            }else{
                sb.append(dist[i]+"\n");

            }
        }
        System.out.println(sb);

    }
    private static void dijkstra(int start){

        //거리 배열 모두 INF로 초기화
        Arrays.fill(dist,INF);
        //시작 거리는 0이므로 0값 입력
        dist[start]=0;
        //우선순위 큐에 값 추가, Node는 (end, cost)로 이루어짐, 처음 start는 1
        pq.add(new Node(start,0));
        //우선순위 큐에 데이터가 없을 때 까지 반복
        while(!pq.isEmpty()){
            //pq는 iteration이 불가능, poll로 뽑아줘야 함
            Node now = pq.poll();
            //다음 노드가 방문했으면 건너뛰기
            if(visited[now.end]) continue;
            //아니라면 true로 변경
            visited[now.end]= true;

            //도달 가능한 노드들을 순회
            for (Node next : adjlist[now.end]) {
                //만약 현재 비용+ 다음 정점의 비용이 갖고있는 다음 정점까지 거리보다 작다면 갱신
                if(dist[next.end]>now.cost+ next.cost ){
                    dist[next.end]= now.cost+next.cost;
                    pq.add(new Node(next.end,dist[next.end]));
                }
            }
        }
    }

    
}
