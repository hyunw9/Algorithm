package prgmrs.Graph;
import java.util.*;

public class 가장먼노드_49189 {

  public int solution(int n, int[][] edge) {
    int answer = 0;
    int [] cost = new int[n+1];
    boolean[] used = new boolean[n+1];
    ArrayList<Integer>[] adj = new ArrayList[n+1];
    for(int i = 1;i<=n;i++){
      adj[i] = new ArrayList<>();
    }
    for(int i = 0; i<edge.length;i++){
      int start = edge[i][0];
      int end = edge[i][1];
      adj[start].add(end);
      adj[end].add(start);
    }
    Queue<Integer> q= new LinkedList<>();
    used[1] = true;
    cost[1] = 0;
    q.add(1);
    int max = 0;
    while(!q.isEmpty()){
      int now = q.poll();

      for(int a : adj[now]){
        if(!used[a]){
          used[a] = true;
          cost[a] = cost[now]+1;
          if(cost[a]>max) max = cost[a];
          q.add(a);
        }
      }
    }

    for(int a : cost){
      if(a==max) answer++;
    }
    return answer;
  }

}
