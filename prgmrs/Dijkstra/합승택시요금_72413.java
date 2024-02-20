package prgmrs.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 합승택시요금_72413 {

  public class Node{
    int num;
    int cost;

    public Node(int num,int cost){
      this.num = num;
      this.cost=  cost;
    }
  }
  private static ArrayList<Node>[] adj;

  public int solution(int n, int s, int a, int b, int[][] fares) {
    int answer = 987654321;
    //크루스칼 이용해서 MST를 만든 후에,
    int [] arr= new int[n+1];
    adj = new ArrayList[n+1];
    for(int i = 1; i <= n ; i++){
      adj[i] = new ArrayList<>();
    }
    for(int i =0; i <fares.length; i++){
      int[] now = fares[i];
      int start = now[0];
      int end = now[1];

      adj[start].add(new Node(end,now[2]));
      adj[end].add(new Node(start,now[2]));
    }
    int[] costA = djikstra(n,a);
    int[]costB = djikstra(n,b);
    int[] costC = djikstra(n,s);


    for(int i = 1; i <=n ; i++){
      answer = Math.min ( answer, costA[i]+costB[i]+costC[i]);
    }

    return answer;
  }
  public int[] djikstra(int n,int start ){
    int[] cost = new int[n+1];
    PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
    Arrays.fill(cost,20000001);
    cost[start] = 0;
    pq.add(new Node(start,0));
    while(!pq.isEmpty()){

      Node now = pq.poll();

      for(Node nxt : adj[now.num]){
        if(cost[nxt.num]> cost[now.num]+nxt.cost){
          cost[nxt.num] = cost[now.num] + nxt.cost;
          pq.add(new Node(nxt.num,cost[nxt.num]));

        }
      }
    }
    return cost;

  }

}
