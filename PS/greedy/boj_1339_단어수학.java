package PS.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class boj_1339_단어수학 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  static class Alpa {
    char alphabet;
    int num;
    public Alpa(char alphabet,int num){
      this.alphabet= alphabet;
      this.num = num;
    }
  }
  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    String[] arr= new String[n];
    for(int i = 0 ; i < n ; i++){
      arr[i] = br.readLine();
    }
    //어떻게 결정해야 하나 ?
    //자릿수를 일단 세야하고.
    // 자릿수 순으로 정렬을 해보자.
    Arrays.sort(arr, (o1,o2)->{
      int f = o1.length();
      int s = o2.length();
      if(f>s){
        return s-f;
      }else{
        return f-s;
      }
    });
//    System.out.println(Arrays.toString(arr));
   //각 자릿수마다 더해버린다. A 는 10000 이겠지 ?
    //그럼 배열 반복하면서 끝에서부터 10의 0승부터 더하면 됨.
    HashMap<Character,Integer> map = new HashMap<>();
    for(int i = 0  ; i< arr.length;i++){
      String line = arr[i];
      for(int j =arr[i].length()-1 ; j>=0; j--){
        char now = line.charAt(j);//B 인덱스는 4; 필요한건 10의 0승.
        map.put(now, (int) (map.getOrDefault(now,0)+Math.pow(10,line.length()-j-1)));
      }
    }
    ArrayList<Alpa> lst = new ArrayList<>();
    for(char key : map.keySet()){
      lst.add(new Alpa(key,map.get(key)));
    }
    Collections.sort(lst, (o1,o2)->o2.num-o1.num);
    int offset = 9;
    map = new HashMap<>();
    for(int i = 0 ; i < lst.size(); i++){
      map.put(lst.get(i).alphabet,offset--);
    }

    int answer = 0 ;
    for(String now : arr){
      StringBuilder sb = new StringBuilder();
      for(int i = 0 ; i < now.length(); i++){
        sb.append(map.get(now.charAt(i)));
      }
      answer+=Integer.parseInt(sb.toString());
    }
//    System.out.println(map);

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
