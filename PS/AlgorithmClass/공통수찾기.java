package PS.AlgorithmClass;

import java.util.ArrayList;

public class 공통수찾기 {
    public static void main(String[] args) {
        int[] a = {2,5,5,5};
        int[] b = {2,2,3,5,5,7};
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<a.length && j <b.length){
            if(a[i] == b[j]){
                arr.add(a[i]);
                i++;
                j++;
            }else if(a[i]>b[j]){
                j++;
            }else if(a[i]<b[j]){
                i++;
            }
        }
        System.out.println(arr);
    }
    }

