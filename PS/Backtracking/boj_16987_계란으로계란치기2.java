package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_16987_계란으로계란치기2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] weights;
  private static int[] durability;
  private static boolean[] used;
  private static int max;
  private static int n;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    durability = new int[n];
    weights = new int[n];
    used = new boolean[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      durability[i] = Integer.parseInt(st.nextToken());
      weights[i] = Integer.parseInt(st.nextToken());
    }

    dfs(0,0);
    bw.write(max + "");
    close();
  }


  public static void dfs(int curIdx, int cnt) {
    //현재 계란이 깨졌다면 오른쪽꺼 들고 dfs, 근데 그게 가장 오른쪽일 경우 종료

    if (curIdx == n) {
//      System.out.println(cnt);
      max = Math.max(cnt, max);
      return;
    } else if (durability[curIdx] <= 0||cnt == n-1) {
      dfs(curIdx + 1, cnt );
    } else {
      int now = cnt;
      for(int i = 0 ; i < n ; i++){
        if(i == curIdx) continue;
        if(durability[i]<=0) continue;

        durability[i] -=weights[curIdx];
        durability[curIdx] -=weights[i];

        if(durability[i]<=0) cnt+=1;
        if(durability[curIdx]<=0) cnt+=1;

        dfs(curIdx+1,cnt);

        durability[i]+=weights[curIdx];
        durability[curIdx] +=weights[i];
        cnt=now;

      }
    }
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
