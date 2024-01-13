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
      TreeMap<Integer, Integer> map = new TreeMap<>();

      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      for (int j = 0; j < t; j++) {

        st = new StringTokenizer(br.readLine());
        String ops = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        if (ops.equals("I")) {
          map.put(num, map.getOrDefault(num, 0) + 1);


        } else if (ops.equals("D")) {
          if (map.size() == 0) {
            continue;
          }
          if (num == 1) {
            int key = map.lastKey();
            if (map.put(key, map.get(key) - 1)==1) {
              map.remove(key);
            }

          } else if (num == -1) {
            int key = map.firstKey();
            if (map.put(key, map.get(key) - 1)==1) {
              map.remove(key);
            }
          }
        }
      }
      if (map.size()==0) {
        bw.write("EMPTY\n");
      } else {
        bw.write(map.lastKey() + " " + map.firstKey() + "\n");
      }
    }
    close();
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
