package leetCode.BinarySearch;

public class eating_bananas {
  public int minEatingSpeed(int[] piles, int hr) {
    int l = 0;

    int h = 0;
    for (int i : piles) {
      h = Math.max(h, i);
    }

    int min = 1_000_000;

    while (l <= h) {
      int speed = (l + h) / 2;
      int sum = 0;
      for (int pile : piles) {
        sum += Math.ceil((double) pile / speed);
      }
      if (sum > hr) {

        l = speed + 1;
      } else {
        min = speed;
        h = speed - 1;
      }
    }

    return min;
  }
}
