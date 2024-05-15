package prgmrs.Hash;

import java.util.HashMap;

public class 롤케이크자르가_132265 {

  public int solution(int[] topping) {

    int answer = 0;
    HashMap<Integer, Integer> left = new HashMap<>();
    HashMap<Integer, Integer> right = new HashMap<>();

    for (int i = 0; i < topping.length; i++) {
      left.put(topping[i], left.getOrDefault(topping[i], 0) + 1);
    }

    for (int i = topping.length - 1; i >= 0; i--) {
      if (left.containsKey(topping[i])) {
        left.put(topping[i], left.get(topping[i]) - 1);
        if (left.get(topping[i]) <= 0) {
          left.remove(topping[i]);
        }
      }
      right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
      if (left.keySet().size() == right.keySet().size()) {
        // System.out.println(left);
        // System.out.println(right);
        answer += 1;
      }
    }
    return answer;
  }
}
