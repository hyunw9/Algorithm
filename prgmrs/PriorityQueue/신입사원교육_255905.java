package prgmrs.PriorityQueue;

import java.util.PriorityQueue;

public class 신입사원교육_255905 {

  public int solution(int[] ability, int number) {
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o1-o2);
    for(int i = 0 ; i < ability.length ; i++){
      pq.add(ability[i]);
    }

    while(--number>=0){
      if(pq.size()>1){
        int f = pq.poll();
        int s = pq.poll();
        int sum = f+s;
        f = sum;
        s= sum;
        pq.add(f);
        pq.add(s);
        //System.out.println("f: "+ f+" s: "+ s + "sum: "+ sum);
      }
    }
    while(!pq.isEmpty()){
      answer+=pq.poll();
    }
    //능력치 합 최소화
    //하려면 적은애들을 계속 교육시켜야 하지 않나 ?
    //적은애들만 뽑아서 합한 값으로 변경한다. 그리고 pq에 삽입.
    //1 2 3 4
    // 1 2 -> 3 3 3 4
    // 3 3  -> 6 6 3 4



    return answer;
  }

}
