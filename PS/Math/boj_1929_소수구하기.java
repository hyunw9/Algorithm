package PS.Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_1929_소수구하기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static boolean[] decimal;

  public static void main(String[] args) throws IOException {
    init();
    String line = br.readLine();
    int m = Integer.parseInt(line.split(" ")[0]);
    int n = Integer.parseInt(line.split(" ")[1]);
    decimal = new boolean[n+1];

    Arrays.fill(decimal,true);

    for (int i = 2; i <= n; i++) {
      if(decimal[i]){

        for (int j = 2;j*i<=n;j++) {
          decimal[i*j] = false;
        }
      }
    }
    for (int i = m; i <=n ; i++) {
      if(i == 1) continue;
      if (decimal[i]) {
        bw.write(i + "\n");
      }
    }
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
