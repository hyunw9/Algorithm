package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_12933_오리 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();

        String line = br.readLine();

        HashMap<Character,Integer> map = new HashMap<>();
        map.put('q',0);
        map.put('u',1);
        map.put('a',2);
        map.put('c',3);
        map.put('k',4);
        int max = 0;
        int[] arr = new int[5];

        for(int i = 0 ; i < line.length();i++){

            char now = line.charAt(i);

            if(now == 'q'){
                arr[0]+=1;
                max = Math.max(max,arr[0]);
            }else{
                if(arr[map.get(now)-1]==0){
                    max = -1;
                    break;
                }else{
                    if(now=='u'){
                        arr[map.get(now)]+=1;    
                    }else{
                        arr[map.get(now)-1]-=1;
                        arr[map.get(now)]+=1;
                    }
                }
            }
            if(now =='k'){
                arr[4]-=1;
                arr[0]-=1;
            }

        }
        for(int i = 0; i < 5; i++){
            if(arr[i]>0) max = -1;
        }
        System.out.println(max);
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