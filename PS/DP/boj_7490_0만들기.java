package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_7490_0만들기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static char[] ops = {'+', '-', ' '};
  private static char[] arr;
  private static int n;
  private static int t;
  private static ArrayList<String> ans;
  private static boolean[] used;

  public static void main(String[] args) throws IOException {
    init();
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      ans = new ArrayList<>();
      used = new boolean[3 + 1];
      t = Integer.parseInt(br.readLine());
      dfs(1,"1");
      Collections.sort(ans);
      for(String answer : ans){
        bw.write(answer+"\n");
      }
      bw.write("\n");
    }

    close();
  }

  public static void dfs(int cnt, String curr) {
    if(cnt == t){
        if(calculate(curr)){
            ans.add(curr);
        }
        return;
    }
    for(int i = 0 ; i < 3 ; i++){
        dfs(cnt+1,curr+ops[i]+(cnt+1));
    }
  }

  public static boolean calculate(String curr){
    // System.out.println(curr);
    curr= curr.replaceAll(" ","");
    StringTokenizer st = new StringTokenizer(curr, "+|-", true);
    int c = Integer.parseInt(st.nextToken());
    while(st.hasMoreElements()){
        String op = st.nextToken();

        if(op.equals("+")){
            c+=Integer.parseInt(st.nextToken());
        }else{
            c-=Integer.parseInt(st.nextToken());
        }
    }
    return c == 0;
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
