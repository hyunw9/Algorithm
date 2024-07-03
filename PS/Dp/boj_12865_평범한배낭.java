package PS.Dp;
// package PS.DP;

// import java.io.*;
// import java.util.*;

// public class boj_12865_평범한배낭 {

//     private static BufferedReader br;
//     private static BufferedWriter bw;
//     private static int n ;
//     private static int w ;
//     private static int v ;
//     private static int max;
//     private static boolean[] used;
//     private static Item[] list ;

//     private static class Item{
//         int weight;
//         int val;
//         public Item(int weight, int val){
//             this.weight = weight;
//             this.val = val;
//         }
//     }

//     public static void main(String[] args) throws IOException {
//         init();
//         StringTokenizer st = new StringTokenizer(br.readLine());
//          n = Integer.parseInt(st.nextToken());
//          w = Integer.parseInt(st.nextToken());
//          v = 0;
//          used = new boolean[n];
//         list  = new Item[n];
//         for (int i = 0; i < n; i++) {
//             st = new StringTokenizer(br.readLine());
//             int wei = Integer.parseInt(st.nextToken());
//             int val = Integer.parseInt(st.nextToken());
//             Item now = new Item(wei,val);
//             list[i] = now;
//         }
//         dfs(0,0,w);
//         bw.write(max+"");
//         close();    
//     }

//     private static void dfs(int depth, int currVal,int currWei){
//         if(depth == n|| w<0 ){
//             // System.out.println(Arrays.toString(used));
//             max = Math.max(max,currVal);
//             return;
//         }
//         for (int i = depth; i < used.length; i++) {
//             if(!used[i]){
//                 used[i] = true;
//                 if(currWei - list[i].weight>=0){
//                     dfs(i+1,currVal+ list[i].val,currWei-list[i].weight);
//                 }else{
//                     dfs(depth+1,currVal,currWei);
//                 }
//                 used[i]= false;
//             }
//         }
//     }

//     private static void init() throws IOException {
//         br = new BufferedReader(new InputStreamReader(System.in));
//         bw = new BufferedWriter(new OutputStreamWriter(System.out));
//     }

//     private static void close() throws IOException {
//         br.close();
//         bw.close();
//     }
// }
