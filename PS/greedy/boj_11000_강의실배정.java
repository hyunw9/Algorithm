package PS.greedy;

import java.io.*;
import java.util.*;

public class boj_11000_강의실배정 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    PriorityQueue<int[]> pq =
        new PriorityQueue<>(
            (o1, o2) -> {
              if (o1[0] == o2[0]) return o1[1] - o2[1];
              return o1[0] - o2[0];
            });

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
    }
    PriorityQueue<Integer> room = new PriorityQueue<>((o1, o2) -> o1 - o2);
    room.add(0);
    int endTime = 0;

    while (!pq.isEmpty()) {

      int[] now = pq.poll();
      int start = now[0];
      int end = now[1];

      endTime = Math.max(endTime, end);
      if (!room.isEmpty() && room.peek() <= start) {
        room.poll();
      }
      room.add(end);
    }
    bw.write(room.size() + "");
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
