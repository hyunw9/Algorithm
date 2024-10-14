package leetCode.Stack;

import java.util.*;

public class daily_temperatures {
    
    public int[] dailyTemperatures(int[] tmp) {
        //스택은 내림차순 정렬
        ArrayDeque<Integer> dq= new ArrayDeque<>();
        int[] res = new int[tmp.length];
        Arrays.fill(res,0);
        for(int i = 0 ;i < tmp.length ; i++){

            int idx = i;

            while(!dq.isEmpty()&& tmp[dq.peekLast()]< tmp[idx]){
                int poll = dq.pollLast();
                res[poll] = idx-poll;
            }


            dq.addLast(idx);


        }
        return res;
        //pop한애의 인덱스를 들어오는인덱스랑 현재인덱스랑 뺀 값으로 넣기 . 
        // result[popidx] = curridx - popidx;
    }
}
