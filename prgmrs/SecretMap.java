package prgmrs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SecretMap {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    }

        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            for (int i = 0; i < n; i++) {
                answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
                answer[i] = answer[i].replace('0', ' ');
                answer[i] = answer[i].replace('1', '#');

                while (answer[i].length() < n) {
                    answer[i] = '0' + answer[i];
                }
            }
            return answer;
        }
    }


