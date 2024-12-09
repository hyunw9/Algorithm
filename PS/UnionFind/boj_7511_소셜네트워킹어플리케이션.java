package PS.UnionFind;

import java.io.*;
import java.util.*;

public class boj_7511_소셜네트워킹어플리케이션 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        int k =0;
        while(k++<t){
            bw.write("Scenario "+ k+":\n");

            int n = Integer.parseInt(br.readLine());

            int[]arr= new int[n];
            for(int i = 0 ; i < n; i++){
                arr[i] = i;
            }
            int f = Integer.parseInt(br.readLine());
            for(int i = 0; i < f; i++){
                st = new StringTokenizer(br.readLine());
                int f1 = Integer.parseInt(st.nextToken());
                int f2 = Integer.parseInt(st.nextToken());

                if(find(arr,f1)!= find(arr,f2)){
                    union(arr,f1,f2);
                }
            }
            // bw.write(Arrays.toString(arr));
            int c = Integer.parseInt(br.readLine());
            for(int i = 0 ; i < c; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b=  Integer.parseInt(st.nextToken());

                if(find(arr,a)!=find(arr,b)){
                    bw.write("0\n");
                }else{
                    bw.write("1\n");
                }
            }
            bw.write("\n");
        }

        close();
    }

    private static int find(int[] arr, int x){
        if(arr[x] == x){
            return x;
        }
        return find(arr,arr[x]);
    }

    public static void union(int[] arr, int a , int b){
        a = find(arr, a);
        b = find(arr,b);

        if(a!=b){
            if(a<b){
                arr[b]= a;
            }else{
                arr[a] = b;
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