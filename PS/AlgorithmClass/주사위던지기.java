package PS.AlgorithmClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 주사위던지기 {

  private static int n;
  private static int k;
  private static int[] answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    answer = new int[n];
    k = n ;
    dice(0);
  }

  public static void dice(int depth) {
    if (depth == k) {
      System.out.println(Arrays.toString(answer));
      return;
    }

    for (int i = 1; i <= 6; i++) {
      answer[depth] = i;
      dice(depth + 1);
    }
  }

}
