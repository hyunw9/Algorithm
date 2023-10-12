package PS.binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_13702_이상한술집 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        long low = 1;
        long high = 0;
        long mid ;

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high,arr[i]);
        }

        while(low<=high){
            mid =( high + low)/2;

            if(mid == 0) {
                bw.write(0+"");
                break;
            }
            int val = 0;
            //반복을 돌며 몇명에게 나누어 줄 수 있는지 판별합니다.
            for (int j : arr) {
                val += j / mid;
            }

            if(K >val ){
                high = mid-1 ;
            }else{
                low = mid+1 ;
            }
        }
        bw.write(high+"");
        close();
    }

    public static void init(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException{
        br.close();
        bw.close();
    }
}
