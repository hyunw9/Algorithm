package prgmrs.StackQueue;

import java.util.ArrayDeque;

public class 같은숫자는싫어_12906 {

  public int[] solution(int []arr) {
    ArrayDeque<Integer> dq = new ArrayDeque<>();

    for(int i = 0 ; i < arr.length ; i++){

      if(dq.isEmpty()){
        dq.addFirst(arr[i]);
      }else{
        if(dq.peek() == arr[i]){
          continue;
        }else{
          dq.addFirst(arr[i]);
        }

      }
    }
    int[] answer=  new int[dq.size()];
    int i = 0;
    while(!dq.isEmpty()){
      answer[i] = dq.pollLast();
      i++;
    }
    return answer;
  }

}
