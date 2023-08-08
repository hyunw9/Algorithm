package PS.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1541_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int depth = 0;
        int sum =0;
        String s = st.nextToken();

        //스택 생성
        Stack<Character>stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // '(' 면 깊이 1 증가 후 push
            if(s.charAt(i) == '('){
                stack.push('(');
                depth +=1;
            } else if (s.charAt(i) == ')') {
                //이면 일단 pop
                stack.pop();
                //하지만 이전 값이 (, 즉 레이저일 경우 depth 줄이고 sum에 합
                if(s.charAt(i-1) =='('){
                    depth-=1;
                    sum+=depth;
                }else{
                    //아닐 경우 그냥 +1(막대기 끝)
                    depth-=1;
                    sum+=1;
                }


            }
        }
        System.out.println(sum);

    }
}
