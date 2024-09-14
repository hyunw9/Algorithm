package PS.UnionFind;

import java.io.*;
import java.util.*;

public class boj_13905_세부 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int n ;
    private static int m ;
    private static int soong ;
    private static int hyebin ;
    private static PriorityQueue<int[]>pq ;
    private static int []tree;
    private static int []cost;
    
    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        soong = Integer.parseInt(st.nextToken());
        hyebin = Integer.parseInt(st.nextToken());
        pq= new PriorityQueue<>((o1,o2)-> o2[2]-o1[2]);
        tree = new int[n+1];
        cost = new int[n+1];
        for(int i = 0; i <= n ; i++){
            tree[i] = i;

        }
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});        
        }

        int min = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int a = curr[0];
            int b = curr[1];
            int c = curr[2];

            if(find(a)!=find(b)){
                // System.out.println("a: "+ a+ " b : "+ b);
                union(a,b);
                if(find(soong) == find(hyebin)){
                    min = c;
                    break;
                }
            }
        }
        // System.out.println(Arrays.toString(tree));
        // System.out.println(Arrays.toString(cost));
        System.out.println(min);


        close();
    }

    private static int find(int x){
        if(tree[x]==x){
            return x;
        }
        return tree[x] = find(tree[x]);
    }

    private static void union(int a,int b){

        a = find(a);
        b = find(b);
        if(a!=b){
            if(a<b){
                tree[b] = a;
            }else{
                tree[a] = b;
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