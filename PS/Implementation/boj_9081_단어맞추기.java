package PS.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class boj_9081_단어맞추기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static ArrayList<String> arr;
  private static Set<String> set;
  private static boolean[] used;
  private static char[] carr;

  public static void main(String[] args) throws IOException {
    init();
    //배열 생성
    //만들어질 수 있는 값들 모두 만들어서 배열에 넣기
    //만약 현재 값이 나온다면 그 다음 것 반환
    int n = Integer.parseInt(br.readLine());
    while(--n>=0){
      arr= new ArrayList<>();
      String line = br.readLine();
      used = new boolean[line.length()];
      carr = line.toCharArray();
      bw.write(next_permutation(carr)+"\n");
    }
    close();
  }

  public static String next_permutation(char[] arr){
    StringBuilder sb = new StringBuilder();
    int i = arr.length-1;
    while(i>0&&arr[i-1]>=arr[i]){
      i-=1;
      if(i == 0 ) {
        for(char a : arr){
          sb.append(a);
        }
        return sb.toString();
      }
    }
    int pivot= arr.length-1;
    while(arr[i-1]>=arr[pivot]) pivot--;

    char temp = arr[i-1];
    arr[i-1]= arr[pivot];
    arr[pivot] = temp;

    int k = arr.length-1;
    while(i<k){
      temp = arr[i];
      arr[i] = arr[k];
      arr[k] = temp;
      ++i;
      --k;
    }

    for(char a : arr){
      sb.append(a);
    }
    return sb.toString();
  }

  public static void dfs(int depth, String curr,int len){
    if(depth == len){
      set.add(curr);
      return;
    }
    for(int i = 0 ; i < len ; i ++){
      if(!used[i]){
        used[i] = true;
        dfs(depth+1,curr+carr[i],len);
        used[i] = false;
      }
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
