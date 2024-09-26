package PS.Bruteforce;

import java.io.*;
import java.util.*;


public class boj_양팔저울 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] arr; 
    private static HashSet<Integer> set;
    private static int n;
    private static boolean[] used;
    private static int limit;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());    
        arr= new int[n+1];
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        used = new boolean[n+1];
        for(int i = 1 ; i <= n ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }        
        Arrays.sort(arr);
        for(int i =1 ; i <= n ; i++){
            limit += arr[i];
        }
        dfs(n,arr[n]);
        for(int i = 1 ; i <= n ; i++){
            set.add(arr[i]);
        }
        int max = arr[n];
    
        System.out.println(max-set.size());
        System.out.println(set);
        System.out.println(limit);
        close();
    }

    public static void dfs(int idx, int curr){
        System.out.println("idx : " +idx + " curr : "+ curr);
        if(idx==0){
            if(curr>0){
                set.add(curr);
            }
            // return;
        }

        for(int i = n; i >=0 ;i--){
            if(!used[i]){
                used[i] = true;
                if(curr-arr[i]>=0){
                    dfs(i+1,curr-arr[i]);
                }
                // if(curr+arr[i]<=limit ){
                //     dfs(i+1,-arr[i]);
                // }
                used[i] = false;
            }
            
        }
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

/*
** 간략한 풀이 :
*/