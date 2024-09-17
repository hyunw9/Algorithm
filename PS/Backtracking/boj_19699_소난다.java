package PS.Backtracking;

import java.io.*;
import java.util.*;

public class boj_19699_소난다 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int n;
    private static int m;
    private static int[] arr;
    private static boolean[] used;
    private static List<Integer> list;
    private static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());    
        m = Integer.parseInt(st.nextToken());    
        st = new StringTokenizer(br.readLine());
        arr= new int[n];
        used = new boolean[n];
        list = new ArrayList<>();
        set = new HashSet<>();
        for(int i =0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());   
        }
        dfs(0,0);
        Collections.sort(list);
        if(list.size()>0){
            for(int i = 0 ; i < list.size(); i++){
                System.out.print(list.get(i)+" ");
            }
        }else{
            System.out.print(-1);
        }
        close();
    }

    public static void dfs(int depth, int curr){
        if(depth == m){
            if(curr <=1) return;
            else {
                for(int i =2; i<=(int)Math.sqrt(curr); i++){
                    if(curr % i == 0){
                        return;
                    }
                }
            
        }
        if(!set.contains(curr)){
            set.add(curr);
            list.add(curr);
        }
        return;
        }
        for(int i = 0 ; i < n; i++){
            if(!used[i]){
                used[i] = true;
                    dfs(depth+1,curr+arr[i]);
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