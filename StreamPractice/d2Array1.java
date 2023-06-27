package StreamPractice;
import java.io.*;
import java.util.StringTokenizer;

public class d2Array1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int A[][] = new int[N][M];
        int B[][] = new int[N][M];
        int newArr[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            String strr = br.readLine();
            StringTokenizer stt = new StringTokenizer(strr, " ");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(stt.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            String strr = br.readLine();
            StringTokenizer stt = new StringTokenizer(strr, " ");
            for (int j = 0; j < M; j++) {
                B[i][j] = Integer.parseInt(stt.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[i][j] = A[i][j] + B[i][j];
                bw.write(String.valueOf(newArr[i][j] + " "));
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}