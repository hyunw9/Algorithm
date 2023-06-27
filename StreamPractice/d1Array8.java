package StreamPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class d1Array8 {
    public static void main(String[] args) throws IOException {
        boolean[] arr = new boolean[42];
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            arr[Integer.parseInt(br.readLine()) % 42] = true;
        }

        for (boolean v : arr) {
            if(v) count++;
        }
        System.out.println(count);
    }
}