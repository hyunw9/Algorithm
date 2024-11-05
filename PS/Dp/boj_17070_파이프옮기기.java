package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_17070_파이프옮기기 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    public static class Node{
        int v;
        int h;
        int d;

        public Node(int h, int v, int d){
            this.v= v;
            this.h =h;
            this.d= d;
        }

        public String toString(){
            return "["+ this.h + ", "+ this.v + ", "+ this.d+"]";
        }
    }
    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        Node[][] grid = new Node[n][n];
        int[][]map = new int[n][n];
        for(int i = 0; i< n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <n; j++){
                int wall = Integer.parseInt(st.nextToken());
                map[i][j] = wall; 
            }
            for(int j = 0; j < n; j++){
                grid[i][j] = new Node(0,0,0);
            }
        }

        grid[0][1] = new Node(1,0,0);
        //벽 있으면 대각선 연산을 못함 .
        
        for(int i = 0; i < n; i++){
            for(int j = 2; j<n; j++){
                int nh=0;
                int nv=0;
                int nd=0;

                if(map[i][j]==1){
                    grid[i][j] = new Node(0,0,0);
                }else{
                    if( i == 0){
                        // if(map[i][j-1]!=1)
                        nh += grid[i][j-1].h;
                        nv = 0;
                        nd = 0;
                    }else{
                        if(map[i][j-1]==1){
                            nv = grid[i-1][j].v + grid[i-1][j].d;    
                        }else if(map[i-1][j]==1){
                            nh = grid[i][j-1].h + grid[i][j-1].d;    
                        }else if(map[i-1][j-1]==1){
                            nh = grid[i][j-1].h + grid[i][j-1].d;
                            nv = grid[i-1][j].v + grid[i-1][j].d;    
                        }else{
                            nh = grid[i][j-1].h + grid[i][j-1].d;
                            nv = grid[i-1][j].v + grid[i-1][j].d;
                            nd = grid[i-1][j-1].h +grid[i-1][j-1].v+grid[i-1][j-1].d;
                        }
                        

                    }
                    grid[i][j] = new Node(nh,nv,nd);
                    // System.out.println(grid[i][j]);
                }
                
                
            }
        }
        for(int i =  0 ; i < n ; i++){
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println(grid[n-1][n-1].h+grid[n-1][n-1].v+grid[n-1][n-1].d);
        
        close();
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