package prgmrs.완전탐색;

public class 피로도_87946 {

  public static int max = 0 ;
  public static int n = 0;
  public static boolean[] used;
  public int solution(int k, int[][] dungeons) {
    int answer = -1;
    n = dungeons.length;
    used = new boolean[n];
    dfs(dungeons,0,0,k,"");
    return max;
  }
  public void dfs(int[][]dungeons,int depth, int cnt,int curr,String route){
    if(depth == n ){
      //System.out.println(route);
      max = Math.max(cnt,max);

    }
    for(int i = 0 ; i <dungeons.length; i ++){
      if(!used[i]&&curr >= dungeons[i][0]){
        used[i]=true;
        dfs(dungeons,depth+1,cnt+1,curr-dungeons[i][1],route +" "+ (i+1));
        dfs(dungeons,depth+1,cnt,curr,route +" "+ (i+1));
        used[i] = false;
      }
    }
  }

}
