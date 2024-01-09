package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class boj_1431_시리얼번호 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    List<String> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      arr.add(br.readLine());
    }
    arr.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() != o2.length()) {
          return o1.length() - o2.length();
        } else {
          int sum1 = sumOfDigits(o1);
          int sum2 = sumOfDigits(o2);
          if (sum1 != sum2) {
            return sum1 - sum2;
          } else {
            return o1.compareTo(o2);
          }
        }
      }
    });
    for (int i = 0; i < arr.size(); i++) {
      bw.write(arr.get(i)+"\n");
    }
    close();
  }

  public static int sumOfDigits(String s) {
    int sum = 0;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        sum += c - '0';
      }
    }
    return sum;
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
