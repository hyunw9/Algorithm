package leetCode.unionfind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class number_of_provinces {

  private static int[] list;

  public int findCircleNum(int[][] isConnected) {
    List<Integer>[] arr = new ArrayList[isConnected.length];
    list = new int[isConnected.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < list.length; i++) {
      list[i] = i;
    }

    for (int i = 0; i < isConnected.length; i++) {

      for (int j = 0; j < isConnected[i].length; j++) {
        if (isConnected[i][j] == 1) {
          union(i, j);
        }
      }
    }
    HashSet<Integer> set = new HashSet<>();
    for (int a : list) {
      set.add(find(a));
    }

    return set.size();
  }

  public int find(int x) {
    if (list[x] == x) {
      return x;
    }
    return list[x] = find(list[x]);
  }

  public void union(int a, int b) {
    int fa = find(a);
    int fb = find(b);

    if (fa != fb) {
      if (fa < fb) {
        list[fb] = fa;
      } else {
        list[fa] = fb;
      }
    }
  }

}
