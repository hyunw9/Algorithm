package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_16719_ZOAC {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static boolean[] used;
    private static char[] arr;
    private static PriorityQueue<String> pq;
    private static List<String> ans;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String line = st.nextToken();
        
        arr= line.toCharArray();
        used = new boolean[arr.length];
        pq = new PriorityQueue<>((o1,o2)->o1.compareTo(o2));

        dfs(0,arr.length-1);
        close();
    }

    private static void dfs(int l , int r){
        if(l>r){
            return;
        }
        int min = l;
        for(int i = l ; i <= r;i++){
            if(!used[i] && arr[i]<arr[min]){
                min = i;
            }
        }
        used[min] = true;
        print();

        dfs(min+1,r);
        dfs(l,min-1);
    }

    private static void print(){
        for(int i = 0 ; i < arr.length; i++){
            if(used[i]){
                System.out.print(arr[i]);
            }
        }
        System.out.println();
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