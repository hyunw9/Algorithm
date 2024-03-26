package PS.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_5430_AC {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    while(--n>=0){
      String line = br.readLine();
      int size = Integer.parseInt(br.readLine());
      StringBuilder sb= new StringBuilder();
      String nums = br.readLine();
      for(char now : nums.toCharArray()){
        if(Character.isDigit(now)){
          sb.append(now);
        }
      }

      boolean isError = false;
      for(char ops : line.toCharArray()){
        if (ops=='R'){
          sb.reverse();
        }else if(ops=='D'){
          if(sb.length()==0){
            isError = true;
            break;
          }else{
             sb.delete(0,1);
          }
          if(sb.length()==0){
            isError = true;
            break;
          }
        }
      }
      if(isError){
        bw.write("error\n");
      }else{
        bw.write(Arrays.toString(sb.toString().toCharArray())+"\n");
      }
    }//빈 문자열일 경우,   에러
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
