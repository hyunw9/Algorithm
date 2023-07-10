package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2805_나무자르기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());              //나무의 총 개수
        int[] trees = new int[N];                              //나무를 담을 배열
        int height = Integer.parseInt(st.nextToken());         //얻고 싶은 나무 높이
        long mid = 0;                                           //중간 값
        long left = 0;                                          //배열의 최소값
        long right = 0;                                         //배열의 최대값
        long sum = 0;                                           //합계 (자른 나무들의 합)
        long res = 0;                                           //결과

        st = new StringTokenizer(br.readLine());
        //최대값 구하는 반복문
        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, trees[i]);
        }
        //검색의 범위는 최소값에서 최대값

        while (left <= right) {
            mid = (left + right) / 2;
            sum = 0;

            //나무 배열을 반복하며 중간값 보다 값이 클 시 차이 값을 sum 변수에 더하여 저장
            for (int tree : trees) {
                if (tree > mid) {
                    sum += (tree - mid);
                }
            }
            //만약 자른 값의 합이 구하고자 하는 값보다 클 때 -> mid 값이 너무 작다는 뜻입니다.
            if (sum >= height) {
                left = mid + 1;   //최소값을 중간보다 한칸        오른쪽으로 옮겨 중간값이 증가되도록 합니다.
            } else  {
                right = mid - 1;  //그렇지 않을 시, mid 값이 크다는 뜻 이므로 검색 범위를 중간보다 -1 하여 검색합니다.
            }
        }
        System.out.println(right);

    }

}
