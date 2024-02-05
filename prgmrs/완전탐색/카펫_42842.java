package prgmrs.완전탐색;

import java.util.ArrayList;

public class 카펫_42842 {

  public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];
    ArrayList<Integer> lst=  new ArrayList<>();
    for(int i = 3; i<= brown; i++){
      for(int j = 3; j<= brown;j++ ){
        if(i *j == brown+yellow){
          int[][] arr = new int[i][j];
          edge(arr);
          if(check(arr,yellow)== yellow){
            answer[0] = arr.length;
            answer[1] = arr[0].length;
          }
        }
      }
    }
    return answer;
  }
  public void edge(int[][] arr){
    int height = arr.length -1;
    int width = arr[0].length -1;
    for(int i = 0 ; i < arr.length; i++){
      for(int j = 0; j<arr[i].length; j++){
        if(i==0||j==0||i==height||j==width){
          arr[i][j] = 1;
        }
      }
    }
    //System.out.println(Arrays.deepToString(arr));
  }
  public int check(int[][]arr,int t){
    int a = 0;
    for(int i = 0 ; i <arr.length;i++){
      for(int j = 0 ; j<arr[i].length;j++){
        if(arr[i][j]==0) a++;
      }
    }
    return a;
  }

}
