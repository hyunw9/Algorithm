package prgmrs.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중우선순위큐_42628 {

  static PriorityQueue<Integer> max = new PriorityQueue(Comparator.reverseOrder());
  static PriorityQueue<Integer>min = new PriorityQueue<>((o1,o2)->o1-o2);

  public int[] solution(String[] operations) {
    int[] answer = new int[2];
    answer[0] = 0;
    answer[1] = 0;


    for(int i = 0 ; i < operations.length; i++){
      String ops = operations[i].split(" ")[0];
      int num = Integer.parseInt(operations[i].split(" ")[1]);
      if(ops.equals("I")){
        max.add(num);
        min.add(num);
      }else if(ops.equals("D")&&!min.isEmpty()&&!max.isEmpty()){
        if(num == 1){
          int t = max.poll();
          min.remove(t);

        }else if(num == -1){
          int  t = min.poll();
          max.remove(t);
        }
        // remove(num);
      }
    }
    System.out.println(min);
    System.out.println(max);

    if(min.size()>0){
      answer[0] = max.poll();
      answer[1] = min.poll();
    }
    return answer;
  }
// PriorityQueue.remove () 를 통해 직접 구현하지 않아도 된다.

//  public void remove( int ops){
//    if(ops == 1){
//      //최대값을 지우는 연산이므로 min에서 최대값을 지워야함
//      int i = 0;
//      for(int val : min){
//        if(i<val){
//          i = val;
//        }
//      }
//      min.remove(i);
//    }else if (ops == -1){
//      //최소값을 지워야 하므로 Max 에서 최소값을 지워야함
//      int i = Integer.MAX_VALUE;
//      for(int val : max){
//        if(i>val){
//          i = val;
//        }
//      }
//      max.remove(i);
//    }
//  }


}
