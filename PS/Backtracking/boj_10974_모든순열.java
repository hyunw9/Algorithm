package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_10974_모든순열 {

  private static BufferedReader br;
  private static StringBuilder sb;

  private static int n;
  private static boolean[] check;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    init();
    n = Integer.parseInt(br.readLine());
    check = new boolean[n+1];

    bt(0,"");
    System.out.println(sb);
  }

  public static void bt(int num,String s) throws IOException {
    if(num == n){
      sb.append(s.trim()+"\n");
      return;
    }
    for (int i = 1; i <= n ; i++) {
      if(!check[i]){
        check[i] = true;
        bt(num+1,s + " "+i);
        check[i]= false;
      }
    }
  }

  public static void init(){
    br= new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
  }

  public static void close()throws IOException{
    br.close();
  }

}
