package PS.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2792_보석상자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int low = 1;
        int high = 0;
        int answer = 0;
        int[] arr = new int [N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;
            high = Math.max(high,now);
        }
        //이분탐색 시작
        while(low<=high){
            int mid = (high + low) / 2;
            int sum = 0;
            //한 학생은 한 종류의 보석만 가져갈 수 있으므로, 배열요소 안에서 검사
            for (int i = 0; i < N; i++) {
                if(arr[i]%mid==0){
                    sum+= arr[i]/ mid;
                }else{
                    sum+= arr[i]/mid +1;
                }
            }

            if(sum>M){
                low = mid +1;
            }else{
                high = mid -1;
                answer = mid;
            }
        }
        System.out.println(answer);


    }
}
