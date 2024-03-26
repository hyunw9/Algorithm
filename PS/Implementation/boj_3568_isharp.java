package PS.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_3568_isharp {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    String def = st.nextToken();
    while(st.hasMoreTokens()){
      String var = st.nextToken();
      bw.write(def);
      ArrayDeque<Character> dq = new ArrayDeque<>();
      for(char now : var.toCharArray()){

        if(Character.isAlphabetic(now)) {
            dq.addLast(now);
        }
        else if(now=='*') dq.addFirst(now);
        else if(now=='[') dq.addFirst(']');
        else if(now==']') dq.addFirst('[');
        else if(now =='&') dq.addFirst('&');

      }
      boolean flag = false;
      while(!dq.isEmpty()){
        char now = dq.pollFirst();
        if(Character.isAlphabetic(now)&&!flag){
          bw.write(" ");
          flag = true;
        }
        bw.write(now);
      }
      flag=false;
      bw.write(";\n");
    }
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
