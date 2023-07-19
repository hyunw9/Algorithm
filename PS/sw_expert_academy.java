package PS;


import java.util.Scanner;

public class sw_expert_academy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        for (int t = 1; t <= testCase; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int q = scanner.nextInt();
            scanner.nextLine(); // 개행 문자 처리

            int[][] grid = new int[n][m];

            // 각 셀의 초기 외계 곰팡이 개체 수 입력 받기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.nextInt();
                }
                scanner.nextLine(); // 개행 문자 처리
            }

            // 각 케이스의 안전한 셀 개수 계산
            long totalSafeCells = 0;
            int[] rowMax = new int[n];
            int[] colMax = new int[m];

            // 초기 외계 곰팡이 개체 수를 기준으로 각 행과 열의 최댓값을 저장
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                    colMax[j] = Math.max(colMax[j], grid[i][j]);
                }
            }

            // 관측 보고서 처리
            for (int i = 0; i < q; i++) {
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                int x = scanner.nextInt();
                scanner.nextLine(); // 개행 문자 처리

                r--; // 0-based index로 변환
                c--; // 0-based index로 변환

                // 셀 값 업데이트
                grid[r][c] = x;

                // 업데이트된 셀의 행과 열의 최댓값 갱신
                rowMax[r] = Math.max(rowMax[r], x);
                colMax[c] = Math.max(colMax[c], x);

                // 안전한 셀 개수 계산
                long safeCells = 0;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < m; k++) {
                        if (grid[j][k] >= rowMax[j] || grid[j][k] >= colMax[k]) {
                            safeCells++;
                        }
                    }
                }

                totalSafeCells += safeCells;
            }

            System.out.println("#" + t + " " + totalSafeCells);
        }

        scanner.close();
    }
    }

