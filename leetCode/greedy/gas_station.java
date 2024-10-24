package leetCode.greedy;

public class gas_station {
  class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      // cost가 가장 적고, gas가 가장 많은 곳에서 시작해야 함
      // 시계방향으로 가야됨. 오른쪽

      // gas - cost가 가장 큰 부분부터 순회하는건 어떨까
      // 1.  -1, 0, -1 , 3  , 순회시 0보다 크다. (여행 가능)
      // 2.  -1, -1, 1 , 2번부터 시작. 0보다 작음 (여행 불가)
      int n = gas.length;
      int[] arr = new int[n];
      int max = 0;
      int idx = 0;
      int sum = 0;

      for (int i = 0; i < n; i++) {
        arr[i] = gas[i] - cost[i];
        sum += arr[i];
      }

      if (sum < 0) return -1;
      // 음수가 안되는 방향이 중요

      // for(int i = 0 ; i < n ; i++){

      //     // if(다음값과 현재값의 합이 음수면 skip)
      //     // 아니면 차 값 맥스 구하기
      //     if(arr[i]<0 || arr[i]+arr[(i+1+n)%n] < 0) continue;
      //     else{
      //         if(arr[i]+arr[(i+1+n)%n]>=max){
      //             max = arr[i]+arr[(i+1+n)%n];
      //             idx = i;
      //         }
      //     }
      // } or
      int total = 0;
      for (int i = 0; i < n; i++) {
        total += arr[i];

        if (total < 0) {
          total = 0;
          idx = i + 1;
        }
      }
      return idx;

      // System.out.println(idx);
      // 총 합 계산

    }
  }
}
