package prgmrs.math;

public class 숫자카드나누기 {
    class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            
            int num = Math.max(arrayA[0], arrayB[0]);
            int answer =0 ;
            for(int i = 2 ; i <= num ; i++){
                if((isDiv(arrayA,i) && notDiv(arrayB,i))|| isDiv(arrayB,i) && notDiv(arrayA,i)){
                    answer = i;
                }
            }
            return answer; 
        }
        
        public static boolean isDiv(int[] arr, int deli){
            for(int val : arr){
                if(val%deli!=0) return false;
            }
            return true;
        }
        
        public static boolean notDiv(int[]arr, int deli){
            for(int val : arr){
                if(val%deli==0) return false;
            }
            return true;
        }
        
        
        
    }
}
