package PS.Graph;

import java.io.*;
import java.util.*;

public class boj_13023_ABCDE {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static ArrayList<Integer>[] arr;
  private static boolean[] used;
  private static int answer;
  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new ArrayList[n];

    for (int i = 0; i < n; i++) {
      arr[i] = new ArrayList<>();
    }
    used = new boolean[n];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      arr[a].add(b);
      arr[b].add(a);
    }
    // 4 번 탐색이 가능해야 1번 추가임
    // System.out.println(Arrays.deepToString(arr));
    for(int i = 0 ; i<n; i++){
        if(!used[i]){
            used[i] = true;
            dfs(1,i);
            used[i] = false;
        }
        if(answer > 0 ) {
            System.out.println(1);
            break;
        }
    }
    // dfs(0,0);
    if(answer >= 1){
        System.out.println(1);
    }else{
        System.out.println(0);
    }
    close();
  }

  public static void dfs(int cnt, int curr) {

    if (cnt == 5) {
      answer += 1;
      return;
    }
    for (int next : arr[curr]) {
      if (!used[next]) {
        used[next] = true;
        // System.out.println("next: " + next);
        dfs(cnt + 1, next);
        used[next] = false;
      }
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
