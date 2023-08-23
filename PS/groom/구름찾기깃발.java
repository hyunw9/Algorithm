package PS.groom;

import java.util.Scanner;

public class 구름찾기깃발 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] dy = {1, -1, 1, 0, -1, 1, 0, -1};
        int[][] matrix;
        int N, M, answer;

        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        answer = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int goormCount = 0;
                if (matrix[x][y] == 0) {
                    for (int i = 0; i < 8; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (matrix[nx][ny] == 1) {
                                goormCount ++;
                            }
                        }
                    }
                    if (goormCount == M) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
    }
}
