package leetCode.intervals;

import java.util.*;

public class insert_intervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int [][] arr = new int[intervals.length+1][2];
        for(int i =0 ; i < intervals.length; i++){
            arr[i][0]= intervals[i][0];
            arr[i][1]= intervals[i][1];
        }
        arr[arr.length-1][0] = newInterval[0];
        arr[arr.length-1][1] = newInterval[1];

        Arrays.sort(arr, (o1,o2)->{
            if(o1[0]==o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
        int start = arr[0][0];
        int end = arr[0][1];
        ArrayList<int[]> lst = new ArrayList<>();
        System.out.println(Arrays.deepToString(arr));
        for(int i =1; i < arr.length ; i++){
            int[] curr = arr[i];
            if(curr[0] <= end){
                start = Math.min(start,curr[0]);
                end = Math.max(end, curr[1]);
                continue;
            }

            lst.add(new int[]{start, end});
            
            start = Math.max(arr[i][0],start);
            end = Math.max(arr[i][1],end);
        }
        lst.add(new int[]{start,end});
        int[][] ans = new int[lst.size()][2];
        for(int i = 0 ; i < lst.size(); i++){
            ans[i][0] = lst.get(i)[0];
            ans[i][1] = lst.get(i)[1];
        }
        return ans;
    }
}
