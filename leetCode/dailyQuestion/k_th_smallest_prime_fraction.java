package leetCode.dailyQuestion;

import java.util.*;

public class k_th_smallest_prime_fraction {

  public int[] kthSmallestPrimeFraction(int[] arr, int k) {
    ArrayList<int[]> list = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        list.add(new int[] {arr[i], arr[j]});
      }
    }
    Collections.sort(
        list,
        (o1, o2) -> {
          float a = (float) o1[0] / (float) o1[1];
          float b = (float) o2[0] / (float) o2[1];
          if (a < b) {
            return -1;
          } else {
            return 1;
          }
        });

    return list.get(k - 1);
  }
}
