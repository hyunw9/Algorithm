package PS.Greedy;

import java.util.Arrays;

public class 섬연결하기_42861 {

  public static int[] arr;
  public int solution(int n, int[][] costs) {
    int answer = 0;
    arr= new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = i;
    }
    Arrays.sort(costs,(o1,o2)->o1[2]-o2[2]);
    //System.out.println(Arrays.deepToString(costs));
    for(int i = 0 ; i<costs.length;i++){
      int start= costs[i][0];
      int end = costs[i][1];
      int c = costs[i][2];

      if(find(start)!=find(end)){
        union(start,end);
        answer+=c;
      }
    }

    return answer;
  }
  public int find(int x){
    if(arr[x] ==x ){
      return x;
    }
    return arr[x]=find(arr[x]);
  }
  public void union (int a, int b){
    arr[find(a)] = find(b);
  }

}
