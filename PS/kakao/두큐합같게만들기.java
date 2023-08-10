package PS.kakao;

import java.util.ArrayDeque;
import java.util.Objects;

public class 두큐합같게만들기 {
    public static int solution(int[] queue1, int[] queue2) {
        //setup
        int answer = 0;
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        for (int i = 0; i < queue1.length; i++) {
            q1.addLast(queue1[i]);
            q2.addLast(queue2[i]);
        }

        long half = getHalfSum(queue1, queue2);
        long q1sum = getSum(q1);

        //TC 1 번 오류for (int i = 0; i < queue1.length + queue2.length; i++) {
        for (int i = 0; i < queue1.length *3; i++) {
            if (q1sum == half) break;

            else if (q1sum<half && !q2.isEmpty()) {
                int val = q2.pollFirst();
                q1.addLast(val);

                q1sum+=val;
                answer+=1;

            } else if (q1sum > half && !q1.isEmpty()) {
                int val = q1.pollFirst();
                q2.addLast(val);

                q1sum-=val;
                answer+=1;
            }
        }
        //엣지케이스. 최악의 경우는 q1 -> q2 -> 모든 요소 q1. 총 세번까지 가능하다.
        if(answer== queue1.length*3){
            answer=-1;
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    public static long getSum(ArrayDeque<Integer> queue) {
        long sum = 0;
        for (Integer idx : queue) {
            sum+=idx;
        }
        return sum;
    }

    public static long getHalfSum(int[] queue1, int[] queue2) {
        long half = 0;

        for (int i = 0; i < queue1.length; i++) {
            half += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            half += queue2[i];
        }
        return half / 2;
    }

    public static void main(String[] args) {
        int[] queue1 = {0};
        int[] queue2 = {0};
        solution(queue1, queue2);
    }
}
