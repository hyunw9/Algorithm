package prgmrs.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 배달_12978 {

  public class Node{
    int num;
    int cost;
    public Node(int num, int cost){
      this.num = num;
      this.cost = cost;
    }
  }
  public int solution(int N, int[][] road, int K) {
    int answer = 0;

    ArrayList<Node>[] arr = new ArrayList[N+1];
    for(int i = 1; i<=N;i++){
      arr[i] = new ArrayList<>();
    }
    int dist[] = new int[N+1];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[1]= 0;
    for(int i = 0 ; i<road.length;i++){
      int start = road[i][0];
      int end = road[i][1];
      int cost  = road[i][2];

      arr[start].add(new Node(end,cost));
      arr[end].add(new Node(start,cost));
    }
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(1,0));
    while(!q.isEmpty()){
      Node now = q.poll();

      for(Node a : arr[now.num]){
        if(dist[a.num] > dist[now.num]+a.cost){
          dist[a.num] = dist[now.num]+a.cost;
          q.add(a);

        }

      }
    }

    for(int i =1  ; i <= N;i++){
      if(dist[i]<=K) answer++;
    }

    // System.out.println(Arrays.toString(dist));
    return answer;
  }

}
