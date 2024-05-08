package leetCode.intervals;

import java.util.ArrayList;
import java.util.List;

public class my_calender_i {

  List<int[]> calender ;

  public my_calender_i() {
    calender = new ArrayList<>();
  }

  public boolean book(int start, int end) {

    int[] curr = new int[]{start,end};

    for(int[] event : calender){
      if(curr[0]>=event[0]&& curr[0]<event[1] ||
          curr[0]<= event[0]&& event[0]<curr[1]){
        return false;
      }
    } // 10,20 존재, 15,25 들어옴
    calender.add(curr);
    return true;
  }
          //*TreeMap Approach*
//  TreeMap<Integer,Integer> map ;
//
//  public MyCalendar() {
//    map = new TreeMap<>();
//  }
//
//  public boolean book(int start, int end) {
//
//    Map.Entry<Integer, Integer> startBound = map.floorEntry(start);
//
//    Map.Entry<Integer,Integer> endBound = map.ceilingEntry(start);
//
//    if(startBound!=null && startBound.getValue()>start)
//      return false;
//    if(endBound!= null && endBound.getKey()<end)
//      return false;
//    map.put(start,end);
//    return true;
//
//  }

}
