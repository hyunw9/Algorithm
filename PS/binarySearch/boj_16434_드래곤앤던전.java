package PS.BinarySearch;

import java.io.*;
import java.util.*;
public class boj_16434_드래곤앤던전 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int initAttack = Integer.parseInt(st.nextToken());
        ArrayList<int[]> roomInfo = new ArrayList<>();
        long minHp=0;
        long maxHp=0;
        for(int i  = 0 ; i< n ; i ++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            maxHp += h;
            roomInfo.add(new int[] {t,a,h});
        }
        System.out.println(20/3);

        while(minHp<=maxHp){

            long mid = (minHp+maxHp)/2; //구하는 최대값 

            for(int[] room : roomInfo){
                int offset = room[0];
                int health = room[1];
                int life = room[2];

                if(offset == 1){
                    mid -= life/initAttack;
                }


            }
        
        }

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
