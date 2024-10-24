package leetCode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class palindrome_partitioning {
  class Solution {
    public List<List<String>> partition(String s) {
      List<List<String>> ans = new ArrayList<>();
      dfs(ans, s, new ArrayList<>(), s.length(), 0);
      return ans;
    }

    public static void dfs(
        List<List<String>> ans, String s, ArrayList<String> arr, int t, int idx) {
      // System.out.println(curr);
      if (idx >= t) {
        ans.add(new ArrayList<>(arr));
        return;
      }

      for (int i = idx; i < t; i++) {

        if (isPalindrome(idx, i, s)) {
          arr.add(s.substring(idx, i + 1));
          dfs(ans, s, arr, t, i + 1);
          arr.remove(arr.size() - 1);
        }
      }
    }

    public static boolean isPalindrome(int i, int j, String s) {
      while (i < j) {
        if (s.charAt(i) != s.charAt(j)) {
          return false;
        }
        i++;
        j--;
      }
      return true;
    }
  }
}
