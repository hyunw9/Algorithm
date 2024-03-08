package prgmrs.StackQueue;

import java.util.ArrayDeque;

public class 프로세스2_42587 {


  class Solution {

    private static int i = 0;

    public static int getMaxIdx(ArrayDeque<Integer> dq, int[] pri) {

      for (int v : dq) {
        // System.out.println("dq: " + dq);

        if (pri[i] < pri[v]) {
          i = v;
        } else if (pri[i] >= pri[v]) {
          continue;
        }
      }
      return i;
    }

    public int solution(int[] priorities, int location) {
      int answer = 0;
      ArrayDeque<Integer> dq = new ArrayDeque<>();
      for (int i = 0; i < priorities.length; i++) {
        dq.addLast(i);
      }
      int i = getMaxIdx(dq, priorities);
      //순서
      int seq = 1;

      while (!dq.isEmpty()) {
        int maxIdx = getMaxIdx(dq, priorities);
        //    System.out.println("maxIDX: " + maxIdx);
        int nowIdx = dq.pollFirst();
        //  System.out.println("nowIDX: " + nowIdx);

        // System.out.println("nowIDX: " + nowIdx);

        if (nowIdx == maxIdx) {
          if (location == nowIdx) {
            break;
          }
          priorities[nowIdx] = -1;
          // System.out.println("nowIDX: " + nowIdx);
          // System.out.println("seq: " + seq);

          seq++;

        } else {
          dq.addLast(nowIdx);
        }

      }

      return seq;
    }
  }

}
