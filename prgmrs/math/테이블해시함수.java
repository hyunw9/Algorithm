package prgmrs.math;

import java.util.*;

public class 테이블해시함수 {

  class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
      int answer = 0;
      ArrayList<int[]> arr = new ArrayList<>();
      for (int[] l : data) {
        arr.add(l);
      }
      Collections.sort(
          arr,
          (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
              return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
          });
      int ans = 0;
      for (int i = row_begin; i <= row_end; i++) {
        int[] curr = arr.get(i - 1);

        int cnt = 0;
        for (int val : curr) {
          cnt += (val % i);
        }
        ans = ans ^ cnt;
      }
      return ans;
    }
  }
}
