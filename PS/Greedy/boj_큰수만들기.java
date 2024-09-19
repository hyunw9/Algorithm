package PS.Greedy;

import java.io.*;
import java.util.*;

public class boj_큰수만들기 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<String> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr.add(st.nextToken());
        }
        Collections.sort(arr,(o1,o2)->(o1+o2).compareTo(o2+o1));

        // System.out.println(arr);
        if(arr.get(n-1).equals("0")) System.out.println(0);

        else{
            StringBuilder sb = new StringBuilder();
            for(int i = n-1 ; i >= 0 ; i--){
                sb.append(arr.get(i));
            }
            System.out.println(sb.toString());
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

/*
** 간략한 풀이 :
*/