package leetCode.dailyQuestion;

public class compare_version_numbers {
  public int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");

    int f = 0;
    int s = 0;
    while (f < v1.length || s < v2.length) {
      int num1 = Integer.parseInt(v1[f]);
      int num2 = Integer.parseInt(v2[s]);

      if (num1 < num2) {
        return -1;
      } else if (num1 > num2) {
        return 1;
      }

      f++;
      s++;
      if (f == v1.length) {
        for (; s < v2.length; s++) {
          if (Integer.parseInt(v2[s]) > 0) {
            return -1;
          }
        }
      } else if (s == v2.length) {
        for (; f < v1.length; f++) {
          if (Integer.parseInt(v1[f]) > 0) {
            return 1;
          }
        }
      }
    }
    return 0;
    // 투포인터로 해야될듯 ?
    // 1.0.0 이랑
    // 1 이랑

    // 1.0.1 이랑
    // 1
  }
}
