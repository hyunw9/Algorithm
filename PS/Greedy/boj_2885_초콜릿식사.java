package PS.Greedy;

import java.io.*;
import java.util.*;

public class boj_2885_초콜릿식사 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int n;
  private static int cnt;

  public static void main(String[] args) throws IOException {
    init();
    n = Integer.parseInt(br.readLine());

    int max = 1;
    while (true) {
      if (max >= n) break;

      max *= 2;
    }
    // System.out.println(max);
    int amount = max;
    while(n>0){

        if(n>=amount){
            n-=amount;
        }else{
            amount/=2;
            cnt+=1;
        }
    }
    System.out.println(max +" "+ cnt);

    close();
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
