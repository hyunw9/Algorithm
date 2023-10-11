package PS.AlgorithmClass;

import java.util.Arrays;

public class 최단거리 {

    public static void main(String[] args) {
        int n = 6;
        int m = 5;
        int [][]map = new int[n][m];
        map[0][0] = 0;

        for (int i = 0; i < n; i++) {
            map[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            map[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        System.out.println(Arrays.deepToString(map));
    }
}
