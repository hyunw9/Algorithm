package PS.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_9372_상근이의여행 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    for(int i = 0; i < n;i++){
      StringTokenizer st= new StringTokenizer(br.readLine());
      int c = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      for(int j = 0 ; j <p;j++){
        st= new StringTokenizer(br.readLine());
      }
      bw.write(c-1+"\n");

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
