package thisIsCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class greedy_change {
//    당신은 음식점의 계산을 도와주는 점원입니다. 카운터에서는 거스름돈으로 사용할 500원, 100원, 50원, 10원짜리 동전이 무한히 존재한다고 가정합니다. 손님애게 거슬러 주어야 할 돈이 N원일 때 거스러주어야 할 동전의 최소 개수를 구하세요. 단, 거슬러줘야 할 돈 N은 항상 10의 배수입니다.
//    해결 아이디어
//    최적의 해를 빠르기 구하기 위해서는 가장 큰 화폐 단위부터 돈을 거슬러 주면 됩니다.
//
//    N원을 거슬러 줘야 할 때, 가장 먼저 500원으로 거슬러 줄 수 있을 만큼 거슬러 줍니다.
//
//    이후에 100원, 50원, 10원짜리 동전을 차례대로 거슬러 줄 수 있을 만큼 거슬러 주면 됩니다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0 ;
        int prc = Integer.parseInt(st.nextToken());

        while(prc != 0){
            if( prc >=500 ){
                prc-=500;
                count +=1;
            } else if (prc<500 && prc>=100) {
                prc-=100;
                count+=1;
            } else if (prc<100 && prc>=50) {
                prc-=50;
                count+=1;
            } else if (prc<50 && prc >=10) {
                prc-=10;
                count+=1;
            }
        }
        System.out.println(count);
    }
}
