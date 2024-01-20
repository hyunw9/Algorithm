package PS.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class boj_1874_스택수열 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    init();
    sb = new StringBuilder();
    Queue<Integer> q = new LinkedList<>();
    Stack<Integer> stk = new Stack<>();
    int n = Integer.parseInt(br.readLine());
    for(int i = 0; i <n ; i++){
      q.add(Integer.parseInt(br.readLine()));
    }
    int idx = 1;

    while(!q.isEmpty()){
      int now = q.poll();
//      System.out.println("now: "+ now);
      if(idx<=now){
        while(idx<=now){
          stk.push(idx);
//          System.out.println("idx: "+ idx);
          idx++;
          sb.append("+\n");
        }
        if(stk.peek() ==now) {
          stk.pop();
          sb.append("-\n");
        }
      }else if(idx>now){
        if(stk.peek() == now) {
          stk.pop();
          //System.out.println("stk.pop(): " + );
          sb.append("-\n");

        }
        else{
        while(stk.peek()!=now) {
          stk.pop();
          sb.append("-\n");
          if(stk.isEmpty()) {
            System.out.println("NO");
            System.exit(0);
          }
        }
        }

      }
    }
    System.out.println(sb.toString());
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
