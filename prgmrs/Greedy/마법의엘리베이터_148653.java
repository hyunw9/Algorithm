package prgmrs.Greedy;

public class 마법의엘리베이터_148653 {

  public int solution(int storey) {
    int answer = 0;
    //앞자리 5초과 이하인지,
    //만약 5라면, 앞자리가 0이어서 -5가 빠른지, +5 후 -10 이 빠른지
    //즉 , 10 보다 큰지

    while(storey>0){
      int one = storey % 10;
      storey /=10; //앞자리들 보관

      if(one >5){ //5보다 크면 하나 올려놓는게 낫다.
        answer+= 10-one;
        storey+=1;
      }else if(one < 5){ //5보다 작으면 내려놓자
        answer+= one;

      }else if((storey%10)>=5){ // 앞자리들의 1의자리가 5보다 크거나 같을 경우 앞자리를 올려놓자
        storey+=1;
        answer+=5;

      }else{//1의자리가 5인데 앞자리는 5미만일 경우 내려놓는다.
        answer+=5;
      }

    }
    return answer;
  }

}
