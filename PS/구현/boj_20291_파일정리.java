package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class boj_20291_파일정리 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    TreeMap<String,Integer> map = new TreeMap<>();
    for(int i = 0 ; i < n ; i++){
      StringTokenizer st =new StringTokenizer(br.readLine(),("."));
      String ext = st .nextToken();
      ext = st .nextToken();
      map.put(ext,map.getOrDefault(ext,0)+1);
    }
    for(String key : map.keySet()){
      bw.write(key + " " + map.get(key)+"\n");
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
