package PS.Implementation;

import java.io.*;
import java.util.*;
public class boj_17276_배열돌리기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        while(n-->0){
        st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] arr = new int[size+1][size+1];
        

        for( int i = 1 ; i <= size ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j<= size; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr= turnArray(d,arr,size);
        // System.out.println();
        for(int i = 1 ; i <= size; i++){

            for(int j = 1; j<=size;j++){
                bw.write(arr[i][j]+" ");
            }
            bw.write("\n");
        }
        }
        close();
    }

    public static int[][] turnArray(int d, int[][] arr,int size){
        int[] side1 = new int[size+1];
        int[] side2 = new int[size+1];
        int[] centercol = new int[size+1];
        int[] centerrow = new int[size+1];
        d = (d/45)%8;
        if(d < 0 ){
            while(d++<0){
                for(int i = 1 ; i < side1.length; i++){

                    centercol[i] = arr[i][arr.length/2] ;
                    side1[i]= arr[i][i];
                    side2[i]= arr[i][arr.length-i];
                    centerrow[i] = arr[arr.length/2][i];

                }
                for(int i =1 ; i < side1.length;i++){
                    //가운데 행은 부대각선으로 
                    arr[i][arr.length-i] = centerrow[centerrow.length-i];
                    //부대각선은 가운데 열로
                    arr[i][arr.length/2] = side2[i];
                    //가운데 열은 주대각선으로 
                    arr[i][i] = centercol[i];
                    //주대각선은 가운데 행으로
                    arr[arr.length/2][i] = side1[i];
                }
            }

        }else{
            while(d-->0){
                for(int i = 1 ; i < side1.length; i++){

                    centercol[i] = arr[i][arr.length/2] ;
                    side1[i]= arr[i][i];
                    side2[i]= arr[i][arr.length-i];
                    centerrow[i] = arr[arr.length/2][i];
                    
                }
                // System.out.println(Arrays.toString(centercol));
                //     System.out.println(Arrays.toString(side1));
                //     System.out.println(Arrays.toString(side2));
                //     System.out.println(Arrays.toString(centerrow));
                for(int i =1 ; i < side1.length;i++){
                    //가운데 행은 주대각선으로
                    arr[i][i] = centerrow[i];
                    //주대각선은 가운데 열로
                    arr[i][arr.length/2] = side1[i];
                    //가운데 열은 부대각선으로
                    arr[i][arr.length-i] = centercol[i];
                    //부대각선은 가운데 행으로
                    arr[arr.length/2][i] = side2[side2.length-i];
                }
            }
        }
        return arr;
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
