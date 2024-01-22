package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_9663_NQueen2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static boolean[] ga;
  private static boolean[] se;
  private static boolean[] jd;
  private static boolean[] ud;
  private static int[][] map;
  private static int n;
  private static int answer;
  public static void main(String[] args) throws IOException {
    init();
    n = Integer.parseInt(br.readLine());

    ga = new boolean[n];
    se = new boolean[n];
    jd = new boolean[2*n];
    ud = new boolean[2*n];
    map = new int[n][n];
    dfs(0);
    bw.write(answer+"");
    close();
  }

  public static void dfs(int depth){
    if (depth == n){
      answer++;
    }
    for(int i = 0 ; i <n;i++){
     if(!ga[i]&&!jd[depth+i]&&!ud[n-depth+i]){
       ga[i]=true;
       jd[depth+i] = true;
       ud[n-depth+i] = true;
       dfs(depth+1);
       ga[i]=false;
       jd[depth+i] = false;
       ud[n-depth+i] = false;
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
