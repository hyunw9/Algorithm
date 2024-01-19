package prgmrs;

public class 정수삼각형_43105 {

  private static int[][] dp ;

  public int solution(int[][] triangle) {
    int answer = 0;
    dp = new int[triangle.length][triangle.length];

    dp[0][0] = triangle[0][0];

    for(int i =1 ; i< triangle.length ; i ++){

      for(int j = 0 ; j < triangle[i].length ; j++){
        if(j==0){
          dp[i][j]= dp[i-1][j] + triangle[i][j];
        }else if(i==j){
          dp[i][j] = dp[i-1][j-1] + triangle[i][j];
        }else{
          dp[i][j] = Math.max(dp[i-1][j]+triangle[i][j], dp[i-1][j-1]+triangle[i][j]);
        }
      }
    }
    //System.out.println(Arrays.deepToString(dp));
    for(int i = 0; i<dp[triangle.length-1].length ; i++){
      if(answer< dp[triangle.length-1][i]) answer = dp[triangle.length-1][i];
    }
    return answer;
  }

}
