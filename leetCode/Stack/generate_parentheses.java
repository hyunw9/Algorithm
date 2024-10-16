package leetCode.Stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class generate_parentheses {
  private static List<String> list;
  private static char[] g = {'(', ')'};
  private static Set<String> set;

  public List<String> generateParenthesis(int n) {
    Stack<Character> stack = new Stack<>();
    list = new ArrayList<>();
    set = new HashSet<>();
    dfs(n, stack, 0, 0, 0);

    return list;
  }

  public void dfs(int n, Stack<Character> stack, int open, int close, int cnt) {

    if (open == close && open == n) {
      StringBuilder sb = new StringBuilder();
      for (char c : stack) {
        sb.append(c);
      }
      String curr = sb.toString();
      list.add(curr);

      return;
    }

    if (open < n) {
      stack.push('(');
      dfs(n, stack, open + 1, close, cnt);
      stack.pop();
    }
    if (close < open) {
      stack.push(')');
      dfs(n, stack, open, close + 1, cnt);
      stack.pop();
    }
  }
}
