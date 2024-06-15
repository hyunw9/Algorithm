package PS.String;

import java.io.*;
import java.util.*;
public class boj_5534_간판 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int n = Integer.parseInt(br.readLine());
        char[] line = br.readLine().toCharArray();
        
        for(int i = 0 ; i < n ; i++){
            char[] left = br.readLine().toCharArray();

            for(int j = 0 ; j < line.length ; j ++){
                char now = line[j];
                int count = 0;
                for(int k = 0; k < left.length; k++){
                    if(left[k]==now){
                        for(int h = )
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
