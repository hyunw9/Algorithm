package prgmrs;

import java.util.Arrays;

public class MarathonCompleteLoop {
    public static void main(String[] args) {
        String []participant = {"mislav", "stanko", "mislav", "ana"};
        String []completion = {"stanko", "ana", "mislav"};
        String answer ="";
        Arrays.sort(participant);
        Arrays.sort(completion);

        if(participant.length> completion.length){//4-3 1
            int len = participant.length- completion.length;
            for (int i = completion.length-1; i < participant.length ; i++) {
                answer+=i;
            }
        }
        System.out.println("answer = " + answer);
    }
    
}
