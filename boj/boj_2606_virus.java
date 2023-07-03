package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_2606_virus {
     static int infected =0;
    static boolean[] visited;
    static int [][]network;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int linked = Integer.parseInt(st.nextToken());

        network = new int[N+1][N+1];
        visited =new boolean[N+1];
        for (int i = 0; i <linked ; i++) {
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            network[x][y] = network[y][x]= 1;

        }
        dfs(network,visited,1);
        infected-=1;
        System.out.println("infected-1 = " + infected);

    }
    public static void dfs(int[][]a, boolean[]check,int v ){
        if(check[v] == true){
            return;
        }
        check[v] = true;
        infected+=1;
        for (int i = 0; i < a[v].length; i++) {
            if(a[v][i]==1 && !check[i]){
                dfs(a,check,i);
            }
        }

    }
}
