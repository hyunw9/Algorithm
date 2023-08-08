package PS.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1541_잃어버린괄호 {
    static class hang {
        int num;
        char sign;

        public hang(int num, char sign) {
            this.num = num;
            this.sign = sign;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        StringBuilder num = new StringBuilder();
        char sign = '+';
        int sum = 0;
        ArrayList<hang> arr = new ArrayList<>();
        //항 클래스에 각각 부호와 숫자를 만들어 배열에 넣어줍니다.
        //기본값은 + 부호
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == '-' || now == '+') {
                arr.add(new hang(Integer.parseInt(String.valueOf(num)), sign));
                num = new StringBuilder();

                if (now == '-') {
                    sign = '-';
                } else {
                    sign = '+';
                }
            } else {
                num.append(now);

            }
        }
        //- 부호가 있으면 다른 - 를 만나기 전까지 +부호들을 -로 바꿔줍니다 (괄호 적용)
        arr.add(new hang(Integer.parseInt(String.valueOf(num)), sign));
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).sign == '-') {
                for (int j = i + 1; j < arr.size(); j++) {
                    if (arr.get(j).sign == '+') {
                        arr.get(j).sign = '-';
                    } else if (arr.get(j).sign == '-') {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            System.out.println("arr.get(i).sign = " + arr.get(i).sign);
            System.out.println("arr.get(i).num = " + arr.get(i).num);
            if (arr.get(i).sign == '+') {
                sum += arr.get(i).num;
            } else {
                sum -= arr.get(i).num;
            }
        }
        System.out.println(sum);

    }
}
