package PS.UnionFind;

import java.io.*;
import java.util.*;

public class boj_4803_트리 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        int idx = 1;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Set<Integer> cset = new HashSet<>();

            if(n == 0 && m == 0 ) break;
            arr = new int[n+1];
            for(int i = 1; i <= n; i++){
                arr[i] = i;
            }

            for(int i = 0 ; i < m ; i++){
                st=  new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                if(find(n1)!=find(n2)){
                    union(n1,n2);
                }else{
                    cset.add(n1);
                    cset.add(n2);
                }
            }
            // System.out.println(Arrays.toString(arr));
            Set<Integer> set = new HashSet<>();
            Set<Integer> pset = new HashSet<>();

            for(int i = 1 ; i <= n ; i++ ){
                set.add(arr[i]);
            }
            for(int c : set){
                pset.add(find(c));
            }

            int cycle = 0;
            Set<Integer> p = new HashSet<>();

            for(int c : cset){
                p.add(find(c));
            }
            cycle = p.size();
            // System.out.println("cycle :"+ cycle);
            if(pset.size()-cycle <=0){
                bw.write(String.format("Case %d: No trees.",idx));
            }else if(pset.size()-cycle ==1){
                bw.write(String.format("Case %d: There is one tree.",idx));
            }else{
                bw.write(String.format("Case %d: A forest of %d trees.",idx,set.size()-cycle));
            }
            bw.write("\n");
            idx+=1;
        }
        close();
    }

    public static int find(int x){
        if(arr[x]==x){
            return x;
        }
        return arr[x] = find(arr[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b){
            if(a<b){
                arr[b]= a;
            }else{
                arr[a]= b;
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