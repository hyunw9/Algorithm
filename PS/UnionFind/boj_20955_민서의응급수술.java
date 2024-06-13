package PS.UnionFind;

import java.io.*;
import java.util.*;

public class boj_20955_민서의응급수술 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    arr = new int[n+1];
    Arrays.fill(arr,-1);
    int answer = 0;
    
    for(int i= 0; i< m;i++){
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken()); 
        if(!union(a,b)) answer +=1;

    }
    HashSet<Integer> set= new HashSet<>();

    for(int i = 1; i <=n; i++){
        set.add(find(i));
    }
    System.out.println(Arrays.toString(arr));
    answer +=set.size();
    
    System.out.println(answer-1);
    close();
  }

  public static int find(int x) {
    if (arr[x] < 0) return x;
    return arr[x] = find(arr[x]);
  }

  public static boolean union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b) {
      if (a < b) {
        arr[b] = a;
      } else {
        arr[a] = b;
      }
      return true;
    }
    return false;
  }

  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}
