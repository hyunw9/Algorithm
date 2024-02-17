package PS.SlidingWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class boj_2531_회전초밥 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    String line = br.readLine();
    int n = Integer.parseInt(line.split(" ")[0]); // 접시수
    int d = Integer.parseInt(line.split(" ")[1]); // 종류
    int k = Integer.parseInt(line.split(" ")[2]); // 연속 먹는 접시 수
    int c = Integer.parseInt(line.split(" ")[3]); // 쿠폰번호 c
    int max =0;

    int[]arr = new int[n*2];
    for(int i = 0; i < n; i++){
      arr[i] = Integer.parseInt(br.readLine());
    }
    for(int i = n ; i < arr.length ; i++){
      arr[i] = arr[i-n];
    }

//    System.out.println(Arrays.toString(arr));
    HashMap<Integer,Integer> map =new HashMap<>();
    int l = 0;
    int r = 0;
    for(int i = 0 ; i < k ; i++){
      map.put(arr[i],map.getOrDefault(arr[i],0)+1);
      r = i;
    }


    while(r<arr.length){


        if(map.get(arr[l])-1==0){
          map.remove(arr[l]);
        }else {
          map.put(arr[l], map.get(arr[l]) - 1);
        }
        l++;

        if(r+1<arr.length){

          map.put(arr[r+1],map.getOrDefault(arr[r+1],0)+1);
        }
        r++;

        if(map.containsKey(c)){
          max = Math.max(max,map.size());
        }else{
          max= Math.max(max,map.size()+1);
        }


      //System.out.println("l : " + l + " r: "+ r );
      //System.out.println(map);
    }

    bw.write(max+"");
    close();
  }
  public static int getSum(HashMap<Integer,Integer> map ){
    int n = 0 ;
    for(int a : map.keySet()){
      n+=map.get(a);
    }
    return n;
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
