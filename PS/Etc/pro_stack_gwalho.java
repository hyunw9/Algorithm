package PS.Etc;

import java.io.IOException;
import java.util.ArrayDeque;

public class pro_stack_gwalho {
    boolean solution(String s) throws IOException {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);

            if (now == '(') {
                stack.addLast(now);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pollLast();
                }
            }

        }

        return stack.isEmpty();
    }
}


