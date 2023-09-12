package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N * 2];
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int answer= 0;
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            arr1.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
            arr2.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr1);
        Collections.sort(arr2);
        for (int i = 0; i < N; i++) {
            arr[i] = arr1.get(i);
        }
        for (int i = N; i < N*2; i++) {
            arr[i] = arr2.get(i-N);
        }

        //List로 만들고 array join 하면 더 간단할것 같습니다.

        for (int i = 0; i < arr.length/2; i++) {
            answer += arr[i] * arr[arr.length-1-i];

        }
        System.out.println(answer);
    }
}
