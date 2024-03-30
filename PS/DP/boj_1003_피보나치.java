package PS.DP;

import java.io.*;
import java.util.*;

public class boj_1003_피보나치 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int cone;
  private static int ctwo;


  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] q = new int[n];

    for(int i = 0 ; i < n ; i++){
      st= new StringTokenizer(br.readLine());
      q[i] = Integer.parseInt(st.nextToken());
    }
    int []one = new int [41];
    int []zero = new int [41];
    int []dp = new int [41];

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    zero[0] = 1;
    zero[1] = 0;
    zero[2] = 1;
    one[0] = 0;
    one[1] = 1;
    one[2] = 1;
    for(int i  = 3; i< dp.length; i++){
      dp[i] = dp[i-1]+dp[i-2];
      one[i] = one[i-1] + one[i-2];
      zero[i] = zero[i-1] + zero[i-2];
    }
    for(int v : q){
      bw.write(zero[v] +" "+ one[v]+"\n");
    }
    close();
  }

  public static int fib(int n ){

    if(n == 0){
      cone ++;
      return 0;
    }else if(n == 1){
      ctwo++;
      return 1;
    }else{
      return fib(n-1)+ fib(n-2);
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
