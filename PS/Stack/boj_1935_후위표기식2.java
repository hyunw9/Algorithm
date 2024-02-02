package PS.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1935_후위표기식2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    Stack<Double> stack = new Stack<>();
    ArrayList<Double> arr = new ArrayList<>();
    double sum = 0;
    double n = Double.parseDouble(st.nextToken());
    String line = br.readLine();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      arr.add(Double.parseDouble(st.nextToken()));
    }
    int idx = 0;
    for (int i = 0; i < line.length(); i++) {
      if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
        stack.push(arr.get(line.charAt(i) - 'A'));
      } else if (line.charAt(i) == '*') {
        double temp1 = stack.pop();
        double temp2 = stack.pop();
        stack.push(temp2 * temp1);
      } else if (line.charAt(i) == '+') {
        double temp1 = stack.pop();
        double temp2 = stack.pop();
        stack.push(temp2 + temp1);
      } else if (line.charAt(i) == '-') {
        double temp1 = stack.pop();
        double temp2 = stack.pop();
        stack.push(temp2 - temp1);
      } else if (line.charAt(i) == '/') {
        double temp1 = stack.pop();
        double temp2 = stack.pop();
        stack.push(temp2 / temp1);
      }
    }
    sum = stack.pop();
    bw.write(String.format("%.2f",sum) + "");
    close();
  }

  private static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }

}
