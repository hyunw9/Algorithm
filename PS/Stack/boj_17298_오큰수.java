package PS.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17298_오큰수 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    Stack<Integer> t = new Stack<>();
    Stack<Integer> ans = new Stack<>();
    for (int i = 0; i < n; i++) {
      int tmp = Integer.parseInt(st.nextToken());
      arr[i] = tmp;
    }
    for (int i = n - 1; i >= 0; i--) {
      if (i == n - 1) {
        t.push(arr[i]);
        ans.push(-1);

      } else {

        int tmp = arr[i];
        while (!t.isEmpty() && t.peek() <= tmp) {
          t.pop();

        }
        if(!t.isEmpty()) ans.push(t.peek());
        else ans.push(-1);
        t.push(tmp);
      }
    }
    while (!ans.isEmpty()) {
      bw.write(ans.pop() + " ");
    }
    close();
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
