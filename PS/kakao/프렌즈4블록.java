package PS.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프렌즈4블록 {
    static int M;
    static int N;
    static char[][] map;
    static boolean[][] used;
    static int block;

    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        solution(m, n, board);
    }

    public static int solution(int m, int n, String[] board) {
        map = new char[m][n];
        used = new boolean[m][n];
        M = m;
        N = n;
        int answer = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = board[i].charAt(j);

            }
        }
        boolean flag = true;
        while (flag) {
            flag = false;

            for (int i = 0; i < M - 1; i++) {
                for (int j = 0; j < N - 1; j++) {
                    char now = map[i][j];
                    if (map[i][j] == '#') continue;
                    if ((i <= M && j <= N) && map[i][j + 1] == now && map[i + 1][j] == now && map[i + 1][j + 1] == now) {
                        used[i][j] = true;
                        used[i][j + 1] = true;
                        used[i + 1][j] = true;
                        used[i + 1][j + 1] = true;
                        flag=true;
                    }
                }
            }
            answer = makeBlank();
            used = new boolean[M][N];
        }

        System.out.println("answer = " + answer);
        System.out.println(Arrays.deepToString(map));
        return answer;
    }

    public static int makeBlank() {
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (used[i][j]) {
                    map[i][j] = '#';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            Queue<Character> q = new LinkedList<>();
            for (int j = M-1; j >=0 ; j--) {
                if(map[j][i]=='#'){
                    cnt+=1;
                } else if (map[j][i] != '#') {
                    q.add(map[j][i]);
                }
            }

            int idx = M-1;
            while(!q.isEmpty()){
                map[idx--][i] = q.poll();
                
            }
            for (int j = idx; j >=0 ; j--) {
                map[j][i]= '#';
            }
            }
        return cnt;
        }
    }
