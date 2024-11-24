package PS.String;

import java.io.*;
import java.util.*;

public class boj_12919_A와B2 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        String target = br.readLine();
        String line = br.readLine();

        System.out.println(dfs(line,target));
        close();
    }

    public static int dfs(String line, String target){
        System.out.println(line);
        if(line.length()<=target.length()){
            if(line.equals(target)){
                return 1;
            }else{
                return 0;
            }
        }

        int val = 0;
        
        if(line.charAt(line.length()-1)=='A'){
            String n1 = line.substring(0,line.length()-1);
            val = Math.max(val,dfs(n1,target));
        }

        if(line.charAt(0)=='B'){
            String n2 = new StringBuilder(line).reverse().toString().substring(0,line.length()-1);
            val = Math.max(val,dfs(n2,target));
        }
        

        return val;

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