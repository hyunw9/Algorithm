package PS.binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_2467_용액 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    //0에 가까운걸 출력해야함,
    //어떻게 0에 가까운걸 판단하지 ?

    //더해서 , 절댓값이 작은 것 순으로 정렬해놓으면 됮 ㅣ않나?
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    int [] arr = new int[n];

    st= new StringTokenizer(br.readLine());
    for(int i = 0; i<n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int answer =  Integer.MAX_VALUE;
    int ansl = 0;
    int ansr=0;
    for(int i = 0 ; i < n;i++){
      int now = arr[i];
      int l =i+1;
      int r = n-1;

      while(l<=r){
        int mid = (l+r)/2;

        if(Math.abs(now+arr[mid])<=answer){
          answer = Math.abs(now+arr[mid]);
          ansl = i;
          ansr = mid;
        }

        if(now+arr[mid]>0){
          r= mid-1;
        }else{
          l = mid+1;
        }
      }
    }
    System.out.println(arr[ansl] + " "+ arr[ansr]);
    /* 투포인터 풀이
    * int l = 0;
    int r =  n-1;
    int answer= Integer.MAX_VALUE;
    int ansl=0;
    int ansr=0;
    while(l<r){
      int mid = (l+r)/2;

      int sum = arr[l]+arr[r];

      if(Math.abs(sum) <= answer){
        answer = Math.abs(sum);

        ansl = l;
        ansr = r;
      }

      if(sum>=0){//0보다 크다면
        r=r-1;

      }else{ //0보다 작다면
        l=l+1;
      }
    }
    bw.write(arr[ansl] +" "+ arr[ansr]);*/
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
