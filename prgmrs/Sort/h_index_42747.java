package prgmrs.Sort;

import java.util.Arrays;

public class h_index_42747 {

  public int solution(int[] citations) {
    int answer = 0;
    //5편중, 3편이상 인용된 논문이 3편이상이고, 나머지 논문이 H 편 이하로 인용되었다면 , H의 최댓값임
    //6 5 3 1 0
    // 5,4,3,2,1 중임.
    //5일때,  5편 이상이 2, 아래가 3,
    //4일때, 4편이상이 2, 아래가 3,
    //3일때, 3편이상이 3, 아래가 3,
    int max = citations.length;
    Arrays.sort(citations);
    // if(citations.length ==1 && citations[0]==0) return 0;
    while(max>=-1){

      int over = 0;
      int lower = 0;
      for(int v : citations){
        if(v>=max) over++;
        if(v<=max) lower++;
      }
      if(over>=max&&lower<=max){
        break;
      }
      max--;
    }

    if(max<0) return 0;
    return max;
  }

}
