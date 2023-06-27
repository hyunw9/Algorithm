package prgmrs;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.IntStream;

public class kstNum {
        public int[] solution(int[] array, int[][] commands) {
            int from , to , k ;
            int []answer= new int[commands.length];
            for (int i = 0; i <commands.length; i++) {
                from = commands[i][0];
                to = commands[i][1];
                k = commands[i][2];

                int[]temp = Arrays.copyOfRange(array,from -1, to );
                Arrays.sort(temp);
                answer[i]=temp[k-1];

            }
            System.out.println("answer = " + answer);


            return answer;
        }}
