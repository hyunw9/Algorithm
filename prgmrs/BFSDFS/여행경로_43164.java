package prgmrs.BFSDFS;

import java.util.*;

public class 여행경로_43164 {


  private static boolean[] used;
  private static String[] answer;
  private static int n;
  private static StringBuilder sb;
  private static List<String> ans;


  public String[] solution(String[][] tickets) {
    used = new boolean[tickets.length];
    answer = new String[tickets.length + 1];
    n = tickets.length;
    ans = new ArrayList<>();
    dfs("ICN", tickets, 0, "ICN");//ICN -> ATL . ATL이 시작
    Collections.sort(ans);
    return ans.get(0).split(" ");
  }

  public void dfs(String start, String[][] tickets, int depth, String str) {

    if (depth == n) {
      ans.add(str);
    }

    for (int i = 0; i < tickets.length; i++) {

      if (!used[i]) {
        if (start.equals(tickets[i][0])) {
          used[i] = true;
          dfs(tickets[i][1], tickets, depth + 1, str + " " + tickets[i][1]);
          used[i] = false;

        }
      }
    }
  }
}


