package PS.AlgorithmClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 주사위던지기합 {


  private static int n;
  private static int k;
  private static int[] answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());
    answer = new int[n + 1];
    dice(0,0);
  }

  public static void dice(int depth,int sum){
    if(depth == n){
      System.out.println(Arrays.toString(answer));
      return;
    }
    for (int i = 1; i <= 6; i++) {
      sum += i;
      answer[depth] = i;
      if(sum +( n-depth) < k || sum + (n-depth)*6 <k){
        dice(depth+1,sum);
      }

    }
  }

}
