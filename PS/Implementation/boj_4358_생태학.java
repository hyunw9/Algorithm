package PS.Implementation;

import java.io.*;
import java.util.*;
public class boj_4358_생태학 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        String input;
        int total=0;
        Map<String,Integer> map = new TreeMap<>();
        while((input = br.readLine())!= null ){
            total++;
            map.put(input, map.getOrDefault(input,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(String k : map.keySet()){
            double count = map.get(k)*100;

           
           sb.append(k).append(" ");
           sb.append(String.format("%.4f",(double)count/(double)total));
           sb.append("\n");
        }
        System.out.print(sb.toString());
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
