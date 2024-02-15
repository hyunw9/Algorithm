package prgmrs.PriorityQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 운영체제_121686 {

  public long[] solution(int[][] program) {
    long[] answer = new long[11];
    Arrays.sort(program,(o1,o2)->{
      if(o1[1]==o2[1])
        return o1[0]-o2[0];
      return o1[1]-o2[1];
    });
    //System.out.println(Arrays.deepToString(program));
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
      if(o1[0]==o2[0]){
        return o1[1]-o2[1];
      }
      return o1[0]-o2[0];
    });
    Queue<int[]> q = new LinkedList<>();
    for(int i = 0 ; i <program.length; i++){
      q.add(program[i]);
    }
    int cut = 0;
    pq.add(q.poll());

    while(!q.isEmpty() || !pq.isEmpty()){
      int[] now = pq.poll();
      int pri = now[0];
      int start = now[1];
      int takes = now[2];

      //첫 start 가 0이 아닐 수도 있으므로, max 로 계산
      cut = Math.max(cut+takes,start+takes);
      //대기시간도 계산
      answer[pri] += cut - start - takes;

      //현재 cut보다 낮은 프로세스 모두 Pq에 삽입
      while(!q.isEmpty() && q.peek()[1]<=cut){
        pq.add(q.poll());
      }
      if(!q.isEmpty() && pq.isEmpty()){
        pq.add(q.poll());
      }
      //큐가 차있고, pq 가 비어있을 때, 스케쥴이 cut 보다 커서 pq에 삽입이 안된상태 .
      //강제로 pq에 넣어버린다. 그래야 우선순위, 시간순으로 정렬할 수 있음.


    }
    answer[0] = cut;


    return answer;
  }

}
