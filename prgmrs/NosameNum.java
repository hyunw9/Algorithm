package prgmrs;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class NosameNum {
    public int[] solution(int []arr){
    ArrayList<Integer> array= new ArrayList<Integer>();
    int value = -1;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]!=value ){
                array.add(arr[i]);
                value = arr[i];
            }
        }
        int [] answer = {};
        answer= new int[array.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = array.get(i);
        }
    return answer;
    }
}
