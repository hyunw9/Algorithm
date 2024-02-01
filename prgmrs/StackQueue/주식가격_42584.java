package prgmrs.StackQueue;

public class 주식가격_42584 {

  public int[] solution(int[] prices) {
    int[] answer = new int[prices.length];
    for(int i = 0 ; i <prices.length; i ++){
      int cnt = 0;
      for(int j = i+1; j<prices.length; j++){

        if(prices[j]>=prices[i]) cnt+=1;
        else{
          cnt++;
          break;
        }
      }
      answer[i] = cnt;
    }
    //System.out.println(Arrays.toString(answer));
    return answer;
  }
}
