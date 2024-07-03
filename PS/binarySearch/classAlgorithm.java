package PS.BinarySearch;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class classAlgorithm {
    public static void main(String[] args) {
        int[] arr = {10, 20, 25, 35, 45, 50, 55, 60, 75, 80, 90, 95};
        int key = 50;

        System.out.println(binarySearch(arr, key));

    }

    private static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return -1;
    }
}

