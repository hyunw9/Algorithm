package prgmrs.BFSDFS;
import java.util.*;

public class 네트워크_43162 {

  public static void main(String[] args) {
    int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
    solution(3,computers);
  }
    private static int[] arr;
    public static int find(int k ){
      if(arr[k] == k){
        return k;
      }
      return arr[k] = find(arr[k]);
    }

    public static void union(int a, int b) {
      arr[find(b)] = find(a);
    }

    public static int solution(int n, int[][] computers) {
      int answer = 0;
      arr = new int[n+1];
      for(int i  = 0 ; i<n; i ++){
        arr[i]= i;
      }
      for(int i = 0 ; i < n; i ++){

        for(int j : computers[i]){
          if(i==j) continue;
          else if(computers[i][j] ==1){
            union(i+1,j+1);
          }
        }
        for(int j = 0 ; j < computers[i].length ; i++){
          if(i==j) continue;
          if(computers[i][j] ==1){
            union(i,j);
          }
        }
      }
      System.out.println(Arrays.toString(arr));

      return answer;
    }

}
