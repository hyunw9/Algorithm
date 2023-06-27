package thisIsCodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedy_BignumPrinciple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken()); //배열의 개수
        int M =Integer.parseInt(st.nextToken()); // 더하는 횟수
        int K = Integer.parseInt(st.nextToken()); // 최대로 더할 수 있는 수
        st = new StringTokenizer(br.readLine());
        int result = 0;
        int[]arr = new int[N];
        for (int i = 0; i <N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); //배열 입력
        }
        Arrays.sort(arr); //정렬
        int count = 0;
        for (int i = 0; i <M ; i++) {
            count++;
            if(count % K == 0 ){
                result += arr[N-2];
            }
            else{
                result += arr[N-1];

            }
        }
        System.out.println("result = " + result);
    }
}
