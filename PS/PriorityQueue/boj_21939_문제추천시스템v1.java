package PS.PriorityQueue;

import java.io.*;
import java.util.*;

public class boj_21939_문제추천시스템v1 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static TreeSet<int[]> maxSet;
    private static TreeSet<int[]> minSet;
    private static Map<Integer, Integer> problems; // 문제 번호와 난이도를 저장

    public static void main(String[] args) throws IOException {
        init();

        maxSet = new TreeSet<>((o1, o2) -> {
            if (o1[1] == o2[1])
                return o2[0] - o1[0];
            return o2[1] - o1[1];
        });
        minSet = new TreeSet<>((o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        problems = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());
            addProblem(num, diff);
        }

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String ops = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (ops.equals("add")) {
                int diff = Integer.parseInt(st.nextToken());
                addProblem(num, diff);
            } else if (ops.equals("recommend")) {
                if (num == 1) {
                    bw.write(maxSet.first()[0] + "\n");
                } else {
                    bw.write(minSet.first()[0] + "\n");
                }
            } else if (ops.equals("solved")) {
                removeProblem(num);
            }
        }

        close();
    }

    private static void addProblem(int num, int diff) {
        int[] problem = new int[]{num, diff};
        maxSet.add(problem);
        minSet.add(problem);
        problems.put(num, diff);
    }

    private static void removeProblem(int num) {
        int diff = problems.get(num);
        int[] problem = new int[]{num, diff};
        maxSet.remove(problem);
        minSet.remove(problem);
        problems.remove(num);
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
