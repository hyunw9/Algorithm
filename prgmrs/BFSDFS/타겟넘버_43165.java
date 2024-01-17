package prgmrs.BFSDFS;

public class 타겟넘버_43165 {

  static class Solution {
    private static int answer ;
    private static boolean[] used;
    public int solution(int[] numbers, int target) {

      used = new boolean[numbers.length];
      dfs(numbers,0,0,target);


      return answer;

    }
    public void dfs(int[]numbers, int depth, int num, int target){
      //System.out.println("depth: "+ depth+ " num : "+ num );
      if(depth == numbers.length){
        //System.out.println("DONE ! ::> "+"depth: "+ depth+ " num : "+ num );

        if(num == target){
          answer++;
        }
      }

      if(depth>=numbers.length) return ;
      dfs(numbers,depth+1,num+numbers[depth],target);
      dfs(numbers,depth+1,num-numbers[depth],target);

    }

  }



}
