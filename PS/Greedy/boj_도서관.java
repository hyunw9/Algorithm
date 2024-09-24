package PS.Greedy;

import java.io.*;
import java.util.*;

public class boj_도서관 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int n;
  private static int m;
  private static int[] arr;
  private static PriorityQueue<Integer> yin;
  private static PriorityQueue<Integer> yang;
  private static int sum;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 뭐가 그리디한 접근법일까?
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    yin = new PriorityQueue<>((o1, o2) -> o1 - o2);
    yang = new PriorityQueue<>((o1, o2) -> o2 - o1);

    for (int i = 0; i < n; i++) {

      int input = Integer.parseInt(st.nextToken());
      if (input < 0) {
        yin.offer(input);
      } else {
        yang.offer(input);
      }
    }
    int idx = 0;
    // 처음엔 최대값 비교해서 더 큰쪽으로 뽑기
    while (!yin.isEmpty() || !yang.isEmpty()) {

      int poll;
      if (yin.isEmpty()) {
        poll = getNum(yang);
      } else if (yang.isEmpty()) {
        poll = getNum(yin);
      } else {
        if (Math.abs(yin.peek()) < yang.peek()) { // 양수 진영이 더 큼
          poll = yang.poll();

          for (int i = 1; i < m; i++) {
            // poll이랑 차 비교 .
            if (!yang.isEmpty()) {
              yang.poll();
            }
          }
        } else {
          poll = Math.abs(yin.poll());

          for (int i = 1; i < m; i++) {
            if (!yin.isEmpty()) {
              yin.poll();
            }
          }
        }
      }
      if (idx == 0) {
        sum += poll;
      } else {
        sum += (poll * 2);
      }

      idx += 1;
    //   System.out.println(poll);
    }
    System.out.println(sum);
    close();
  }

  public static int getNum(PriorityQueue<Integer> pq) {
    int poll = Math.abs(pq.poll());

    for (int i = 1; i < m; i++) {
      if (!pq.isEmpty()) {
        pq.poll();
      }
    }
    return poll;
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
