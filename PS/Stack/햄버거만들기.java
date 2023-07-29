package PS.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class 햄버거만들기 {
    public static void main(String[] args) {
        int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        solution(ingredient);
    }

    public static int solution(int[] ingredient) {
       /* int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < ingredient.length; i++) {
            arr.add(ingredient[i]);
        }
        for (int i = 0; i < ingredient.length / 4; i++) {

            for (int j = 0; j < arr.size(); j++) {

                int k = arr.get(j);
                System.out.println(k);
                if (j + 3 < arr.size() && k == 1 && arr.get(j + 1) == 2) {
                    if (arr.get(j + 2) == 3 && arr.get(j + 3) == 1) {
                        System.out.println("거침");
                        answer += 1;

                        arr.remove(j + 3);
                        arr.remove(j + 2);
                        arr.remove(j + 1);
                        arr.remove(j);
                        System.out.println("j = " + j);
                        System.out.println(arr);

                    }

                }

            }

        }
        return answer;*/
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);


            if(stack.size()>3) {
                if (stack.get(stack.size()-4) == 1 && stack.get(stack.size() - 3) == 2 &&
                        stack.get(stack.size() - 2) == 3 && stack.get(stack.size() - 1) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }
        return answer;

    }
}
