package prgmrs.BFSDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 네트워크2_43162 {

  public int solution(int n, int[][] computers) {
    int answer = 0;
    ArrayList<Integer> []arr = new ArrayList[n+1];
    boolean []used =new boolean[n+1];

    for(int i = 0 ; i <=n; i++){
      arr[i] = new ArrayList<>();
    }
    for(int i = 0;i<computers.length; i++){
      int[] now = computers[i];
      for(int j = 0 ; j <n; j++){
        if(i==j) continue;
        if(computers[i][j]==1){
          arr[i+1].add(j+1);
          arr[j+1].add(i+1);
        }
      }
    }
    Queue<Integer> q = new LinkedList<>();

    for(int i =1; i<=n; i++){
      if(!used[i]){
        answer++;
        used[i] = true;
        q.add(i);
      }

      while(!q.isEmpty()){

        int now = q.poll();
        for(int next : arr[now]){
          if(!used[next]){
            used[next]=true;
            q.add(next);
          }
        }
      }
    }
    return answer;
  }

}
