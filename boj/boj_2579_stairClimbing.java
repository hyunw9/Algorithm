package boj;

import java.util.Scanner;

public class boj_2579_stairClimbing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] stair = new int[301];
        int[] dp = new int[301];
        for (int i = 1; i <= N; i++)
            stair[i] = sc.nextInt();

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        dp[3] = Math.max(stair[1], stair[2]) + stair[3];

        for (int n = 4; n <= N; n++) {
            dp[n] = Math.max(dp[n - 3] + stair[n - 1], dp[n - 2]) + stair[n];
        }

        System.out.println(dp[N]);
    }
}
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2579_stairClimbing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int last = Integer.parseInt(st.nextToken());
        int[] arr = new int[100];
        int[] dp = new int[100];

        for (int i = 1; i <= last; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i]= Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(arr[1], arr[2])+arr[3];
        for (int i = 4; i <=last ; i++) {
            dp[i]= Math.max(dp[i-3]+arr[i-1],dp[i-2])+arr[i];

        }
        System.out.println(dp[last-1]);
    }
}
*/