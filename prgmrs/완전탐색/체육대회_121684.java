package prgmrs.완전탐색;

public class 체육대회_121684 {

  private static int n ;
  private static int m ;
  private static boolean[] used;
  private static boolean[] stu;
  private static int max;


  public int solution(int[][] ability) {
    int answer = 0;
    n = ability.length;//학생 수
    m = ability[0].length; //종목 수

    used = new boolean[m];
    stu = new boolean[n];
    dfs(ability,0,0);


    //완탐 Or dfs or backtracking ?
    //j 는 종목  (행)
    //i 는 학생 수 , (열)
    //종목을 뽑아야 하니까 used 크기는 J 만큼,
    //System.out.println(Arrays.deepToString(ability));
    return max;
  }
  public void dfs(int[][] arr, int depth, int curr){
    if(depth == m){
      //System.out.println(curr);
      max = Math.max(max,curr);
      return;
    }
    for(int i = 0; i < n ; i++){
      int[] student = arr[i];

      //depth 가 현재 인덱스, 즉 종목을 판단하고, I 는 학생을 판단하면 된다.
      if(!stu[i] && !used[depth]){
        stu[i] = true;
        used[depth] = true;
        dfs(arr,depth+1,curr +student[depth]);
        used[depth] = false;
        stu[i] = false;
      }
    }
  }

}
