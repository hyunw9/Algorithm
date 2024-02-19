package prgmrs.BinarySearch;

public class 징검다리건너기_64062 {

  public int solution(int[] stones, int k) {
    int answer = 0;

    //찾는건 사람 수
    int lo = 0;
    int hi = 2000000000;

    while (lo <= hi) {

      int mid = (lo + hi) / 2;

      if (available(stones, k, mid)) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return hi;
  }

  public boolean available(int[] stones, int k, int mid) {
    int cnt = 0;
    for (int s : stones) {
      if (s < mid) {
        cnt++;
        if (cnt >= k) {
          return false;
        }
      } else {
        cnt = 0;
      }
    }
    return true;
  }

}
