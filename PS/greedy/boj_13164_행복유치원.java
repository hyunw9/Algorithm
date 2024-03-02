package PS.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_13164_행복유치원 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    //N명을 순서대로 세우고 , K 개의 조로 나눈다.
    //각 조에는 한명이상, 인접해야함. 수는 같지 않아도 됨
    // 비용은 키 큰 원생과 작은 원생의 차. 비용 최소값
    //5 3
    StringTokenizer st = new StringTokenizer ( br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    st=new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    for(int i = 0 ; i<n ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int ans = 0;
    //1 3 5 6 10
    // 2 2 1 4
    ArrayList<Integer> li = new ArrayList<>();
    for(int i = 1 ; i < n ; i++){
      li.add(arr[i]-arr[i-1]);
    }
    Collections.sort(li);
//    System.out.println(li);
    for(int i = 0 ; i < n-k ; i++){//5개를 2번 합치면 3그룹이 된다. 5 - 3 = 2번 쪼개기 => k(3그룹)
      ans+=li.get(i);
    }
    bw.write(ans+"");
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
