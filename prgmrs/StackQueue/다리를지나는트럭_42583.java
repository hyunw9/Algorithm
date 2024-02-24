package prgmrs.StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭_42583 {

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    Queue<Integer> bridge = new LinkedList<>();
    for(int truck : truck_weights){

      while(true){
        if(bridge.isEmpty()){
          bridge.add(truck);
          weight -= truck;
          answer ++;
          break;
        }
        else{
          if(bridge.size()==bridge_length){
            weight += bridge.poll();
          }else if(truck>weight){
            bridge.add(0);
            answer++;
          }else{
            weight-= truck;
            answer++;
            bridge.add(truck);
            break;
          }
        }
      }

    }

    return answer+bridge_length;
  }

}
