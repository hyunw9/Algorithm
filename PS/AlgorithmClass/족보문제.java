package PS.AlgorithmClass;

public class 족보문제 {
    private static int[][]c;
    public static void main(String[] args) {
        c = new int[5][6];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                c[i][j] = 0;
            }
        }
        c[1][1] = 1;
        c[1][3] = 1;
        c[2][3] = 1;
        c[3][2] = 1;
        c[2][5] = 1;
        c[3][5] = 1;
        c[4][4] = 1;
        System.out.println(find(4,5));
    }
    public static int find(int i,int j){
        if(i ==0 ||j == 0) return 0;
        else {
            return Math.max(find(i-1,j) , find(i,j-1)) + c[i][j];
        }
    }
}
