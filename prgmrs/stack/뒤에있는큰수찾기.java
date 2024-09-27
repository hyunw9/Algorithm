package prgmrs.stack;

import java.util.*;

public class 뒤에있는큰수찾기 {

  class Solution {
    public int[] solution(int[] numbers) {
      int[] answer = new int[numbers.length];

      Stack<Integer> stack = new Stack<>();
      int n = numbers.length;
      // answer[numbers.length-1] = -1;
      // stack.push(numbers[n-1]);

      for (int i = n - 1; i >= 0; i--) {

        // 나보다 클때까지 pop();
        if (!stack.isEmpty()) {
          while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
            stack.pop();
          }
        }

        if (stack.isEmpty()) {
          answer[i] = -1;

        } else {
          answer[i] = stack.peek();
        }

        stack.push(numbers[i]);
      }

      // System.out.println(Arrays.toString(answer));
      return answer;
    }
  }
}
