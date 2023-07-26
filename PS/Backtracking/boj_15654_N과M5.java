package PS.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15654_N과M5 {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static boolean[] used;
    static int[] arr;

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        used = new boolean[N];
        Arrays.sort(arr);
        backtracking(0,0, " ");
        System.out.println(sb);
    }

    public static void backtracking(int num,int cnt, String s) {

        if (cnt == M) {
            sb.append(s.trim() + "\n");

            return;
        }
        for (int i = 0; i < N; i++) {
            if(!used[i]){
                used[i]= true;
                backtracking(i,cnt + 1, s + " " + arr[i]);
                used[i]=false;
            }

        }
        //2 4 5

    }
}
