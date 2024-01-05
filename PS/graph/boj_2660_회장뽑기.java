package PS.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2660_회장뽑기 {


  private static BufferedReader br;
  private static BufferedWriter bw;
  private static ArrayList<Integer>[] arr;
  private static boolean used[];
  private static int[] answer;
  private static int n;
  private static int min = 987654321;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    arr = new ArrayList[n + 1];
    answer = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      arr[i] = new ArrayList<>();
    }
    Arrays.fill(answer, 987654321);

    while (true) {
      st = new StringTokenizer(br.readLine());
      int me = Integer.parseInt(st.nextToken());
      int friend = Integer.parseInt(st.nextToken());
      if (me == -1 && friend == -1) {
        break;
      }
      arr[me].add(friend);
      arr[friend].add(me);
    }
    for (int i = 1; i <= n; i++) {
      bfs(i);
    }
    int cnt =0;
    for (int i = 1; i <= n; i++) {
      if (answer[i] == min) {
        cnt++;
      }
    }
    bw.write(min + " " + cnt);
    bw.write("\n");

    for (int i = 1; i <= n; i++) {
      if (answer[i] == min) {
        bw.write(i + " ");
      }
    }
    close();

  }

  private static void bfs(int s) {
    used = new boolean[n + 1];
    used[s] = true;

    Queue<Friend> q = new LinkedList<>();
    int result = 0;

    q.add(new Friend(s, 0));

    while (!q.isEmpty()) {
      Friend friend = q.poll();
      int rank = friend.rank ;
      int curr = friend.friend;

      result = Math.max(result, rank);

      for (int next : arr[curr]) {
        if (!used[next]) {
          used[next] = true;
          q.add(new Friend(next, rank + 1));
        }
      }
    }
    answer[s] = result;
    min = Math.min(min, result);
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

  static class Friend {

    int friend;
    int rank;

    public Friend(int friend, int rank) {
      this.friend = friend;
      this.rank = rank;
    }
  }
}
