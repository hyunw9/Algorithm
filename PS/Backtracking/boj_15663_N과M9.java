package PS.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15663_N과M9 {
    static int[] arr;
    static int N;
    static int M;
    static boolean[] used ;
    static ArrayList<String> store ;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        used = new boolean[N];

        //중복 확인용 배열
        store = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        bt("", 0);
        System.out.println(sb);
    }

    public static void bt(String s, int cnt) {
        //이전 코드, trim을 매 분기마다 시행하는 덕분에 시간 초과가 납니다.
/*        if (cnt == M){
            if(store.contains(s.trim())){
                return;
            }
            else{
                store.add(s.trim());
                sb.append(s.trim()+"\n");
                return;
            }
        }*/
        if (cnt == M){
            s=s.trim();
            //중복된 수열을 출력하면 안되기 때문에, 중복 체크 구문을 추가하였습니다. 시간복잡도 O(N)
            if(store.contains(s)){
                return;
            }
            else{
                store.add(s);
                sb.append(s+"\n");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            //사용 여부 확인하여 백트래킹
            if(!used[i]){
                used[i] = true;
                bt(s+arr[i]+ " " , cnt+1);
                used[i] = false;
            }
        }
    }
}
