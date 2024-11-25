package PS.simulation;

import java.io.*;
import java.util.*;

public class boj_1713_후보추천하기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int n;
  private static int m;

  // 서 북 동 남

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int[] arr = new int[m];
    PriorityQueue<int[]> pq =
        new PriorityQueue<>(
            (o1, o2) -> {
              if (o1[1] == o2[1]) {
                return o2[2] - o1[2];
              }
              return o1[1] - o2[1];
            });
    for (int i = 0; i < m; i++) {

      int stu = Integer.parseInt(st.nextToken());
      // 돌면서 현재 애 존재하는지 확인
      boolean isExist = false;
      for (int[] before : pq) {
        if (before[0] == stu) {
          int[] curr = before;
          pq.remove(before);
          curr[1]+=1;
          System.out.println("HI: " + Arrays.toString(curr));
          pq.offer(curr);
          isExist = true;
        }
      }
      if (!isExist) {
        if(i > n - 1){
            int[] curr = pq.poll();
            curr[1] = 0;
            pq.offer(new int[] {stu, 1, 0});
            pq.offer(curr);
        }else{
            pq.offer(new int[]{stu,1,0});
        }
      } 

      clock(pq);
    }

    while (!pq.isEmpty()) {
      System.out.println(Arrays.toString(pq.poll()));
    }
    // {recomment, time}

  }

  public static void clock(PriorityQueue<int[]> pq) {
    for (int[] stu : pq) {
      stu[2] += 1;
    }
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

/*
 ** 간략한 풀이 :
 */
