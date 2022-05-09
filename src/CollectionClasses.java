import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static utils.Output.*;

public class CollectionClasses {
    public static void main(String[] args) {
        sortList();
    }

    public static void sortList() {
        List<String> names = new ArrayList<>();
        names.addAll(List.of("Marsha", "Lenathea", "Lavia"));
        Collections.sort(names);
        println(names);

        Collections.reverse(names);
        println(names);

        Collections.shuffle(names);
        println(names);
    }

    public static void sortListWithComparator() {
        Comparator<String> reverse = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };
        // Comparator<String> reverse = (o1, o2) -> o2.compareTo(o1);

        List<String> names = new ArrayList<>();
        names.addAll(List.of("Marsha", "Lenathea", "Lavia"));
        names.sort(reverse);

        for (String name: names) {
            print(name + ", ");
        }
    }

    public static void binarySearch() {
        List<String> names = new ArrayList<>();
        names.addAll(List.of("Marsha", "Lenathea", "Lavia"));

        Collections.sort(names);
        int indexOfSearch = Collections.binarySearch(names, "Lavia");

        println(indexOfSearch);
    }
}
