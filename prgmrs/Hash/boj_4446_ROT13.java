package prgmrs.Hash;

import java.io.*;
import java.util.*;

public class boj_4446_ROT13 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[127];
        char[] mo={'a','i','y','e','o','u'};
        char[]curr = {'b','k','x','z','n','h','d','c','w','g','p','v','j','q','t','s','r','l','m','f'};
        for(int i = 0 ; i < mo.length; i++){
            arr[mo[i]]= i;
        }
        for(int i = 0 ; i < curr.length; i++){
            arr[curr[i]]= i;
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