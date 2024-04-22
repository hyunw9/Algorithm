package leetCode.dailyQuestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class open_the_lock {

  public class Pair<K,V>{
    private K key;
    private V value;

    public Pair(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getKey(){
      return key;
    }

    public V getValue(){
      return value;
    }
  }

  public int openLock(String[] deadends, String target) {
    Set<String> deadend = new HashSet<>(Arrays.asList(deadends));
    if (deadend.contains("0000")) {
      return -1;
    }

    Queue<Pair<String, Integer>> q = new LinkedList<>();
    q.add(new Pair<>("0000", 0));
    Set<String> used = new HashSet<>();
    used.add("0000");

    while (!q.isEmpty()) {
      Pair<String, Integer> curr = q.poll();
      String currCombi = curr.getKey();
      int cost = curr.getValue();

      if (currCombi.equals(target)) {
        return cost;
      }

      for (int i = 0; i < 4; i++) {
        for (int delta : new int[]{-1, 1}) {
          int newDigit = (currCombi.charAt(i) - '0' + delta + 10) % 10;
          //if newDigit == 10 newDigit = 1; newDigit == -1 newDigit = 0 으로 대체도 가능함.
          String newCombi = currCombi.substring(0, i) + newDigit +
              currCombi.substring(i + 1);
          if (!deadend.contains(newCombi) && !used.contains(newCombi)) {

            used.add(newCombi);
            q.add(new Pair<>(newCombi, cost + 1));
          }
        }

      }
    }
    return -1;

  }

}
