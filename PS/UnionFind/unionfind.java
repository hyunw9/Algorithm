package PS.UnionFind;

import java.util.Arrays;

public class unionfind {
  private static int[] arr;
  public static void main(String[] args){
    arr =new int[11];
    for(int i = 1; i <= 10; i++){
      arr[i] = i;
    }
    union(1,3);
    union(5,3);
    System.out.println(Arrays.toString(arr));
  }
  public static int find(int x){
    if(arr[x] == x)
      return x;
    return arr[x] = find(arr[x]);
  }

  public static void union(int a,int b){
    int pa = find(a);
    int pb = find(b);
    if(pa!=pb){
      if(pa<pb) arr[pb] = pa;
      else arr[pa] = pb;
    }
  }

}
