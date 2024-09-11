package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_14719_빗물 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] map;
    private static int h;
    private static int w;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++){

            int rain = Integer.parseInt(st.nextToken());
            map[i] = rain;
        }
        int sum = 0;
        //반복 돌며 각 왼쪽 오른쪽 최대를 구하고, 최대의 최소를 현재 값에서 빼서 더해준다. 
        for(int i = 0 ; i < w; i++){
            int lmax = map[i];
            int l = i;
            int r = i;
            int rmax = map[i];

            while(l>=0){
                if(lmax<map[l]){
                    lmax = map[l];
                }
                l--;
            }
            while(r<map.length){
                if(rmax<map[r]){
                    rmax = map[r];
                }
                r++;
            }
            int minRain = Math.min(lmax,rmax);
            sum+=(minRain-map[i]);
        }
        System.out.println(sum);

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
