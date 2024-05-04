package leetCode.dailyQuestion;

import java.util.*;

public class boats_to_save_people {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0;
        int r = people.length -1;
        Arrays.sort(people);
        int boats = 0;
        while(l <= r){
            if(people[l]+ people[r] <= limit){
                l++;
            }
            r--;
            boats++;
        }

        return boats;
    }
}
