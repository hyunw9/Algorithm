package prgmrs.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class 캐시_2019_공채 {

  public int solution(int cacheSize, String[] cities) {
    int answer = 0;
    for (int i = 0; i < cities.length; i++) {
      cities[i] = cities[i].toLowerCase();
    }
    Queue<String> q = new LinkedList<>();
    int cnt = 0;
    int idx = 0;
    while (idx < cities.length) {

      if (!q.contains(cities[idx])) {
        answer += 5;
        if (cacheSize == 0) {
          idx++;
          continue;
        }
        if (q.size() >= cacheSize) {
          q.poll();
        }
        q.offer(cities[idx]);

      } else {
        q.remove(cities[idx]);
        q.offer(cities[idx]);
        answer += 1;
      }
      idx++;
    }
    return answer;
  }

}
