import java.util.*;

import static utils.Output.*;

public class QueueClasses {
    public static void main(String[] args) {
        arrayDeque();
    }

    public static void arrayQueue() {
        Queue<String> queue = new ArrayDeque<>(10);

        List<String> names = List.of("Marsha", "Lenathea", "Lavia");
        queue.addAll(names);

        for (String next = queue.poll(); next != null; next = queue.poll()) {
            println(next);
        }

        println(queue.toString());
    }

    public static void priorityQueue() {
        Queue<String> queue = new PriorityQueue<>();

        List<String> names = List.of("Marsha", "Lenathea", "Lavia");
        queue.addAll(names);

        // priority queue automatically sort data by character
        for (String next = queue.poll(); next != null; next = queue.poll()) {
            println(next);
        }

        println(queue.toString());
    }

    public static void arrayDeque() {
        Deque<String> deque = new ArrayDeque<>();

        List<String> names = List.of("Marsha", "Lenathea", "Lavia");
        for (String name: names) {
            deque.addFirst(name);
        }

        for (String data : deque) {
            print(data + ", "); // Lavia, Lenathea, Marsha,
        }
        println("");

        println(deque.toString()); // [Lavia, Lenathea, Marsha]
        deque.pollLast();
        println(deque.toString()); // [Lavia, Lenathea]
        deque.pollFirst();
        println(deque.toString()); // [Lenathea]
    }
}
