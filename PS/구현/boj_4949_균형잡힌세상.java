package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj_4949_균형잡힌세상 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static Stack<Character> stack;

  public static void main(String[] args) throws IOException {
    init();
    stack = new Stack<>();
    while(true){
      String line = br.readLine();
      if (line.length() == 1 && line.charAt(0)=='.') {
        break;
      }
      stack.clear();
      if(check(line)){
        bw.write("yes\n");
      }else {
        bw.write("no\n");
      }
    }
    close();
  }

  public static boolean check(String line){
    for (int i = 0; i < line.length(); i++) {
      char now = line.charAt(i);

      if(now == '('){
        stack.push(now);
      }else if(now == '['){
        stack.push(now);
      }else if(now == ')'){
        if(stack.isEmpty()||stack.peek()!='(') {
          return false;
        }else{
          stack.pop();
        }
      }else if(now == ']'){
        if(stack.isEmpty()||stack.peek()!='['){
          return false;
        }else{
          stack.pop();
        }
      }
    }
    return stack.isEmpty();
  }

  public static void init(){
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
