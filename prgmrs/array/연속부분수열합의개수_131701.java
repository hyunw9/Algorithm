package prgmrs.array;

import java.util.Set;

public class 연속부분수열합의개수_131701 {

  private static Set<Integer> set ;

  public int solution(int[] elements) {
    set=  new HashSet<>();
    int answer = 0;
    for(int k = 1;  k <= elements.length ; k++){
      for(int i = 0 ; i < elements.length ; i++){
        int sum = 0;
        for(int j=i; j<k+i; j++){
          sum+=elements[j%elements.length];
        }
        set.add(sum);

      }
    }
    return set.size();
  }

}
