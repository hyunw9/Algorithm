package leetCode.intervals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class interval_list_intersections {

  public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
     ArrayList<int[]> arr = new ArrayList<>();

     Queue<int[]> q = new LinkedList<>();
     for(int i =0; i < firstList.length ; i++){
         q.offer(firstList[i]);
     }

     int idx = 0;
     while(!q.isEmpty()){

         int[] curr = q.poll();
         if(secondList.length == 0 ) break;

         for(int i =0 ; i < secondList.length ; i++){
             if((curr[0]<= secondList[i][0] && curr[1]>=secondList[i][0]) ||
                 (curr[0]<= secondList[i][1]&&curr[1]>=secondList[i][1])||curr[0]>=secondList[i][0] && curr[1]<=secondList[i][1]){
                     // if(curr[0]>secondList[i][0]&&curr[1]<secondList[i][1]) continue;
                     arr.add(new int[]{Math.max(secondList[i][0],curr[0]),Math.min(secondList[i][1],curr[1])});
                 }
         }
     }
     if(arr.size()==0) return new int[][]{};
     int[][] ans = new int[arr.size()][2];
     for(int i = 0 ; i < arr.size(); i++){
         ans[i][0] = arr.get(i)[0];
         ans[i][1] = arr.get(i)[1];
     }
     return ans;
//    ArrayList<int[]> list = new ArrayList<>();
//    int m = firstList.length;
//    int n = secondList.length;
//    if(m==0 || n == 0){
//      return new int[0][0];
//    }
//    int start = 0;
//    int end = 0;
//    int l = 0;
//    int r = 0;
//    while(l < n && r < m ) {
//
//      start = Math.max(firstList[l][0], secondList[r][0]);
//      end = Math.min(firstList[l][1],secondList[r][1]);
//
//      if(start <= end)
//        list.add(new int[]{start,end});
//
//      if( firstList[l][1]==end) l++;
//      if( secondList[r][1]==end) r++;
//
//    }
//
//    return list.toArray(new int[list.size()][2]);
  }

}
