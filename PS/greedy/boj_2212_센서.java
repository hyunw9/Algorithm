package PS.greedy;

import java.io.*;
import java.util.*;

public class boj_2212_센서 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i= 0 ; i < n ; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //1,3,6,7,9
        //k-1번 쪼갤수 있고, 설치가 가능한데, 어디서 쪼개야 최적의 값일까? 
        //차이가 큰데를 쪼개야함
        Integer []diff = new Integer[n-1];
        for(int i = 0; i < n-1; i++){
            diff[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(diff,Collections.reverseOrder());
        int cnt = k-1;
        int ans = 0;
        for(int i = 0 ; i < diff.length; i++){
            if(cnt>0) {
                cnt--;
                continue;
            }else{
                ans+=diff[i];
            }
        }
        bw.write(ans+"");
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
