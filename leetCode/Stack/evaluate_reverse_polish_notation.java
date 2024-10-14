package leetCode.Stack;

import java.util.*;

public class evaluate_reverse_polish_notation {
  public int evalRPN(String[] tokens) {
    ArrayDeque<Integer> dq = new ArrayDeque<>();

    for (int i = 0; i < tokens.length; i++) {
      String curr = tokens[i];

      if (Character.isDigit(curr.charAt(curr.length() - 1))) {
        dq.addLast(Integer.parseInt(curr));
      } else {

        int f = dq.pollLast();
        int s = dq.pollLast();

        if (curr.equals("+")) {
          dq.addLast(f + s);
        } else if (curr.equals("-")) {
          dq.addLast(s - f);
        } else if (curr.equals("*")) {
          dq.addLast(f * s);

        } else if (curr.equals("/")) {
          dq.addLast(s / f);
        }
      }
      // System.out.println(dq);
    }
    return dq.pollFirst();
  }
}
