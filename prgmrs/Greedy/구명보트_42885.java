package prgmrs.Greedy;

public class 구명보트_42885 {

  public int solution(int[] people, int limit) {
    int answer = 0;
    Arrays.sort(people);
    int l = 0 ;
    int r = people.length-1;
    while(l<=r){
      int curr = limit - people[r];


      if(curr>=people[l]){
        answer++;
        l++;
        r--;
      }else{
        answer++;
        r--;
      }
    }

    return answer;
  }

}
