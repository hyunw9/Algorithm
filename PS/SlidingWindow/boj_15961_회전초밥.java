package PS.SlidingWindow;

import java.io.*;
import java.util.*;

public class boj_15961_회전초밥 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        int var = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l=0;
        int r=0;
        int[] arr = new int[n*2];

        for(int i = 0; i < n ; i++){
            int input = Integer.parseInt(br.readLine());
            arr[i]= input;
            arr[n+i]= input;
        }

        while(r<k){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            r++;
        }
        var = map.size();
        // System.out.println(Arrays.toString(arr));
        while(l<=r && r< arr.length){
            //r 한칸 이동 -> map 에 추가 
            if(!map.containsKey(c)){
                var = Math.max(var,map.size()+1);
            }else{
                var = Math.max(var,map.size());
            }

            var = Math.max(var,map.size());
            
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            r+=1;
            //l 한칸 이동 -> map에서 삭제 
            // System.out.println(map);

            map.put(arr[l],map.get(arr[l])-1);
            if(map.get(arr[l])<=0){
                map.remove(arr[l]);
            }
            l+=1;
        }
        System.out.println(var);
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