package PS.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 운동중독플레이어 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int answer = (int)getRM(Integer.parseInt(input.split(" ")[0]), Integer.parseInt(input.split(" ")[1]));
        System.out.println(answer);
    }
    public static float getRM(int W,int R){
        return  (W * ((1 + (float)R/30)));
    }
}
