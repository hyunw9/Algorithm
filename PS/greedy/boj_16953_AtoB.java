package PS.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_16953_AtoB {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int cnt = 0;
    while(b!=a){
      if(b<a){
        cnt = -2;
        break;
      }

      if(b % 2 == 0){
        b = b/2;
        cnt++;
      }else if(b % 10 == 1){
        b = b/10;
        cnt++;
      }
      else{
        cnt = -2;
        break;
      }
    }
    bw.write(cnt+1+"");
    close();
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
