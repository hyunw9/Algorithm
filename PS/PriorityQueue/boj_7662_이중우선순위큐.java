package PS.PriorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class boj_7662_이중우선순위큐 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int tc = Integer.parseInt(st.nextToken());

    for (int i = 0; i < tc; i++) {
      HashMap<Integer, Integer> map = new HashMap<>();
      PriorityQueue<Integer> min = new PriorityQueue<>((o1, o2) -> o1 - o2);
      PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      for (int j = 0; j < t; j++) {

        st = new StringTokenizer(br.readLine());
        String ops = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        if (ops.equals("I")) {
          map.put(num, map.getOrDefault(num, 0) + 1);
          min.add(num);
          max.add(num);

        } else {
          if (map.size() == 0) {
            continue;
          }
          if (num == 1) {
            if (!max.isEmpty()) {
              delete(max, map);
            }
          } else if (num == -1) {
            if (!min.isEmpty()) {
              delete(min, map);
            }
          }
        }
      }
      if (min.isEmpty() || max.isEmpty()) {
        bw.write("EMPTY\n");
      } else {
        int maxV = delete(max, map);
        bw.write(maxV + " ");
        if (map.size() > 0) {
          bw.write(delete(min, map)+"");
        } else {
          bw.write(maxV + "");
        }
      }
    }
    close();

  }
  

  public static int delete(PriorityQueue<Integer> pq, HashMap<Integer, Integer> map) {
    int num = 0;
    while (true) {
        num = pq.poll();
        int cnt = map.getOrDefault(num, 0);
        if (cnt == 0) {
          continue;
        }
        if (cnt == 1) {
          map.remove(num);
        } else {
          map.put(num, cnt - 1);
        }

        break;
      }


    return num;
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
