package prgmrs.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔대실_155651 {

  public int solution(String[][] book_time) {
    int answer = 0;
    int[][] time = new int[book_time.length][2];
    for(int i = 0 ; i<book_time.length; i++){
      time[i][0] = Integer.parseInt(book_time[i][0].replace(":",""));
      time[i][1] = Integer.parseInt(book_time[i][1].replace(":",""));
    }
    Arrays.sort(time,(o1,o2)->{
      if(o1[0]==o2[0]){
        return o1[1]-o2[1];
      }
      return o1[0]-o2[0];
    });

    //pq하나 만들어서
    //가장 빠른 공실 시간보다 입실시간이 빠르면 +1 (방 하나 더 늘림) 그리고 끝나는 시간을 +10 해서 pq에 삽입
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o1-o2);
    int end = 0;
    for(int i = 0 ; i < time.length ; i++){

      if(i==0&&pq.isEmpty()){ //처음 방이 비었으면
        answer++;
        end = time[0][1];
        int endT = time[0][1]+ 10 ;
        if(endT%100 >= 60){
          endT +=100;
          endT -=60;
        }
        pq.add(endT);
      }else{
        int cut = pq.peek();
        //System.out.println(cut);
        if(time[i][0]<cut){
          answer++;

          int endT = time[i][1]+ 10 ;
          if(endT%100 >= 60){
            endT +=100;
            endT -=60;
          }
          pq.add(endT);
        }else{
          pq.poll();
          end = time[i][1];
          // System.out.println(end);
          int endT = time[i][1]+ 10 ;
          if(endT%100 >= 60){
            endT +=100;
            endT -=60;
          }
          pq.add(endT);

        }

      }

    }
    //System.out.println(Arrays.deepToString(time));
    return answer;
  }

}
