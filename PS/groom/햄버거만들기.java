package PS.groom;

import java.util.*;

public class 햄버거만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 재료 갯수 입력받기
        int n = sc.nextInt();
        // 재료 점수 입력받기
        int[] numList = new int[n];
        for (int i = 0; i < n; i++) {
            numList[i] = sc.nextInt();
        }

        // 재료점수 총합 구해놓기
        int answer = Arrays.stream(numList).sum();
        // 정렬 후 마지막 index 숫자가 제일 큰 점수의 재료
        int highNum = Arrays.stream(numList).max().getAsInt();
        // 제일 큰 점수의 재료 index 찾기
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (numList[i] == highNum) {
                index = i;
                break;
            }
        }
        // 현재 재료 직전 점수
        int preNum = highNum;
        // 최고점 이후 재료 검증
        for (int i = index + 1; i < n; i++) {
            // 이번 index의 재료의 점수가 전 index 보다 크다면 0리턴
            if (numList[i] > preNum) {
                answer = 0;
                break;
            }
            preNum = numList[i];
        }
        // 최고점 리셋
        preNum = highNum;
        // 최고점 이전 재료 검증
        for (int i = index - 1; i >= 0; i--) {
            // 이번 index의 재료의 점수가 전 index 보다 크다면 0리턴
            if (numList[i] > preNum) {
                answer = 0;
                break;
            }
            preNum = numList[i];
        }
        System.out.println(answer);
    }
}
