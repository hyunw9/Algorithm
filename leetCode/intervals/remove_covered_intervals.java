package leetCode.intervals;

import java.util.*;

public class remove_covered_intervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1,o2)->{
            if(o1[0]==o2[0])
                return o2[1]-o1[1];
            return o1[0]-o2[0];
        });

        ArrayList<int[]> arr = new ArrayList<>();
        //[[1,4],[2,8],[3,6]]
        int start = intervals[0][0];
        int end =intervals[0][1];
        //걍 pq 로 관리해도 된ㄴ거 아닌가 ? 
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0]>= start && curr[1]<=end){ //커버되는 경우
                continue;
            }else{
                arr.add(new int[]{start,end});
                start = Math.max(start,curr[0]);
                end = Math.max(end,curr[1]);
            }
        }
        arr.add(new int[]{start, end});
        // for(int[] a : arr){
        //     System.out.println(Arrays.toString(a));
        // }
        // System.out.println("start : " + start + " end :  " + end);
        return arr.size();
    }
}
