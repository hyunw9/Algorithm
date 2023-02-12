package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Stack_VPS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int when = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <when ; i++) {
            sb.append(solve(br.readLine())).append("\n");

        }
        System.out.println(sb);
            
        }
            
        public static String solve(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c= s.charAt(i);
                if(c=='('){
                    stack.addLast(c);
                }
                else if(stack.isEmpty()){
                    return "NO";
                }else{
                    stack.pollLast();
                }


            }
           if (stack.isEmpty()){
               return "YES";
           }else{
               return "NO";
           }
        }
    }
