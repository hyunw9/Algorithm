package leetCode.intervals;

import java.util.Collections;
import java.util.List;

public class meeting_rooms_i {
    
class Solution {

    public class Interval {
             public int start, end;
             public Interval(int start, int end) {
                 this.start = start;
                 this.end = end;
             }
         }
         
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals,(o1,o2)-> o1.end-o2.end);

        if(intervals.size() ==0) return true; 

        int start =intervals.get(0).start ;
        int end = intervals.get(0).end ;
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start >= end){
                end = Math.max(end,intervals.get(i).end);
                start = intervals.get(i).start;
            }else{
                return false;
            }
        }
        return true; 
    }
}
}
