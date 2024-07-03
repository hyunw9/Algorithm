package PS.Hash;

import java.io.*;
import java.util.*;
public class boj_1159_농구경기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        HashMap<Character, Integer> map = new HashMap<>();

        int n  =Integer.parseInt(br.readLine());
        int max = 0;
        for( int i= 0 ; i < n ; i++){
            char now = br.readLine().charAt(0);

            map.put(now,map.getOrDefault(now,0)+1);
            max = Math.max(max,map.get(now));
        }
        if(max>=5){
            List<Character> arr = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(Character a :map.keySet()){
                if( map.get(a)>=5) arr.add(a);
            }
            Collections.sort(arr);
            for(char a : arr){
                sb.append(a);
            }
            System.out.println(sb.toString());
        }else{
            System.out.println("PREDAJA");
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
