package prgmrs.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class K번째수_42748 {

  public int[] solution(int[] array, int[][] commands) {

    int []answer= new int[commands.length];
    for (int i = 0; i <commands.length; i++) {
      ArrayList<Integer> arr = new ArrayList<>();
      int to = commands[i][0];
      int end = commands[i][1];
      int target = commands[i][2];
      for(int j = to-1; j<=end-1; j++){
        arr.add(array[j]);
      }
      Collections.sort(arr);
      //System.out.println(arr);

      answer[i]=arr.get(target-1);

    }
    return answer;
  }
}
