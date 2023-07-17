package boj.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class boj_2110_공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());                                               //집 수
        int C = Integer.parseInt(st.nextToken());                                               //공유기 개수
        int[] arr = new int[N + 1];                                                             //배열
        int count = 0;                                                                          //설치 공유기 개수
        int answer = 0;                                                                         //정답용
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());

        }
        //정렬
        Arrays.sort(arr);
        //탐색 초기값은 1 , 원래 arr[1]로 하였으나 오류
        int low = 1;
        //거리를 중점적으로 봐야 합니다. 최대 가능한 거리 저장
        int high = arr[N]-arr[1];
        int mid = 0;

        while(low<=high){
            mid = (low+ high) /2;
            //시작 위치
            int start = arr[1];
            //첫 시작은 무조건 공유기가 있어야하므로
            count = 1;
            for (int i =1; i <N+1 ; i++) {
                //만약 시작부터 현재 위치까지 거리가 중간으로 설정한 거리보다 크다면, (최대값을 출력해야 하므로)
                if((arr[i]-start)>=mid){
                    //공유기 개수 증가, 시작 위치 현재 인덱스로 변경
                    count++;
                    start=arr[i];
                }
            }
            //만약 설치한 공유기 개수가 C보다 크다 -> 거리가 작게 설정되어 있어서 많이 설치했다 -> 거리를 키우자!
            if(count>=C){
                answer=mid;
                low = mid+1;
            }else{
                //만약 설치한 공유기 개수가 C보다 작다 -> 거리가 너무 크게 설정되어 있어서 적게 설치했다! -> 거리를 줄이자
                high= mid-1;
            }
        }
        System.out.println(answer);

    }
}
