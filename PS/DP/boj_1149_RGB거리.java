package PS.DP;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] rgb = new int[N][3];
        int answer = 987654321;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        int [][]memo = new int[N][3];

        //1행 복사
        for (int i = 0; i < 3; i++) {
            memo[0][i] = rgb[0][i];
        }
        //정수 삼각형과 유사
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    memo[i][j] +=rgb[i][j]+ Math.min(memo[i - 1][j + 1], memo[i - 1][j + 2]);
                } else if (j == 1) {
                    memo[i][j] += rgb[i][j]+Math.min(memo[i - 1][j - 1], memo[i - 1][j + 1]);

                } else if (j == 2) {
                    memo[i][j] += rgb[i][j]+Math.min(memo[i-1][j-1],memo[i-1][j-2]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer,memo[N-1][i]);
        }
        System.out.println(answer);
    }
}
