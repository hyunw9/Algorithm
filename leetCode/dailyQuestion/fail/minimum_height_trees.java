package leetCode.dailyQuestion.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class minimum_height_trees {

  private static int[] arr ;
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    //minumum height 인 Root Node를 출력하면 됌. 어느 ROOT 노드가 MHT 인가 ? ? ? ? ? ??
    List<Integer> mht = new ArrayList<>();
    int[] result = new int[n];
    int[] cost = new int[n];
    //접근 1 unionfind  -> X
    //접근 2 인접리스트 ㅇㅇ
    //접근 3 다익스트라 ㅇㅇ -> 실패
    ArrayList<Integer>[]adj  = new ArrayList[n];
    for(int i= 0 ; i < n ; i++){
      adj[i]= new ArrayList<>();
    }
    //인접리스트 생성
    for(int[] curr : edges){
      adj[curr[0]].add(curr[1]);
      adj[curr[1]].add(curr[0]);
    }

    Queue<int[]> q = new LinkedList<>();
    for(int i = 0 ; i < n ; i++){
      Arrays.fill(cost,Integer.MAX_VALUE);
      cost[i] = 0;
      q.add(new int[]{i,0});

      while(!q.isEmpty()){
        int[] now = q.poll();
        int num = now[0];
        int c = now[1];

        for(int nxt : adj[num]){
          if(cost[nxt]> cost[num]+1){
            cost[nxt]= cost[num]+1;
            q.add(new int[]{nxt,c+1});
          }
        }
      }

      int min = 0;
      for(int j = 0 ; j< n ; j++){
        if (j == i ) continue;
        min = Math.max(min,cost[j]);
      }
      result[i] = min;
    }

    int min = Integer.MAX_VALUE;
    for(int i = 0 ; i < n ; i++){
      min = Math.min(min,result[i]);
    }

    for(int i = 0 ; i < n ; i++){
      if(result[i]==min){
        mht.add(i);
      }
    }
    return mht;
  }


}
