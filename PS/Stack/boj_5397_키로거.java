package PS.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_5397_키로거 {

    private static BufferedReader br;
    private static StringBuilder sb;
    private static Stack<Character> stack;
    private static Stack<Character> stack2;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int times = Integer.parseInt(st.nextToken());

        for (int j = 0; j < times; j++) {

            stack = new Stack<>();
            stack2 = new Stack<>();

            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            for (int i = 0; i < line.length(); i++) {
                char now = line.charAt(i);

                if ((now == '<' && stack.isEmpty())
                        || (now == '>' && stack2.isEmpty())
                        || (now == '-' && stack.isEmpty())) {
                    continue;
                }

                if (now == '<') {
                    stack2.push(stack.pop());
                } else if (now == '>') {
                    stack.push(stack2.pop());
                } else if (now == '-') {
                    stack.pop();
                } else {
                    stack.push(now);
                }

            }

            while (!stack.isEmpty()) {
                stack2.push(stack.pop());
            }
            while (!stack2.isEmpty()) {
                sb.append(stack2.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
    }

    public static void close() throws IOException {
        br.close();
    }
}
