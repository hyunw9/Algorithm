package leetCode.greedy;

import java.util.*;

public class Non_overlapping_intervals {
  public int eraseOverlapIntervals(int[][] intervals) {
    int n = intervals.length;
    Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1], o2[1]));
    int count = 1;
    int prev = 0;

    for (int i = 1; i < n; i++) {
      if (intervals[i][0] >= intervals[prev][1]) {
        prev = i;
        count++;
      }
    }
    return n - count;
  }
}
