package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_1043_거짓말 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> truth = new ArrayList<>();
        ArrayList<Integer>[] pt = new ArrayList[m];
        
        for(int i = 0 ; i < m ; i++){
            pt[i] = new ArrayList<>();
        }

        arr = new int[n+1];
        for(int i = 1 ; i <= n ; i++){
            arr[i] = i;
        }

        int person = Integer.parseInt(st.nextToken());
        int[] tr = new int[person];
        if(person>0){
            for(int i = 0; i<person ; i++){
                int a = Integer.parseInt(st.nextToken());
                truth.add(a);
                tr[i] = a;
            }
        }


        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < size; j ++){
                pt[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0 ; i < m ; i++){

            int first = pt[i].getFirst();
            for(int j =1; j< pt[i].size() ; j++){
                union(first, pt[i].get(j));
            }
        }
        int answer =0 ;
        for(int i = 0 ; i < m ; i++){
            int first = pt[i].getFirst();
            boolean flag = false;

            for(int j = 0 ; j< tr.length; j++){
                if(find(tr[j])==find(first)){
                    flag = true;
                    break;
                }
            }

            if(!flag){
                answer +=1;
            }
        }        
        System.out.println(answer);
        close();
    }

    public static int find(int x){
        if(arr[x] == x) return x;
        return arr[x] = find(arr[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a!=b){
            if(a<b){
                arr[b] =a;
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