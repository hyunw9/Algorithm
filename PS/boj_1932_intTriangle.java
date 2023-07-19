package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1932_intTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int line = Integer.parseInt(st.nextToken()); //최대 깊이
        int [][] pyramid = new int [line][line]; //기존 피라미드
        int [][] dp = new int [line][line]; //기존 피라미드
        int result ;
        System.out.println("line = " + line);

        for (int i = 0; i < line ; i++) { //피라미드에 기존 값 입력
            st =new StringTokenizer(br.readLine()," ");
            for (int j = 0; j <i+1; j++) {
                pyramid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = pyramid[0][0];
        for (int i = 1; i < line; i++) {
            for (int j = 0; j <= i; j++) {
                if(j ==0){ //i번 째 행의 0번째 값은 무조건 i-1 행의 0번째 값+ 현재 값 이다.
                    dp[i][j] = pyramid[i][j] + dp[i-1][j];

            } else{//그게 아니라면
                    dp[i][j] =pyramid[i][j]+  Math.max(dp[i-1][j],dp[i-1][j-1]); //바로 위의 값 vs 바로 위의 왼쪽값중 높은 값을 구한다.
                }
        }
        }
        /*for (int i = 0; i <=line-1 ; i++) {
            System.out.println(dp[i][0]);S
        }*/
        result = 0;
        for (int i = 0; i <line; i++) {
            if(dp[line-1][i]>result) {
                result = dp[line - 1][i];
            }
        }
        System.out.println(result);

    }
}
