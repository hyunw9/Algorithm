package prgmrs.Greedy;

import java.util.Arrays;

public class 체육복_42862 {

  public int solution(int n, int[] lost, int[] reserve) {
    int answer = n-lost.length;
    Arrays.sort(lost);
    Arrays.sort(reserve);

    for(int i = 0 ; i < lost.length ; i++){

      for(int j = 0 ; j < reserve.length ;j++){

        if(reserve[j] == lost[i]){
          answer++;
          reserve[j] = -1;
          lost[i]= -1;
          break;
        }
      }
    }
    for(int i = 0 ; i < lost.length ; i++){
      for(int j = 0 ; j < reserve.length ;j++){
        if(lost[i]+1 == reserve[j] || lost[i]-1 ==reserve[j]){
          //lost[i] = -1;
          reserve[j]=-1;
          answer++;
          break;
        }
      }
    }
    return answer;
  }

}
