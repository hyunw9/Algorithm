package leetCode.intervals;

import java.util.*;

public class merge_intervals {
    public int[][] merge(int[][] intervals) {
        //1,3 2,6 8,10 15,18
        // q와 pq 를 이용해서 풀이
        // 일단 첫번째 end 를 pq 에 push 한다. 
        // 두번째부터 start 가 pq 의peek 보다 낮을 경우, pq 에 push , 
        //만약 클 경우 start 와 같이 int[] 로 만들어서 배열에 추가. 
        Arrays.sort(intervals,(o1,o2)->{
            if(o1[0]==o2[0])
                return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        //[[1,3],[2,6],[3,4],[8,10],[15,18]]
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        // Queue<int[]> q = new LinkedList<>();
        
        int start =intervals[0][0];
        int end = intervals[0][1];
        ArrayList<int[]> arr = new ArrayList<>();

        for(int i = 1; i< intervals.length; i++){
            
            if(end >= intervals[i][0]){
                end = Math.max(intervals[i][1],end);
                continue;

            }
            arr.add(new int[]{start,end});
            end = Math.max(intervals[i][1],end);
            start = Math.max(start,intervals[i][0]);
        }
        arr.add(new int[]{start,end});
        int [][] ans = new int[arr.size()][2];
        for(int i =0;i<arr.size();i++){
            ans[i][0]= arr.get(i)[0];
            ans[i][1]= arr.get(i)[1];
        }
        
        return ans;
    }
}
