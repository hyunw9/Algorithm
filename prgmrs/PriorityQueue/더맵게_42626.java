package prgmrs.PriorityQueue;

import java.util.PriorityQueue;

public class 더맵게_42626 {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o1-o2);
    //ArrayList<Integer> check = new ArrayList<>();

    for(int i = 0 ; i < scoville.length; i++){
      pq.add(scoville[i]);
    }
    int i = 0;
    while(i<scoville.length){

      int now = pq.poll();

      if(now>=K) {
        pq.add(now);

      }
      else{
        if(pq.isEmpty()) return -1;
        else{
          int next = pq.poll();
          now = now + (2*next);
          pq.add(now);
          answer++;
        }
      }
      i++;
    }

    return answer;
  }
}
