package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class boj_16987_계란으로계란치기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int max;
  private static boolean[] broken;
  private static Egg[] eggs;
  private static int n;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    eggs = new Egg[n];
    broken = new boolean[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int d = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      eggs[i] = new Egg(d, w);
    }
    dfs(0, 0);
    bw.write(max + "");
    close();
  }

  public static void dfs(int cnt, int idx) {
    //현재 든 계란이 가장 오른 쪽이거나, 다 깨졌으면 더이상 꺨 수 없다.
    if (idx == n) {
      max = Math.max(max, cnt);
      return;
    } else if (eggs[idx].d <= 0 || cnt == n - 1) {

      dfs(cnt, idx + 1);
    } else {
      int now = cnt;
      for (int i = 0; i < n; i++) {
        if (i == idx) {
          continue;
        }
        //깨져있으면 건너뜀
        if (eggs[i].d <= 0) {
          continue;
        }

        eggs[i].d = eggs[i].d - eggs[idx].w;
        eggs[idx].d = eggs[idx].d - eggs[i].w;

        if (eggs[idx].d <= 0) {
          cnt++;
        }
        if(eggs[i].d<=0){
          cnt++;
        }
        dfs(cnt, idx + 1);
        eggs[i].d = eggs[i].d + eggs[idx].w;
        eggs[idx].d = eggs[idx].d + eggs[i].w;
        cnt = now;

      }
    }
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }

  private static class Egg {

    int d;
    int w;

    public Egg(int d, int w) {
      this.d = d;
      this.w = w;
    }

    public int getD() {
      return d;
    }

    public int getW() {
      return w;
    }
  }

}
