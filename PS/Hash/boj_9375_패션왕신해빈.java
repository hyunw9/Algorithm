package PS.Hash;

import java.io.*;
import java.util.*;

public class boj_9375_패션왕신해빈 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    //1
    //2
    int n = Integer.parseInt(br.readLine());
    for (int t = 0; t < n; t++) {
      int c = Integer.parseInt(br.readLine());
      HashMap<String, Integer> map = new HashMap<>();
      int cnt = 1;
      for (int i = 0; i < c; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        String genre = st.nextToken();
        map.put(genre, map.getOrDefault(genre, 0) + 1);
      }
      for (String key : map.keySet()) {
        cnt *= (map.get(key) + 1);
      }
      cnt -= 1;
//      System.out.println(map);
      bw.write(cnt + "\n");
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
