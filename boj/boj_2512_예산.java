package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2512_예산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());    //예산 나눠줄 곳 개수
        int[] budget = new int[size];                   //예산 리스트

        st= new StringTokenizer(br.readLine());

        //값을 배열에 입력받습니다.
        for (int i = 0; i < size; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }

        st= new StringTokenizer(br.readLine());


        int max = Integer.parseInt(st.nextToken());  //나눠 줄 수 있는 최대 예산
        long low = 0 ;                               //가장 낮은 값 (초기는 0)
        long high = 0;                               //배열 중 가장 높은 값
        long mid ;                                   //중간 값
        long answer = 0;                             //정답 변수

        //배열을 돌며 최대값 계산
        for (int j : budget) {
            high = Math.max(high, j);
        }
        //low 에서 high 까지
        while(low<=high){
            long sum = 0;
            mid =(low+high)/2;
            for (int b : budget) {                  //배열을 돌며 중간값 보다 큰 값 발견 시, 중간값을 더해줍니다(중간 값이 최대 값이므로)
                if(b > mid){                        //그렇지 않을 경우는 그냥 원래 값을 더해줍니다.
                    sum += mid;
                }else{
                    sum+=b;
                }
            }
            if (sum <= max) {                       //더한 값들이 max보다 작거나 같을 경우, mid 값이 작다는 뜻이 되므로, low = mid +1 로 탐색 위치를 갱신합니다.
                answer= mid;                        // sum <= max 조건이므로 answer 에 mid 값을 저장합니다.
                low = mid +1;
            } else{                                 //그렇지 않다면, mid 값이 크다는 뜻이 되므로, 값을 감소시켜서 탐색합니다.
                high = mid - 1;
            }
        }
        System.out.println(answer);

    }
}
