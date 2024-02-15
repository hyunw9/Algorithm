package prgmrs.Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 부대복귀_132266 {

  public int[] solution(int n, int[][] roads, int[] sources, int destination) {
    int[] answer = new int[sources.length];
    ArrayList<Integer>[] arr = new ArrayList[n+1];
    for(int i = 1; i <=n; i++){
      arr[i] = new ArrayList<>();
    }
    for(int i = 0; i<roads.length; i++){
      int start = roads[i][0];
      int end= roads[i][1];
      arr[start].add(end);
      arr[end].add(start);
    }
    int[] dist = new int[n+1];

    Arrays.fill(dist,987654321);
    dist[destination] = 0;
    Queue<Integer> q = new LinkedList<>() ;
    q.add(destination);

    while(!q.isEmpty()){
      int now = q.poll();

      for(int a : arr[now]){

        if(dist[a] > dist[now]+1){
          dist[a] = dist[now]+1;
          q.add(a);
        }

      }

    }

    for(int i=0;i<sources.length; i++){
      if(dist[sources[i]]==987654321){
        answer[i]= -1;
      }else
        answer[i] = dist[sources[i]];
    }


    return answer;
  }

}
