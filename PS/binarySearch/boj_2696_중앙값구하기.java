package PS.BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2696_중앙값구하기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int t = Integer.parseInt(br.readLine());
    for(int k=0;k<t; k++) {
      int m = Integer.parseInt(br.readLine());
      int[] answer = new int[m / 2 + 1];
      ArrayList<Integer> arr = new ArrayList<>();
      int idx = 0;
      for (int i = 0; i <= m / 10; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
          arr.add(Integer.parseInt(st.nextToken()));
          Collections.sort(arr);
          if (idx % 2 == 0) {
            getMiddle(arr, answer, idx);
          }
          idx++;
        }
      }
      idx = 0;
      bw.write(answer.length+"\n");
      while (idx < answer.length) {
        bw.write(answer[idx++] + " ");

        if (idx % 10 == 0) {
          bw.write("\n");
        }

      }
      bw.write("\n");
    }

    close();
  }

  public static void getMiddle(ArrayList<Integer>arr, int[] answer, int length) {
    if(length ==0){
      answer[length] = arr.get(0);
    }else{
      answer[length/2]= arr.get(length/2);
    }
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
