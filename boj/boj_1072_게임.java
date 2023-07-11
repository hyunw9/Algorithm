package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1072_게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] trees = new int[Integer.parseInt(st.nextToken())];
        int need = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < trees.length; i++) {
            trees[i]= Integer.parseInt(st.nextToken());
        }
        long count=0;
        long low=0;
        long high=0;
        long mid;
        for (int i = 0; i < trees.length; i++) {
            high = Math.max(high,trees[i]);
        }
        while(low<=high){
            count = 0 ;
            mid = (low+high)/2;

            for (int tree : trees) {
                if(tree>mid){
                    count+=tree-mid;
                }
            }
            if(count>=need){
                low = mid + 1;
            }else{
                high = mid - 1;
            }

        }
        System.out.println(high);

    }
}
