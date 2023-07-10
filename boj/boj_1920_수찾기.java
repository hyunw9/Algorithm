package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1920_수찾기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first_size= Integer.parseInt(st.nextToken());  //첫째배열 크기
        HashMap<String,Integer> map = new HashMap<>();     //정답들을 담을 해시맵 생성
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < first_size; i++) {              //해시맵에 값 담아주고 0으로 세팅
            String k = st.nextToken();
            map.put(k,0);
        }
        st=new StringTokenizer(br.readLine());
        int second_size = Integer.parseInt(st.nextToken()); //두번째 배열 크기
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < second_size; i++) {             //두번째 배열 반복 돌며
            String k= st.nextToken();
            if(map.containsKey(k)){                         //일치하는 키가 있으면, 존재하는 것이므로 1 세팅
                map.put(k,1);
            }else{                                          //없다면 0으로 고정
                map.put(k,0);
            }
            System.out.println(map.get(k));                 //반복문을 따로 돌리면 순서대로 출력되는 에러가 나므로, 현재 반복문에서 get으로 출력
        }


    }
}
