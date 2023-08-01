package PS.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2504_괄호의값 {
    static Stack<Character> stack;
    static int score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        stack = new Stack<>();
        String s = st.nextToken();
        int num = 0;
        int temp = 1;
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == '(') {
                temp *= 2;
                stack.push(now);
            } else if (now == '[') {
                temp *= 3;
                stack.push(now);
            } else if (now == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    score = 0;
                    break;
                }
                if (s.charAt(i - 1) == '(') {
                    score += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (now == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    score = 0;
                    break;
                } else if (s.charAt(i - 1) == '[') {
                    score += temp;
                }
                stack.pop();
                temp /= 3;

            }
        }
        if (!stack.isEmpty()) {
            score = 0;
        }
        System.out.println(score);
    }
}
