package PS;


import java.util.Scanner;

public class sw_expert_academy {
    public static void main(String[] args) {
        findNum(3,12333,0);
    }
    public static void findNum(int n,int num,int count){
        if( num == 0 ) {
            System.out.println(count);
            return;
        }
        if( num % 10 == n) {
            count++;
        }
        findNum(n,num/10,count);
    }
    }

