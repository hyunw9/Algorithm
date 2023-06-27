package prgmrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Phonkemon {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        int max= nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Integer> answer = new ArrayList<>(max);
        for (int i = 0; i <nums.length ; i++) {
            if( map.containsKey(nums[i])){ //이미 가지고 있으면
                int count = map.get(nums[i]);
                map.put(nums[i],count+1);
            }
            else{// 이미 가지고 있지 않으면,
                map.put(nums[i],1);
            }
        }
        int loopCnt  = 0 ;
        for (Integer key : map.keySet()) {
            loopCnt++;

            if(loopCnt>=max){
                break;
            }
        }

    }
}
