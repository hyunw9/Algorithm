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
            // ( 입력 받을 시 temp 값을 *2 해서 겹친 괄호 내부 값 계산
            if (now == '(') {
                temp *= 2;
                stack.push(now);
            } else if (now == '[') {
                temp *= 3;
                stack.push(now);
            } else if (now == ')') {
                //만약 ) 입력 받았는데, 스택이 비어있거나, 상단의 값이 (이 아닐 시, 즉, 짝이 일치하지 않을 시 0 반환
                if (stack.isEmpty() || stack.peek() != '(') {
                    score = 0;
                    break;
                }
                if (s.charAt(i - 1) == '(') {
                    //이전 값이 (이면, 겹친 수 만큼의 값 덧셈
                    score += temp;
                }
                stack.pop();
                //그 후는 겹친 괄호를 하나 벗어나는 것 이므로, 2로 나누어 줍니다. , ex(2번 겹칠 시 temp == 4, 한번 pop시 temp == 2)
                temp /= 2;
            } else if (now == ']') {
                //만약 ] 입력 받았는데, 스택이 비어있거나, 상단의 값이 [이 아닐 시, 즉, 짝이 일치하지 않을 시 0 반환
                if (stack.isEmpty() || stack.peek() != '[') {
                    score = 0;
                    break;
                } else if (s.charAt(i - 1) == '[') {
                    //이전 값이 ] 이면, 겹친 수 만큼의 값 덧셈
                    score += temp;
                }
                stack.pop();
                temp /= 3;

            }
        }
        //예외 처리
        if (!stack.isEmpty()) {
            score = 0;
        }
        System.out.println(score);
    }
}
