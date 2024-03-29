package PS.경로압축;

import java.io.*;
import java.util.*;

public class boj_18870_경로압축 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    ArrayList<Integer> comp = new ArrayList<>();
    int[] arr = new int[n];
    HashMap<Integer,Integer> map = new HashMap<>();
    st= new StringTokenizer(br.readLine());
    for(int i = 0 ; i < n ; i ++){
      int now = Integer.parseInt(st.nextToken());
      arr[i] = now;
      comp.add(now);
    }

    Collections.sort(comp);
    int rank = 0 ;
    for(int v : comp){
      if(!map.containsKey(v)){
        map.put(v,rank);
        rank++;
      }
    }
    for( int i = 0 ; i < n; i++){
      bw.write(map.get(arr[i])+" ");
    }
    close();
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
