package leetCode.backtracking;

import java.util.*;

public class permutation_string {

  class Solution {

    private static Set<String> set;
    private static boolean[] used;

    public boolean checkInclusion(String s1, String s2) {
      set = new HashSet<>();
      used = new boolean[s1.length()];
      if (s2.contains(s1)) return true;

      for (int i = 0; i < s1.length() * s1.length(); i++) {
        s1 = nextPermutation(s1.length(), s1.toCharArray(), s2);
        // System.out.println(s1);

        if (s2.contains(s1)) return true;
      }

      return false;
    }

    public String nextPermutation(int n, char[] before, String target) {
      int bigIdx = -1;
      StringBuilder sb = new StringBuilder();
      for (int i = n - 1; i > 0; i--) {
        if (before[i - 1] < before[i]) {
          bigIdx = i - 1;
          break;
        }
      }
      if (bigIdx == -1) {
        for (char val : before) {
          sb.append(val);
        }
        return sb.toString();
      }
      ;

      char maxVal = before[bigIdx];
      int offset = -1;
      for (int i = n - 1; i > bigIdx; i--) {

        if (before[bigIdx] < before[i]) {
          offset = i;
          break;
        }
      }

      char val = before[bigIdx];
      before[bigIdx] = before[offset];
      before[offset] = val;

      Arrays.sort(before, bigIdx + 1, n);

      for (char a : before) {
        sb.append(a);
      }

      return sb.toString();
    }
  }
}
