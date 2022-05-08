import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static utils.Output.*;

public class ListClasses {
    public static void main(String[] args) {
        List<String> names = arraysList();

        // Immutable object is modified
        // names.set(1, "Marsha");
        for (String name: names) {
            print(name + " ");
        }
    }

    public static List<String> arraysList() {
        // arraylist default length is 10
        ArrayList<String> names = new ArrayList<>(100); // set length as 100
        names.add("Marsha");
        names.addAll(List.of("Lenathea", "Lavia"));
        names.set(0, "Lenathea");
        names.remove(0);

        String firstName = names.get(0);
        String lastName = names.get(1);

        println("name: " + firstName + " " + lastName);

        // set list as immutable, so data return can't be modified
        return Collections.unmodifiableList(names);
    }

    public static void linkedList() {
        LinkedList<String> names = new LinkedList<>();
        names.add("Marsha");
        names.addFirst("Lenathea");
        names.removeLast();
        names.addLast("Lavia");

        String firstName = names.get(0);
        String lastName = names.get(1);

        println("name: " + firstName + " " + lastName);
    }
}
