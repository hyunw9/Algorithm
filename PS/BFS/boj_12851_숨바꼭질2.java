package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_12851_숨바꼭질2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] dx = {-1, 1, 2};

  public static void main(String[] args) throws IOException {
    init();
    Queue<Integer> q = new LinkedList<>();
    int[] map = new int[100001];
    StringTokenizer st = new StringTokenizer(br.readLine());
    int me = Integer.parseInt(st.nextToken());
    int target = Integer.parseInt(st.nextToken());
    int ans = 0;
    int min = 987654321;
    map[me] = 0;
    if(me>=target){
      bw.write(me-target+"\n");
      bw.write("1");
      close();
      return;
    }
    q.add(me);
    while (!q.isEmpty()) {

      int now = q.poll();

      if(min<map[now]) break;
      int next = 0;

      for (int i = 0; i < 3; i++) {
        if (dx[i] == 2) {
          next = now * 2;
        } else {
          next = now + dx[i];
        }

        if (next == target) {
          min = map[now];
          ans++;
        }
        if (next > 0 && next <= 100000) {
          if (map[next] == 0 || map[next] == map[now] + 1) {
            map[next] = map[now] + 1;
            q.add(next);
          }
        }
      }


    }

    bw.write(map[target] + "\n");
    bw.write(ans + "");
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

  static class Node {

    int num;
    int cost;

    public Node(int num, int cost) {
      this.num = num;
      this.cost = cost;
    }
  }

}
