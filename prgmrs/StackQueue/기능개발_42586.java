package prgmrs.StackQueue;

import java.util.*;

public class 기능개발_42586 {


  class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
      int[] temp = new int [100];
      int day =0;
      for(int i = 0; i<progresses.length; i++){

        while(progresses[i]+(speeds[i]*day)<100){
          day++;
        }
        temp[day]++;


      }
      int cnt = 0;
      for(int i = 0 ; i < temp.length ; i++){
        if(temp[i]!=0){
          cnt++;
        }
      }
      int[] answer = new int[cnt];
      int idx = 0;
      for(int i = 0 ;i<temp.length;i++){
        if(temp[i]!=0){
          answer[idx]= temp[i];
          idx++;
        }
      }
      return answer;
    }


  }
//유형에 국한되어 생각하지 말 것
  // 다양한 풀이법 생각 필요


}
