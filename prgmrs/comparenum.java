package prgmrs;

import java.awt.desktop.SystemEventListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class comparenum {
    static public int solution(int num1, int num2) {
        int answer = 0;
        if( num1 == num2){
            answer = 1;
        }
        else{
            answer = -1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        solution(n1,n2);
    }
}
