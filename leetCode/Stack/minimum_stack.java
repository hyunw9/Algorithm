package leetCode.Stack;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class minimum_stack {
    class MinStack {

    private static Stack<Integer> stack;
    private static HashMap<Integer,Integer> map;
    private static PriorityQueue<Integer> pq; 

    public MinStack() {
        // Stack과 PQ를 같이 놓고, getMin 시, PQ pop. 그리고 deleted info 에 추가해놓는다. 
        stack = new Stack<>();
        map = new HashMap<>();
        pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1,o2));
    }
    
    public void push(int val) {

        map.put(val,map.getOrDefault(val,0)+1);
        stack.push(val);
        pq.add(val);
        
    }
    
    public void pop() {

        while(map.get(stack.peek())<=0){
            stack.pop();
        }
        int val =stack.pop();
        map.put(val,map.get(val)-1);

    }
    
    public int top() {
        while(map.get(stack.peek())<=0){
            stack.pop();
        }
        return stack.peek();
        
    }
    
    public int getMin() {
        int val=0;
        while(!pq.isEmpty()){
            val = pq.poll();
            if(map.get(val)>=1) {
                pq.offer(val);
                break;
            }
        }
        return val;
    }
}

}
