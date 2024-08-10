package PS.SlidingWindow;

import java.io.*;
import java.util.*;

public class boj_16472_고냥이 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    char[] arr = br.readLine().toCharArray();

    HashMap<Character, Integer> map = new HashMap<>();
    int l = 0;
    int r = 0;
    int max = 0;
    int cnt = 0;
    while (l <= r && r < arr.length) {
        
      if (map.size() <= n) {
        map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
        r++;
      }else{
        map.put(arr[l],map.get(arr[l])-1);
        if(map.get(arr[l])==0){
            map.remove(arr[l]);
        }
        l++;
      }
      if(map.size()<=n){
        int window = r-l;
        max = Math.max(max,window);
      }
    }
    close();
  }

  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}
