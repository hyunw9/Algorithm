package PS.UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_18116_로봇조립 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr;
  private static HashMap<Integer,Integer> map ;
  private static StringBuilder ans;


  public static void main(String[] args) throws IOException {
    init();
    ans = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    map=  new HashMap<>();
    arr = new int[(int)Math.pow(10,6)+1];
    for (int i = 1; i <= (int)Math.pow(10,6); i++) {
      arr[i] = i;
      map.put(i,1);
    }

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());

      String ops = st.nextToken();


      if (ops.equals("I")) {
        int first = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());
        if (find(first) != find(sec)) {
          union(first, sec);

        }

      } else {
        int target = find(Integer.parseInt(st.nextToken()));
        ans.append(map.get(target)).append("\n");
      }
      //1 2 3 4
      //1 2 2

    }
    System.out.print(ans.toString());
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

  public static int find(int x) {
    if (arr[x] == x) {
      return x;
    }
    return arr[x] = find(arr[x]);
  }

  public static void union(int a, int b) {
    int pA = find(a);
    int pB = find(b);

    if (pA != pB) {
      if (pA < pB) {
        arr[pB] = pA;
        map.put(pA, map.get(pA)+map.get(pB));
      } else {
        arr[pA] = pB;
        map.put(pB, map.get(pA)+map.get(pB));
      }
    }
  }
}

