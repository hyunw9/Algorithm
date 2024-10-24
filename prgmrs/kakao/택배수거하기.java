package prgmrs.kakao;

public class 택배수거하기 {
  public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0;
    int i = n - 1;
    int del = 0;
    int pick = 0;
    while (i >= 0) {

      del -= deliveries[i];
      pick -= pickups[i];

      while (del < 0 || pick < 0) {
        System.out.println("idx: " + i);
        del += cap;
        pick += cap;
        answer += (i + 1) * 2;
      }
      i -= 1;
    }

    return answer;
  }
}
