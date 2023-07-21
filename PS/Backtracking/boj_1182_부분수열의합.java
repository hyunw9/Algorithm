package PS.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1182_부분수열의합 {
    static int N;
    static int S;
    static int arr[];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N]; // 배열의 크기를 N으로 변경
        st= new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        backtrack(0, 0);
        System.out.println(ans);
    }

    public static void backtrack(int sum, int start) {
        if (start == N) return; // 배열의 끝에 도달하면 종료

        if (sum + arr[start] == S) {
            ans++;
        }

        backtrack(sum + arr[start], start + 1); // 현재 원소를 포함하는 경우
        backtrack(sum, start + 1); // 현재 원소를 포함하지 않는 경우입니다.
    }
}
