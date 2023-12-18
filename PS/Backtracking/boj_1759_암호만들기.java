package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1759_암호만들기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static char[] arr;
  private static boolean[] used;
  private static char[] answer;

  private static int l;
  private static int c;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());

     l = Integer.parseInt(st.nextToken());
     c = Integer.parseInt(st.nextToken());
    arr = new char[c];
    answer = new char[l+1];
    used= new boolean[c];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < c; i++) {
      arr[i] = st.nextToken().charAt(0);
    }
    Arrays.sort(arr);
    dfs(0,0,0);

  }

  public static void dfs(int depth,int weak,int strong) throws IOException {
    if(depth == l&&weak>0&&strong>1){
      for (int i = 0; i <l; i++) {
        bw.write(answer[i]);
      }
      bw.write("\n");
      bw.flush();
      return;
    }
    for (int i = depth; i < c; i++) {
      if(!used[i]) {
        if(depth > 0 && answer[depth-1]>arr[i]) continue;
        if(depth>l) continue;
        used[i] = true;
        answer[depth] = arr[i];
        if(answer[depth] == 'a' || answer[depth] == 'e'||answer[depth] == 'i'||answer[depth] == 'o'||answer[depth] == 'u'){
          dfs(depth + 1,weak+1,strong);
        }else{
          dfs(depth+1,weak,strong +1);
        }
        used[i] = false;
      }
    }
  }

  public static void init(){
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
