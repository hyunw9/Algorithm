package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_20207_달력 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int sum;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    List<int[]> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      arr.add(new int[] {start, end});
    }
    Collections.sort(
        arr,
        (o1, o2) -> {
          if (o1[0] == o2[0]) return o1[1] - o2[1];
          return o1[0] - o2[0];
        });
    Queue<int[]> q = new LinkedList<>();
    for (int[] l : arr) {
      q.offer(l);
    }

    PriorityQueue<int[]> pq =
        new PriorityQueue<>(
            (o1, o2) -> {
              if (o1[1] == o2[1]) return o1[0] - o2[0];
              return o1[1] - o2[1];
            });

    int[] init = q.poll();
    int start = init[0];
    int end = init[1];
    int maxh = 1;
    pq.offer(init);

    while (!q.isEmpty()) {
      // System.out.println("---");

      int[] curr = q.poll();

      while (!pq.isEmpty() && pq.peek()[1] < curr[0]) {
        pq.poll();
      }

      if (curr[0] > end + 1) {
        // 끊어지는 경우
        pq.offer(curr);
        // System.out.println("거침");
        // System.out.println("start : " + start + " end : "+ end + " maxh : "+ maxh);
        sum += ((end - start) + 1) * maxh;
        end = curr[1];
        start = curr[0];
        maxh = 1;
        //    8 + 3 + 3 + 1
      } else {
        // 작업이 포함된다면
        // 포함 안된다면 while문으로 안겹칠때까지 빼야함

        pq.offer(curr);
      }
    //   for (int[] d : pq) {
    //     System.out.println(Arrays.toString(d));
    //   }
      end = Math.max(end, curr[1]);
      start = Math.min(start, curr[0]);
      maxh = Math.max(maxh, pq.size());
    }
    // while(!pq.isEmpty()){
    //     System.out.println(Arrays.toString(pq.poll()));
    // }
    // System.out.println("start : " + start + " end : " + end + " maxh : " + maxh);

    sum += ((end - start) + 1) * maxh;
    System.out.println(sum);
    close();
  }

  //    2 3
  // 1 2   2    6 +
  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}

//   2 3 4
// 1 2 3   |5 6 7|  9 10 11   13
