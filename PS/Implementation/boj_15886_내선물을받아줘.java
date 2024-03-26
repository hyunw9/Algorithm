package PS.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_15886_내선물을받아줘 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    char[] arr = br.readLine().toCharArray();
    boolean[] used = new boolean[n];
    int answer = 0;
    Queue<Character> q = new LinkedList<>();
    //E E W W E W
    //o o o   o
    // E E E E W
    // o o o o

    for(int i = 0 ; i < n ; i ++){
      if(arr[i]=='E'){
        used[i] = true;
      }else if(arr[i]=='W'){
        if(i-1>=0){
          used[i-1] = true;
        }
      }
    }
    for(boolean a : used){
      if(!a) answer++;
    }
    bw.write(answer+"");
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
