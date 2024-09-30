package PS.BinarySearch;

import java.io.*;
import java.util.*;

public class boj_2412_암벽등반 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int n;
    private static int T;
    private static Queue<int[]> q;
    private static int cost = Integer.MAX_VALUE;
    private static int[][] arr;
    private static Set<String> visited; // 방문 체크를 위한 HashSet 사용

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        arr = new int[n][2]; // [n][n] -> [n][2]로 변경
        visited = new HashSet<>(); // 방문 체크를 위한 HashSet

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{x, y};
        }

        // 좌표 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        // BFS 시작
        q.add(new int[]{0, 0, 0}); // x, y, cost
        visited.add("0,0"); // 초기 위치를 방문 체크

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            int currCost = curr[2];

            if (cy == T) { // 목표 높이에 도달했을 경우
                cost = currCost;
                break;
            }

            // 현재 위치에서 2 이내의 범위를 확인하여 BFS 탐색
            for (int i = getStartIndex(cx); i < n; i++) {
                int nx = arr[i][0];
                int ny = arr[i][1];

                // x, y 범위가 2 이내인지 확인
                if (Math.abs(nx - cx) > 2 || Math.abs(ny - cy) > 2) {
                    if (nx - cx > 2) break; // x 범위가 2보다 커지면 더 이상 탐색하지 않음
                    continue;
                }

                // 방문하지 않은 좌표인지 확인
                String nextKey = nx + "," + ny;
                if (visited.contains(nextKey)) continue;

                visited.add(nextKey); // 방문 체크
                q.add(new int[]{nx, ny, currCost + 1});
            }
        }

        System.out.println(cost == Integer.MAX_VALUE ? -1 : cost); // 결과 출력
        close();
    }

    // 해당 x 값에 대한 이분 탐색 시작 인덱스 찾기
    private static int getStartIndex(int x) {
        int l = 0;
        int h = arr.length - 1;
        int res = h;
        
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid][0] >= x - 2) {
                res = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        br.close();
        bw.close();
    }
}