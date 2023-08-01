package PS.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1946_신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st=new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            HashMap<Integer,Integer> map = new HashMap<>();
            int scr = N;

            //해시맵에 key는 서류 심사 등수, value 는 면접 점수 등수로 추가
            for (int j = 0; j < N; j++) {
                st= new StringTokenizer(br.readLine());
                map.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            //hashmap은 오름차순으로 정렬되므로, i가 1이 아니라면 현재 인덱스의 값은 i-1 인덱스의 값이 존재하므로,
            //이미 서류 부분에서 한번 진 것이 됩니다. -> key 값을 비교해서, 이전 인덱스의 키 값보다 등수가 낮다면, 탈락입니다.
            for (int j = 1; j <= map.size(); j++) {
                if (j == 1) continue;
                if(map.get(j)>map.get(j-1)){
                    //하지만 1 1 같은 반례가 생길 수 있으므로, 탈락한 사람의 인덱스의 값을 이전 인덱스의 키값으로 변경해줍니다.
                    map.put(j,map.get(j-1));
                    scr--;
                }
            }
            sb.append(scr+"\n");
        }
        System.out.println(sb);
    }
}
