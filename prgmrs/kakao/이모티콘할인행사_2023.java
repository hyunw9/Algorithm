package prgmrs.kakao;

public class 이모티콘할인행사_2023 {
  class Solution {

    public static int[] rate = {10, 20, 30, 40};

    public static int register;
    public static int maxprice;
    public static int[] emoji;
    public static int[] emoticon;
    public static int[] sales;
    public static PriorityQueue<int[]> pq;

    // 백트래킹으로 각각 모두 할인률 적용시킨 후에

    // 유저 순회하면서 개수 계산

    public int[] solution(int[][] users, int[] emoticons) {
      int[] answer = {};
      emoji = emoticons;
      emoticon = new int[emoticons.length];
      sales = new int[emoticons.length];
      for (int i = 0; i < emoticons.length; i++) {
        emoticon[i] = emoticons[i];
      }
      pq =
          new PriorityQueue<>(
              (o1, o2) -> {
                if (o2[0] == o1[0]) {
                  return o2[1] - o1[1];
                }
                return o2[0] - o1[0];
              });
      dfs(users, 0, 0);

      return pq.poll();
    }

    public static void dfs(int[][] users, int depth, int idx) {
      // System.out.println(Arrays.toString(emoji));
      if (depth == emoji.length) {
        int applied = 0;
        int purchased = 0;
        for (int i = 0; i < users.length; i++) {

          int sum = 0;

          for (int j = 0; j < sales.length; j++) {

            if (users[i][0] <= sales[j]) {
              sum += (emoji[j] * (1 - (sales[j] / 100.0)));
            }
          }
          if (sum >= users[i][1]) {
            applied += 1;
          } else {
            purchased += sum;
          }
        }
        pq.offer(new int[] {applied, purchased});
        return;
      }

      for (int i = 0; i < rate.length; i++) {
        // double discount = rate[i]/100.0 ;
        // emoji[idx] = (int) (emoji[idx] * (1-discount));
        sales[idx] = rate[i];
        dfs(users, depth + 1, idx + 1);
        // emoji[idx] = (int) (emoji[idx] / (1-discount));
      }
    }
  }
}
