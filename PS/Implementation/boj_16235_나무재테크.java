package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_16235_나무재테크 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int n;
    private static int m;
    private static int k;
    private static int[][] a;
    private static int[][] nutri;
    private static PriorityQueue<int[]> live;
    private static Queue<int[]> dead;
    private static int[]dy = {-1,-1,-1,0,0,1,1,1};
    private static int[]dx = {-1,0,1,-1,1,-1,0,1};


    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        a = new int[n][n];
        nutri = new int[n][n];
       
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j< n ; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                nutri[i][j] = 5;
            }
        }
        //나무 -> {y,x,나이}
        live = new PriorityQueue<>((o1,o2)->(o1[2]-o2[2]));
        //죽은나무 -> {y,x,나이}
        dead = new LinkedList<>();
        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            live.offer(new int[]{x-1,y-1,age});
        }
        
        for(int i = 0 ; i < k; i++){
            spring();
            // System.out.println("after spring: "+ live);

            summer();
            // System.out.println("after summer: "+ live);

            fall();
            // System.out.println("after fall: "+ live);

            winter();
            // System.out.println("after winter: "+ live);

        }
        System.out.println(live.size());
        close();

    }

    public static void spring(){
        Queue<int[]> aged = new LinkedList<>();
        while(!live.isEmpty()){
            int []curr = live.poll();

            int x = curr[0];
            int y= curr[1];
            int age = curr[2];

            if(nutri[x][y]>=age){
                nutri[x][y] -= age;
                age+=1;
                aged.offer(new int[]{x,y,age});
            }else{
                dead.offer(new int[]{x,y,age});
            }
        }

        while(!aged.isEmpty()){
            live.offer(aged.poll());
        }
        // 나이만큼 양분 먹고 나이 1 증가, 
        // 불가능 할 경우, 바로 사망
        // 나이 어린 애부터 
    }

    public static void summer(){
        // 죽은 나무 나이 / 2가 양분으로 추가 
        while(!dead.isEmpty()){
            int[] curr = dead.poll();
            int x = curr[0];
            int y = curr[1];
            int age = curr[2];

            nutri[x][y]+=age/2;
        }
    }

    public static void fall(){
        //번식, 나이가 5배수인 경우 인접 8칸에 나이 1인 나무 생성, 만약 범위 밖이면 제외
        Queue<int[]> birth = new LinkedList<>();
        for(int[] t : live){
            int x = t[0];
            int y = t[1];
            int age = t[2];
            if(age>0 && age%5 ==0){
                for(int i = 0 ; i < 8 ; i++){
                    //칸 검증 
                    int ny = y +dy[i];
                    int nx = x + dx[i];

                    if(ny<0 || nx < 0 || ny>=n || nx>=n) continue;
                    //나무 추가
                    birth.offer(new int[]{nx,ny,1});
                }
            }
        }
        while(!birth.isEmpty()){
            live.offer(birth.poll());
        }
    }

    public static void winter(){
        //양분이 맵에 있는 대로 추가됨.
        for(int i = 0 ; i<n; i++){
            for(int j = 0 ; j < n ; j++){
                nutri[i][j]+=a[i][j];
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