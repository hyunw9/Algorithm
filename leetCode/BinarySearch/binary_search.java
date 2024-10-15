package leetCode.BinarySearch;

public class binary_search {
  public int search(int[] nums, int target) {
    int ans = -1;

    int l = 0;
    int h = nums.length - 1;

    while (l <= h) {

      int mid = l + ((h - l) / 2);

      if (nums[mid] < target) {
        l = mid + 1;
      } else if (nums[mid] > target) {
        h = mid - 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
