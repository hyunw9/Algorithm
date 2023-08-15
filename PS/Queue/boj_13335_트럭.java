package PS.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_13335_트럭 {
    public static class Truck {
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Truck> bridge = new LinkedList<>();

        int truck_length = Integer.parseInt(st.nextToken());
        int bridge_length = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        int []truck_weights = new int[truck_length];
        st=new StringTokenizer(br.readLine());

        for (int i = 0; i < truck_length; i++) {
            truck_weights[i] = Integer.parseInt(st.nextToken());
        }

        int currentWeight = 0;
        int index = 0;
        int time = 0;


        //트럭 내부 순회
        while (index < truck_weights.length) {
            time++;
            //다리가 비었거나, 시간 - 다리에 있는 트럭의 시간 값이 다리 길이라면 빼고 , 현재 무게에서 트럭 무게 제외
            if (!bridge.isEmpty() && time - bridge.peek().time == bridge_length) {
                Truck truck = bridge.poll();
                currentWeight -= truck.weight;
            }
            //현재 사이즈가 다리길이보다 크다면 넘기기
            if (bridge.size() >= bridge_length) {
                continue;
            }
            //현재 무개랑 트럭무게가 다리무게보다 크면 넘기기
            if (currentWeight + truck_weights[index] > weight) {
                continue;
            }


            currentWeight += truck_weights[index];
            bridge.add(new Truck(truck_weights[index], time));

            index++;
        }
        System.out.println(time + bridge_length);
    }
}

