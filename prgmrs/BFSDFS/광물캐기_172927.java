package prgmrs.BFSDFS;

public class 광물캐기_172927 {

  class Solution {

    private static int curr;
    private static int min = 987654321;
    private static int maxPick;


    public int solution(int[] picks, String[] minerals) {
      int answer = 0;
      for (int i = 0; i < picks.length; i++) {
        maxPick += picks[i];
      }
      //System.out.println(maxPick);
      dfs(picks, minerals, 0, 0, 0);
      //하나 체크해서 인덱스 따라서 피로도 계산.
      // 만약 사용 도구가 끝났거나, 인덱스 끝이 되면 종료

      return min;
    }

    public void dfs(int[] picks, String[] minerals, int depth, int idx, int curr) {
      if (depth == maxPick || idx == minerals.length) {
        //System.out.println("CURR: "+curr);
        min = Math.min(curr, min);
      }

      for (int i = 0; i < 3; i++) {
        if (picks[i] == 0) {
          continue;
        }
        // System.out.println("I: "+i);

        int till = 0;
        if (idx + 5 < minerals.length) {
          till = idx + 5;
        } else {
          till = minerals.length;
        }

        int newAdd = curr;
        for (int j = idx; j < till; j++) {
          if (i == 0) {
            newAdd += 1;

          } else if (i == 1) {
            if (minerals[j].equals("diamond")) {
              newAdd += 5;
            } else {
              newAdd += 1;
            }
          } else if (i == 2) {
            if (minerals[j].equals("diamond")) {
              newAdd += 25;
            } else if (minerals[j].equals("iron")) {
              newAdd += 5;
            } else {
              newAdd += 1;
            }
          }
        }
        picks[i] -= 1;
        //System.out.println("now curr:"+ curr);
        dfs(picks, minerals, depth + 1, till, newAdd);
        picks[i] += 1;


      }

    }
  }

}
