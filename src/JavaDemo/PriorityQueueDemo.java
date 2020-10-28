package JavaDemo;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        add elements
        pq.add(750);
        pq.add(500);
        pq.add(900);
        pq.add(100);
        System.out.println("adding elements");
        System.out.println(pq);

        pq.remove(75);
        System.out.println("remove elements");
        System.out.println(pq);

        int element = pq.peek();
        System.out.println("Accessed Element: " + element);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
