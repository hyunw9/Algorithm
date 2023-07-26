package PS.Backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15655_N과M6 {
    static int[] arr;
    static  int N ;
    static int M;
    static boolean[] visited ;
    static int idx;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr= new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        bt("",0,0);
        System.out.println(sb);

    }
    public static void bt (String s ,int depth,int idx){

        if(depth == M ){
            System.out.println("리턴!");
            sb.append(s.trim() + "\n");
            return;
        }

        for (int i = idx; i < N; i++) {
           if(!visited[i]){
               visited[i]=true;
               System.out.println("cnt : " + " "+ depth +",  i : " + i);
               System.out.println(arr[i]);
               bt(s +" "+ arr[i],depth+1,i+1);
               visited[i]=false;
           }
        }
    }
}
