package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2961_도영이가만든맛있는음식다국어 {

  private static class Food{

    private int sour;
    private int sweet;

    public Food(int sour,int sweet){
      this.sour = sour;
      this.sweet = sweet;
    }
  }

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static ArrayList<Food> arr;
  private static int n;
  private static boolean[] used;
  private static int min=Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st =new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    arr = new ArrayList<>();
    used = new boolean[n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      arr.add(new Food(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
    }

    dfs(0,0,1,0);
    bw.write(min+"");
    close();
  }

  private static void dfs(int input, int depth,int sour, int sweet){
    if(depth == n){
      if(input != 0){
        min = Math.min(min,Math.abs(sour-sweet));
      }
      return;
    }
    dfs(input, depth + 1, sour, sweet);
    dfs(input+1, depth+1, arr.get(depth).sour*sour,arr.get(depth).sweet+sweet);
  }

  private static void init(){
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }

}
