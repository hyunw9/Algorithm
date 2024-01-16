package prgmrs.StackQueue;

public class 프로세스_422587 {

  import java.util.*;

  class Solution { // location 은 2가 몇번쨰로 실행되는지 알기 위한 매개변수, 2,1,3,2 에서 3는 1번쨰, 1,1,9,1,1,1 에서 1은 5번째.

    public int solution(int[] priorities, int location) {
      int answer = 0;
      int curr = 0;
      int max = 0;
      for ( int i = 0 ; i < priorities.length ; i ++){
        if (priorities[i]>max) max=  priorities[i];
      }
      while(answer < priorities.length){

        if(priorities[curr] == max){
          answer ++;
          System.out.println("priorities[curr] " + priorities[curr]);
          System.out.println("curr "+ curr);

          if(curr==location) {
            break;
          }

          priorities[curr] = 0;
          max = 0;
          for(int i = 0; i < priorities.length; i ++){
            max= Math.max(max,priorities[i]);
          }


        }
        curr++;
        if(curr == priorities.length) curr = 0;
      }

      return answer;
    }

  }


}
