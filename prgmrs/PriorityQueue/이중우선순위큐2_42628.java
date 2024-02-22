package prgmrs.PriorityQueue;

import java.util.PriorityQueue;

public class 이중우선순위큐2_42628 {

  public int[] solution(String[] operations) {
    int[] answer = new int[2];
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer>max = new PriorityQueue<>((o1,o2)->o2-o1);

    for(String ops : operations){
      String op = ops.split(" ")[0];
      int num= Integer.parseInt(ops.split(" ")[1]);

      if(op.equals("I")){
        min.add(num);
        max.add(num);
      }else{
        if(num==-1){
          if(!min.isEmpty()&&!max.isEmpty()){
            int key = min.poll();
            delete(max,key);
          }
          //최소값 삭제,
          //int key = min poll;
          //delete max(key);
        }else {
          if(!min.isEmpty()&&!max.isEmpty()){
            int key = max.poll();
            delete(min,key);
          }
          //최대값 삭제,
          //int key = max poll();
          //delete min(key);
        }
        // 333 45 -45
        //  -45 45 333
      }
    }

    if(min.isEmpty()||max.isEmpty()){
      answer[0] = 0;
      answer[1] = 0;
    }else{
      answer[0] = max.poll();
      answer[1] = min.poll();
    }
    return answer;
  }
  public void delete(PriorityQueue<Integer> pq, int key){
    for(int v : pq){
      if(v == key){
        pq.remove(v);
        return;
      }
    }
  }

}
