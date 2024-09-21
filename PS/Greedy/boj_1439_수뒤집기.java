package PS.Greedy;

import java.io.*;
import java.util.*;

public class boj_1439_수뒤집기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('0',0);
        map.put('1',0);

        String line = st.nextToken();
        char deli = line.charAt(0);
        map.put(deli,map.get(deli)+1);

        for(int i = 1 ; i < line.length(); i++){
            if(line.charAt(i)!=deli){
                map.put(line.charAt(i),map.get(line.charAt(i))+1);
                deli = line.charAt(i);
            }
        }
        if(map.get('0')< map.get('1')){
            System.out.println(map.get('0'));
        }else{
            System.out.println(map.get('1'));
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