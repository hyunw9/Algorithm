package PS.AlgorithmClass;

public class 특정숫자의빈도계산 {
    public static void main(String[] args) {
        findNum(4,12333,0);
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
