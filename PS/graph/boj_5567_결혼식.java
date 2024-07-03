package PS.Graph;

import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class boj_5567_결혼식 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int cnt;
  private static boolean visited[];

  public static void main(String[] args) throws IOException {
    init();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    ArrayList<Integer>[] arr = new ArrayList[n + 1];

    visited = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int me = Integer.parseInt(st.nextToken());
      int fr = Integer.parseInt(st.nextToken());
      arr[me].add(fr);
      arr[fr].add(me);
    }

    visited[1] = true;

    for (Integer friend : arr[1]) {
      if(!visited[friend]){
        visited[friend] = true;
        cnt++;
      }

      for (Integer nextFriend : arr[friend]) {
        if (!visited[nextFriend]) {
          visited[nextFriend] = true;
          cnt++;
        }
      }
    }

    bw.write(cnt + "");
    close();
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(in));
    bw = new BufferedWriter(new OutputStreamWriter(out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }
}
