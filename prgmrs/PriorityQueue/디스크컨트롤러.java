package prgmrs.PriorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 디스크컨트롤러 {

  public int solution(int[][] jobs) {
    int answer = 0;
    //shortest job first
    //[요청시간 , 소요시간]
    Arrays.sort(jobs,(o1,o2)->{ //일찍 요청순
      if(o1[0]==o2[0])
        return o1[1]-o2[1];
      return o1[0]-o2[0];
    });

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
      if(o1[1]==o2[1])
        return o1[0]-o2[0];
      return o1[1]-o2[1];
    });

    Queue<int[]> q = new LinkedList<>();
    for(int[] p : jobs){
      q.add(p);
    }
    pq.add(q.poll());
    int cut = 0;
    ArrayList<Integer> arr = new ArrayList<>();

    while(!q.isEmpty()||!pq.isEmpty()){

      int[] now = pq.poll();
      int start = now[0];
      int dur = now[1];

      cut = Math.max(cut+dur,start+dur);
      //System.out.println("");
      //System.out.println("cut: "+ cut +" start: "+ start) ;
      arr.add(cut-start);

      while(!q.isEmpty() && q.peek()[0]<=cut){
        pq.add(q.poll());
      }
      //pq 비고 큐 남아있을 떄
      if(pq.isEmpty()&&!q.isEmpty()){
        pq.add(q.poll());
      }

    }
    int sum = 0;
    for(int a : arr){
      sum +=a;
    }
    return sum / jobs.length;

  }

}
