package prgmrs;

import java.util.Arrays;

public class 요격시스템 {
    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
        solution(targets);
    }

    public static int solution(int[][] targets) {
        Arrays.sort(
                targets, ((o1, o2) -> {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    }
                    return o1[1] - o2[1];
                }));

        int cut = -1;
        int answer = 0;

        for (int[] target : targets) {
            int left = target[0];
            int right = target[1];

            if (left >= cut) {
                cut = right;
                answer += 1;
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }
}
