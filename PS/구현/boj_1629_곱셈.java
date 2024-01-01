package PS.구현;

import static java.lang.System.in;
import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1629_곱셈 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static long a;
  private static long b;
  private static long c;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());

    a = Long.parseLong(st.nextToken());
    b = Long.parseLong(st.nextToken());
    c = Long.parseLong(st.nextToken());

    bw.write(pow(a, b) + "");
    close();

  }

  public static long pow(long num, long exp) {
    if (exp == 1) {
      return num % c;
    }
    long temp = pow(num, exp / 2);

    if (exp % 2 == 1) {
      return (temp * temp % c) * num % c;
    }
    return temp * temp % c;

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
