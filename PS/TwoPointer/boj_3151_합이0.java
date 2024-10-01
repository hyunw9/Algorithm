package PS.TwoPointer;

import java.io.*;
import java.util.*;

public class boj_3151_합이0 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st =new StringTokenizer(br.readLine());
        for(int i = 0 ; i< n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //양옆을 하나씩 줄이면서, 이분탐색 ? 
        int answer =0;
        // System.out.println(binarySearch(0,arr.length,3));
        Arrays.sort(arr);
        
        for(int i = 0 ; i < n; i++){

            int pinned = arr[i];
            int l = i+1;
            int r = n-1;

            while(l<r){
                int sum = pinned + arr[l] + arr[r];
                // System.out.println(sum);
                if(sum == 0){
                    int samer = 1;
                    int samel = 1;

                    if(arr[l]==arr[r]){
                        answer += getComb(r-l+1);
                        break;
                    }

                    while(l+1 < r && arr[l]==arr[l+1]){
                        l+=1;
                        samel +=1;
                    }
                    while(r-1 >= l&& arr[r]==arr[r-1]){
                        r-=1;
                        samer +=1;
                    }

                    answer += (samel*samer);
                
                }
                if(sum < 0){
                    l+=1;
                }else {
                    r-=1;
                }
            }
        }
        System.out.println(answer);
        close();
    }

    public static int getComb(int num){
        return (num * (num-1)) /2;
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