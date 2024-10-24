package prgmrs.BinarySearch;

public class 퍼즐게임챌린지 {
  public int solution(int[] diffs, int[] times, long limit) {
    int answer = 0;
    // parametric search

    int l = 1;
    int r = 100000;
    // 숙련도의 최소값이 필요 ->최대레벨
    while (l <= r) {

      int tmplev = (l + r) / 2;
      long sum = 0;
      for (int i = 0; i < diffs.length; i++) {
        int diff = diffs[i];
        int curr = times[i];

        if (diff <= tmplev) {
          sum += curr;
        } else if (diff > tmplev) {
          int prev;
          if (i == 0) {
            prev = 0;
          } else {
            prev = times[i - 1];
          }
          sum += (diff - tmplev) * (curr + prev) + curr;
        }
      }
      // System.out.println(sum);

      if (sum > limit) {
        // sum이 크면,시간을 줄여야함. 즉,(실수를 막아야함->   레벨을 높여야 함).
        l = tmplev + 1;
      } else {
        answer = tmplev;
        r = tmplev - 1;
      }
      // 이 숙련도로 limit안에 만족시킬 수 있는지 계산
    }
    return answer;
  }
}
