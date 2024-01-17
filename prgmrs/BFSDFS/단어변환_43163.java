package prgmrs.BFSDFS;

public class 단어변환_43163 {

  private static boolean used[];
  private static int answer;
  private static int n;
  public int solution(String begin, String target, String[] words) {
    n = words.length;
    answer= 987654321;
    used = new boolean[n];

    dfs(words,0,n,begin,target,0);
    if( answer == 987654321) return 0;
    else return answer;
  }

  public static void dfs(String[] words, int depth, int length , String now, String target,int cnt){
    //System.out.println("now : "+now+" cnt : "+ cnt+" depth: "+ depth );

    if(depth == n || now.equals(target)){
      if(now.equals(target)){
        answer = Math.min(cnt,answer);
        return;
      }

    }
    for(int i = 0 ; i < n ; i ++){
      if(!used[i]){
        if(getDiff(now,words[i])){
          used[i] = true;
          dfs(words,depth+1,length,words[i],target,cnt+1);
          used[i]= false;
        }
      }
    }

  }

  public static boolean getDiff(String first, String second){
    int diff = 0 ;

    for(int i = 0 ; i<first.length(); i ++){
      if(first.charAt(i)!=second.charAt(i)) diff++;
    }
    if(diff == 1) return true;
    else return false;
  }

}
