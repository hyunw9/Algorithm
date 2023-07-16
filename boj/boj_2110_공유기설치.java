package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class boj_2110_공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int []arr = new int[N+1];
        ArrayList<Integer> arrC = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr);
        int lo = 1;
        int hi = N;
        int mid = 0;
        int checkC = 0;
        arrC.add(arr[lo]);
        checkC+=1;
        arrC.add(arr[hi]);
        checkC+=1;
        while(checkC <=C){
            mid = (lo+hi)/2;

            arrC.add(arr[mid]);
            checkC +=1;


            mid = (lo+ mid)/2;
            arrC.add(mid);
            checkC+=1;


        }
        System.out.println(arrC);
    }
}
