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
    answer = new int[n + 1];
    k = n + 1;
    dice(1);
  }

  public static void dice(int depth) {
    if (depth == k) {
      for (int i = 1; i <= n; i++) {
        System.out.print(i + "번째: " + answer[i] + ", ");
      }
      System.out.println();
      return;
    }

    for (int i = 1; i <= 6; i++) {
      answer[depth] = i;
      dice(depth + 1);
    }
  }

}
