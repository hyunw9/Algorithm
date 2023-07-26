package PS.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15657_N과M8{
    static int [] arr;
    static boolean [] visited;
    static int N;
    static int M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited=new boolean[N];
        sb=new StringBuilder();
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bt("",0,0);
        System.out.println(sb);
    }
    static void bt(String s, int depth,int start){
        if(depth ==M){
            sb.append(s.trim()+"\n");
            return;
        }
        for (int i = start; i < N; i++) {
            bt(s+ " "+ arr[i], depth+1, i);
        }
    }
}
