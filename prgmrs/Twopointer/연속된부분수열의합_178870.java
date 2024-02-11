package prgmrs.Twopointer;

public class 연속된부분수열의합_178870 {

  public int[] solution(int[] sequence, int k) {
    int[] answer = new int[]{0, sequence.length - 1};

    int l = 0;
    int r = 0;
    int sum = sequence[0];
    while (l <= r && r < sequence.length) {
      if (sum == k) {
        if (answer[1] - answer[0] > r - l) {
          answer[0] = l;
          answer[1] = r;
        }
        sum -= sequence[l++];
      } else if (sum < k) {
        if (r + 1 < sequence.length) {
          sum += sequence[++r];
        } else {
          break;
        }
      } else {
        sum -= sequence[l++];
      }
    }
    return answer;
  }

}
