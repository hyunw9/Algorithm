package PS.AlgorithmClass;

public class 특정숫자의빈도계산 {
    public static void main(String[] args) {
        System.out.println(findNum(3,12333,0));
    }
    public static int findNum(int n,int num,int count){
        if( num == 0 ) {
            return count;
        }
        if( num % 10 == n) {
            count++;
        }

        return  findNum(n,num/10,count);
    }
}
