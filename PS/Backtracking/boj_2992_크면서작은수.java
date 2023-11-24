package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_2992_크면서작은수 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static char[] nums;
  private static boolean[] used;
  private static int n ;
  private static int number;
  private static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException{
    init();
    String line = br.readLine();
    n = line.length();
    number = Integer.parseInt(line);
    nums = new char[n];
    used = new boolean[n];
    for (int i = 0; i < n; i++) {
      nums[i] = line.charAt(i);
    }
    dfs(0,"");
    if(min == Integer.MAX_VALUE){
      min = 0;
    }
    bw.write(min+"");
    close();
  }

  public static void dfs(int depth,String num){

    if(depth == n){
      int val = Integer.parseInt(num);
      if(val < min && val > number ){
        min =val;
      }
      return;
    }
    for (int i = 0; i < n; i++) {
      if(!used[i]){
        used[i] = true;
        dfs(depth + 1, num+nums[i] );
        used[i] = false;
      }
    }
  }

  public static void init(){
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }
}
