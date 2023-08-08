package prgmrs;

import java.util.ArrayList;
import java.util.Arrays;

public class 체육복 {
    public static int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> check = new ArrayList<>();
        for (int i = 0; i < reserve.length ; i++) {
            check.add(reserve[i]);
        }
        for (int i = 0; i < lost.length; i++) {
            if(check.contains(lost[i]+1)){
                //check.remove(check.lost[i]+1);
            } else if (check.contains(lost[i]-1)) {
                check.remove(lost[i]-1);
            }
        }
        int answer = n  - check.size();

        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        int[] lost = {2,4};
        int[] reserve  = {1,3,5};
        int n = 5;
        solution(n,lost,reserve);
    }
}
