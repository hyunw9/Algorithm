package PS.AlgorithmClass;

import java.util.Arrays;

public class 작업처리순서 {

  public static void main(String[] args) {
    int[] array= new int[]{ 2,4,3};
    boolean[] chosen = new boolean[4];
    int[] answer=new int[3];

    for (int i = 0; i < 3; i++) {
      int min_index = -1;
      for (int j = 0; j < 3; j++) {
        if (!chosen[j] && (min_index == -1 || array[j] < array[min_index])) {
          min_index = j;
        }
      }
      chosen[min_index] = true;
      answer[i] = min_index+1;
    }
    System.out.println(Arrays.toString(answer));
  }






}
