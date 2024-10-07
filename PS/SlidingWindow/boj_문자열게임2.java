package PS.SlidingWindow;

import java.io.*;
import java.util.*;

public class boj_문자열게임2 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int t ; 
    private static char[] arr;
    private static HashMap<Character, Integer> map;


    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        while(--t>=0){
            arr = br.readLine().toCharArray();
            map = new HashMap<>();
            getMin(Integer.parseInt(br.readLine()));
        }
        
        close();
    }

    public static void getMin(int n) throws IOException {
        int l = 0, r = 0;
        int min = Integer.MAX_VALUE;
        int max = 0;
        int cnt = 0;
    
        while (l <= r && r < arr.length) {

            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
    
            if (map.get(arr[r]) == n) {
                cnt++; // 유효한 문자열 개수 증가
    
                while (map.get(arr[r]) == n) {
                    int winSize = r - l + 1;
    
                    // 최소값 갱신
                    min = Math.min(min, winSize);
                    
                    if (arr[l] == arr[r]) {
                        max = Math.max(max, winSize);
                    }

                    map.put(arr[l], map.get(arr[l]) - 1);
                    if (map.get(arr[l]) <= 0) {
                        map.remove(arr[l]);
                    }
                    l++;
                }
            }
            r++;
        }
    
        // 정확히 K개를 포함하는 문자열이 없을 경우 처리
        if (cnt == 0) {
            bw.write("-1\n");
        } else {
            bw.write(min + " " + max + "\n");
        }
        bw.flush();
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