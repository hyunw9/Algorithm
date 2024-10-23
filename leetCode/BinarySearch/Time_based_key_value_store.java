package leetCode.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;

public class Time_based_key_value_store {
  class TimeMap {

    // 타임스탬프, 감정
    public HashMap<Integer, String> emap;
    // 이름, 타임스탬프
    public HashMap<String, ArrayList<Integer>> map;

    public TimeMap() {
      this.emap = new HashMap<>();
      this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

      map.computeIfAbsent(key, x -> new ArrayList<>()).add(timestamp);
      emap.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
      // ex key == "alice" timestamp = 1

      if (map.containsKey(key) && emap.containsKey(timestamp)) {
        return emap.get(timestamp);
      }
      if (!map.containsKey(key)) return "";

      int l = 0;
      int r = map.get(key).size() - 1;
      int t = timestamp;
      int k = -1;
      while (l <= r) {
        int mid = (l + r) / 2;

        if (map.get(key).get(mid) < t) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      // if(emap.containsKey(r)) return emap.get(r);
      int v = (r + l) / 2;

      k = map.get(key).get(v);
      if (k < timestamp) return emap.get(k);
      return "";
      // return emap.get(r);
      // if key가 있고, timestamp가 존재하면 반환
      // 없을 경우, 최대값을 탐색해야함
    }
  }
}
