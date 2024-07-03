package PS.Hash;

import java.io.*;
import java.util.*;
public class boj_9046_복호화 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int n = Integer.parseInt(br.readLine());
        for(int i= 0 ; i < n ; i ++){
            int max = 0;
            Map<Character,Integer> map =new HashMap<>();
            
            String line = br.readLine();
            for(int j = 0 ; j<line.length(); j++){
                char c = line.charAt(j);
                if(c == ' ') continue;
                map.put(c,map.getOrDefault(c,0)+1);
                max = Math.max(map.get(c),max);
            }
            int count = 0;
            for(Character k : map.keySet()){
                if(map.get(k) ==max) count+=1;
            }
            if(count>1) System.out.println("?");
            else{
                for(Character key : map.keySet()){
                    if(map.get(key)==max){
                        System.out.println(key);
                        break;
                    }
                }
            }

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
