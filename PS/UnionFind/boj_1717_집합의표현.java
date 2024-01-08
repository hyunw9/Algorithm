package PS.UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1717_집합의표현 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    arr = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      arr[i] = i;
    }

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      String ops = st.nextToken();
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if (ops.equals("0")) {
        //합
        union(a, b);
      } else if (ops.equals("1")) {
        //출력
        if (find(a) == find(b)) {
          bw.write("yes");
        } else {
          bw.write("no");
        }
        bw.write("\n");
      }
    }
    close();
  }

  public static int find(int a) {
    if (arr[a] == a) {
      return a;
    }
    return arr[a] = find(arr[a]);
  }

  public static void union(int x, int y) {
    arr[find(y)] = find(x);
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

/*
  for (int i = 0; i < m; i++) {
    st = new StringTokenizer(br.readLine());
    String ops = st.nextToken();
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    if(ops.equals("0")){
      //합
      int min = arr[Math.min(a,b)];
      int max = arr[Math.max(a,b)];

      for (int j = 0; j <=n ; j++) {
        if(arr[j] ==max){
          arr[j] = min;
        }
      }
    }else if(ops.equals("1")){
      //출력
      boolean flag = false;
      int max = Math.max(a,b);
      int low = Math.min(a,b);
      for (int j = 0; j <= n ; j++) {

        if(arr[max]==arr[low]){
          flag = true;
          break;
        }else if(arr[max]<max){
          max = arr[max];
        }
      }
      if(flag){
        bw.write("yes");
      }else{
        bw.write("false");
      }
    }
    //System.out.println(ops+"번"+ Arrays.toString(arr));

  }
*/
//유니온파인드는 상수 시간에 가능해야 의미가 있음. 이 코드는 N번씩 탐색하기 때문에 O(N) -> 시간초과 발생
}
