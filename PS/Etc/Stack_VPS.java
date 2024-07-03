package PS;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class Stack_VPS {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(1);
        pq.add(3);
        pq.add(2);
        System.out.println("pq.poll() = " + pq.poll());
        }
    }
