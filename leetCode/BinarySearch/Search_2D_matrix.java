package leetCode.BinarySearch;

public class Search_2D_matrix {
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      // 행탐색 이후 열탐색 .
      if (matrix.length == 1 && matrix[0].length == 1) {
        return matrix[0][0] == target;
      }
      int l = 0;
      int h = matrix.length - 1;
      int row = -1;
      while (l <= h) {
        int mid = (l + h) / 2;

        if (matrix[mid][0] == target) return true;
        if (matrix[mid][0] > target) {
          h = mid - 1;
        } else if (matrix[mid][0] < target) {
          l = mid + 1;
        } else {
          break;
        }
      }
      System.out.println("l : " + l + " h : " + h);
      row = (l + h) / 2;
      l = 0;
      h = matrix[row].length - 1;
      while (l <= h) {
        int mid = (l + h) / 2;

        if (matrix[row][mid] > target) {
          h = mid - 1;
        } else if (matrix[row][mid] < target) {
          l = mid + 1;
        } else {
          return true;
        }
      }
      System.out.println(row);

      return false;
    }
  }
}
