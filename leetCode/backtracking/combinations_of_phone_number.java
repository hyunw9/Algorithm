package leetCode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class combinations_of_phone_number {
  class Solution {

    static HashMap<Integer, String> map;

    public List<String> letterCombinations(String digits) {
      List<String> answer = new ArrayList<>();
      map = new HashMap<>();

      if (digits.isEmpty()) {
        return answer;
      }

      map.put(2, "abc");
      map.put(3, "def");
      map.put(4, "ghi");
      map.put(5, "jkl");
      map.put(6, "mno");
      map.put(7, "pqrs");
      map.put(8, "tuv");
      map.put(9, "wxyz");
      int n = digits.length();

      bt(answer, n, new StringBuilder(), 0, 0, digits);
      return answer;
    }

    public static void bt(
        List<String> ans, int n, StringBuilder sb, int depth, int idx, String digits) {
      // System.out.println(sb.toString());

      if (depth >= n) {
        ans.add(sb.toString());
        return;
      }
      String line = map.get(digits.charAt(depth) - '0');
      for (int i = 0; i < line.length(); i++) {
        sb.append(line.charAt(i));
        bt(ans, n, sb, depth + 1, i + 1, digits);
        sb.delete(sb.length() - 1, sb.length());
      }
    }
  }
}
