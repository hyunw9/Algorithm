package prgmrs.Greedy;

import java.util.Arrays;

public class 단속카메라_42884 {

  public int solution(int[][] routes) {
    int answer = 0;
    Arrays.sort(routes,(o1,o2)->{
      if(o1[1]==o2[1])
        return o1[0]-o2[0];
      return o1[1]-o2[1];
    });
    int cut = -30001;
    int end = -30001;
    System.out.println(Arrays.deepToString(routes));
    for(int[] r : routes){

      if(r[0]>cut){
        cut = r[1];
        end = r[1];
        answer++;
      }
      else if(r[0]<=cut && cut<=r[1]){ //얘도 포함임
        end = r[1];
      }
    }
    return answer;
  }

}
