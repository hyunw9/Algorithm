package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_14888_연산자끼워넣기2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] num;
  private static int[] ops;
  private static int max=Integer.MIN_VALUE;
  private static int min=Integer.MAX_VALUE;
  private static int n;
  private static boolean[] used;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    num = new int[n];
    ops = new int[4];
    used = new boolean[n];
    for(int i = 0 ; i < n ; i ++){
      num[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i = 0 ; i<4 ;i++){
      ops[i] = Integer.parseInt(st.nextToken());
    }
    dfs(1,num[0]);
    bw.write(max+"\n"+ min);
    close();
  }

  public static void dfs(int depth,int cnt){
    if(depth == n){
      min = Math.min(min,cnt);
      max = Math.max(max,cnt);
    }
    for(int i = 0 ; i < 4;i++){
      if(ops[i]>0) {
        ops[i] -= 1;
        if (i == 0) {
          dfs(depth + 1, cnt + num[depth]);
        } else if (i == 1) {
          dfs(depth+ 1, cnt - num[depth]);
        } else if (i == 2) {
          dfs(depth + 1, cnt * num[depth]);
        } else if (i == 3) {
          dfs(depth + 1, cnt / num[depth]);
        }
        ops[i] += 1;
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
