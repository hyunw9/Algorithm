package StreamPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class loop7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());
        int profit = 0;
        if(num1 == num2 &&num2 == num3){
            System.out.print(10000 + num1*1000);
        }
        else if(num1 == num2 || num1 == num3){
            System.out.print(1000 + num1*100);
        }

        else if(num2 == num3){
            System.out.print(1000 + num2*100);
        }

        else
            System.out.print((Math.max(Math.max(num1, num2), num3)*100));

            }
        }


