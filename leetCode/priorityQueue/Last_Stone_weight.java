package leetCode.priorityQueue;

import java.util.PriorityQueue;

public class Last_Stone_weight {
    class Solution {
    public int lastStoneWeight(int[] stones) {  
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int val : stones){
            pq.offer(-val);
        } 
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();

            if(x==y) continue;
            else if( x< y){   
                pq.offer(x-y);
            }
        }
        pq.offer(0);
        return Math.abs(pq.peek());
    }
}

}
