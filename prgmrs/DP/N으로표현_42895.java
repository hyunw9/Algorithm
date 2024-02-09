package prgmrs.DP;

import java.util.HashSet;
import java.util.Set;

public class N으로표현_42895 {

  class Solution {
    // N = 5
    // 1 = 5
    // 2 = 55 , 5-5, 5+5 5/5 5*5  //4 +1
    // 3 = 555 5+ (5-5,5+5,5/5,5*5) , 5- (5-5,5+5,5/5,5*5), 5 * (5-5,5+5,5/5,5*5), 5/(5-5,5+5,5/5,5*5)   16 + 1
    // 4 = 5555 +
    public int solution(int N, int number) {
      int answer = 0;
      Set<Integer>[] set  = new HashSet[10];
      for(int i = 0; i <= 9 ;i++){
        set[i] = new HashSet<>();
      }

      for(int i = 1; i <=8; i++){
        String a = "";
        for(int j = 1; j <= i ; j++){
          a+=N;
        }
        set[i].add(Integer.parseInt(a));

        for(int j = 1; j<i; j++){
          int k = i - j ;
          for(int num1 :set[j]){
            for(int num2 : set[k]){
              set[i].add(num1+num2);
              set[i].add(num1-num2);
              set[i].add(num1*num2);
              if(num1!=0 && num2!= 0)
                set[i].add(num1/num2);

            }
          }
        }

      }
      // for(int i =1; i <=8; i++){
      //     for(int v : set[i]){
      //         System.out.println(v);
      //     }
      // }
      for(int i = 1; i <=8; i++){
        if(set[i].contains(number)){
          return i;
        }
      }
      return -1;
    }
  }

}
