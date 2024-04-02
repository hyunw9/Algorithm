package PS.Backtracking;

import java.io.*;
import java.util.*;

public class boj_10819_차이를최대로2 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int max = 0;
    private static int n;
    private static boolean[] used ;
    private static int[] arr ;
    private static int[] l ;


    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        arr = new int[n];
        l= new int[n];
        used = new boolean[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0);
        bw.write(max + "");
        close();
    }
    
    private static void dfs(int depth){
        if(depth == arr.length){
            int val = getSum();
            max = Math.max(max,val);
            return;
        }
        for(int i = 0 ; i < n; i++){
            if(!used[i]){
                used[i] = true;
                l[depth] = arr[i];
                dfs(depth+1);
                used[i] = false;
            }
        }
    }

    private static int getSum(){
        int sum = 0;
        for (int i = 0; i < n-1; i++) {
            sum += (int)Math.abs(l[i]-l[i+1]);
        }
        return sum;
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        br.close();
        bw.close();
    }
}
