package leetCode.SlidingWindow;

import java.util.ArrayDeque;
import java.util.TreeMap;

public class sliding_window_maximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
    // Treemap으로 오른쪽꺼만 출력하면서 나가면 되지 않나  ?
    int ans[] = new int[nums.length - k + 1];

    TreeMap<Integer, Integer> map = new TreeMap<>();
    int l = 0;
    int r = 0;
    for (int i = r; i < k; i++) {
      map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
      r += 1;
    }
    ans[0] = map.lastKey();
    while (r < nums.length) {
      map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
      map.put(nums[l], map.get(nums[l]) - 1);
      if (map.get(nums[l]) <= 0) map.remove(nums[l]);
      l += 1;
      r += 1;
      ans[r - k] = map.lastKey();
    }
    return ans;
  }

  public int[] maxSlidingWindowWithDeque(int[] nums, int k) {
        // Treemap으로 오른쪽꺼만 출력하면서 나가면 되지 않나  ? 
        int ans[] = new int[nums.length-k+1];

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int l =0;
        int r = 0;
        while(r<nums.length){

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r]){
                dq.pollLast();
            }
            dq.addLast(r);

            if(l > dq.peekFirst()){
                dq.pollFirst();
            }

            if(r+1 >= k){
                ans[l] = nums[dq.peekFirst()];
                l++;
            }
            r++;
        }
        return ans;
    }
}
