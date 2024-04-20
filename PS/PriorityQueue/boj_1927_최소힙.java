package PS.PriorityQueue;

import java.io.*;
import java.util.*;

public class boj_1927_최소힙 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int now = Integer.parseInt(br.readLine());
      if (now == 0) {
        if (pq.isEmpty()) {
          bw.write("0\n");
        } else {
          bw.write(pq.poll() + "\n");
        }
      } else {
        pq.add(now);
      }
    }
    close();
  }

  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}
