package PS.Recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_4779_칸토어집합 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringBuilder sb;


  public static void main(String[] args) throws IOException {
    init();
    String input = "";

    while((input = br.readLine())!=null){
      int n =Integer.parseInt(input);
      sb = new StringBuilder();
      for(int i = 0; i<Math.pow(3,n);i++){
        sb.append("-");
      }
      divide(0,sb.length());
      System.out.println(sb.toString());
    }

    close();
  }
  public static void divide(int start, int end){
    //System.out.println(s);
    if(end-start==1){
      return;
    }
    int offset = (end-start)/3;
    for(int i = start+ offset; i<start +offset*2;i++){
      sb.setCharAt(i,' ');
    }
    divide(start,start +offset);
    divide(start + offset*2,end);

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
