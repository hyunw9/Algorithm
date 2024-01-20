package PS.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class boj_2164_카드 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    ArrayDeque<Integer> dq = new ArrayDeque<>();
    int n = Integer.parseInt(br.readLine());
    for(int i = 1 ; i <= n ; i ++){
      dq.addFirst(i);
    }
    while(dq.size()!=1){
      int now = dq.pollLast();
      if(!dq.isEmpty()){
        int next = dq.pollLast();
        dq.addFirst(next);
      }
    }
    bw.write(dq.pollLast()+"");
    close();
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
