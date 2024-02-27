package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_17220_마약수사대 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int ans;
  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    ArrayList<Integer>[] arr= new ArrayList[n];
    for(int i = 0; i <n ; i++){
      arr[i] = new ArrayList<>();
    }
    int[] header = new int[n];


    for(int i = 0 ; i < m; i++){
      String line = br.readLine();
      int start = line.charAt(0)-'A';
      int to = line.charAt(2)-'A';
      arr[start].add(to);
      header[to]+=1;
    }
    //발각된 공급책 읽기
//    System.out.println(Arrays.toString(arr));
    st=new StringTokenizer(br.readLine());
    ArrayList<Integer> detected = new ArrayList<>();
    int plug =Integer.parseInt(st.nextToken());
    for(int i =0; i<plug; i++){
      String now = st.nextToken();
      detected.add(now.charAt(0)-'A');
    }
    //발각된 공급책과 연관된 자식들 모두 지우기
    for(int d : detected){
      arr[d].clear();

      for(int i =0; i <n; i++){

        if(arr[i].contains(d)){
          arr[i].remove(Integer.valueOf(d)); //참조형 필요!
        }
      }
    }
    //부모노드부터 탐색하면 됨,
    for(int i = 0 ; i < n; i++){
      if(header[i]==0){
        dfs(arr,i);
      }
    }
    bw.write(ans+"");
    close();
  }
  public static void dfs(ArrayList<Integer>[] arr, int n){

    for(int next: arr[n]){
      dfs(arr,next);
      ans++;
    }
  }
  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
