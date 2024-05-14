package prgmrs.완전탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 메뉴리뉴얼_72411 {

  ArrayList<String> answer;

  public static void combination(String order, HashMap<String, Integer> map, int count, int now,
      StringBuilder sb, boolean[] used) {

    if (count == sb.length()) {
      String sorted = sort(sb);
      map.put(sorted, map.getOrDefault(sorted, 0) + 1);
      return;
    }

    for (int i = now; i < order.length(); i++) {
      if (!used[i]) {
        used[i] = true;
        combination(order, map, count, i + 1, sb.append(order.charAt(i)), used);
        used[i] = false;
        sb.setLength(sb.length() - 1);
      }
    }
    // cnt 만큼 모든 조합을 구하고, 그다음에 정렬해서 해시맵에 추가
  }

  public static String sort(StringBuilder sb) {
    char[] arr = sb.toString().toCharArray();
    Arrays.sort(arr);
    sb.setLength(0);
    for (char a : arr) {
      sb.append(a);
    }
    return sb.toString();
  }

  public String[] solution(String[] orders, int[] course) {
    answer = new ArrayList<>();

    // Arrays.sort(orders,(o1,o2)->o2.length()-o1.length());
    for (int i = 0; i < orders.length; i++) {
      StringBuilder sb = new StringBuilder();
      orders[i] = sort(sb.append(orders[i]));
    }
    for (int count : course) {
      HashMap<String, Integer> map = new HashMap<>();

      for (int i = 0; i < orders.length; i++) {
        StringBuilder sb = new StringBuilder();
        System.out.println(orders[i]);

        combination(orders[i], map, count, 0, sb, new boolean[orders[i].length()]);
      }
      // System.out.println(map);
      int max = 0;
      for (String k : map.keySet()) {
        max = Math.max(max, map.get(k));
      }
      if (max <= 1) {
        continue;
      }
      for (String k : map.keySet()) {
        if (map.get(k) == max) {
          answer.add(k);
        }
      }
    }
    Collections.sort(answer);
    return answer.toArray(new String[answer.size()]);
  }
}
