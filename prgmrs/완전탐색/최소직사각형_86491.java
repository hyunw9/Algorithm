package prgmrs.완전탐색;

import java.util.Arrays;

public class 최소직사각형_86491 {

  public int solution(int[][] sizes) {
    int answer = 0;
    for(int i = 0 ; i < sizes.length; i++){
      Arrays.sort(sizes[i]);
    }
    int ga = 0;
    int se = 0;
    for(int i = 0; i < sizes.length; i++){
      ga = Math.max(sizes[i][0],ga);
      se = Math.max(sizes[i][1],se);
    }
    return ga*se;
  }

}
