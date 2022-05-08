import java.util.*;

import static utils.Output.*;

class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

public class SetClasses {
    public static void main(String[] args) {
        Set<String> names = hashSet();
        // Immutable object is modified
        // names.add("Marsha");

        sortedSet();
        navigableSet();
    }

    public static Set<String> hashSet() {
        HashSet<String> names = new HashSet<>();
        names.add("Marsha");
        names.add("Lenathea");
        names.add("Lavia");
        names.add("Marsha"); // Duplicate Set element

        print("\nHash Set: ");
        for (String name: names) {
            print(name + " "); // not in order
        }

        // set as immutable, so data return can't be modified
        return Collections.unmodifiableSet(names);
    }

    public static void linkedHashSet() {
        LinkedHashSet<String> names = new LinkedHashSet<>();
        names.add("Marsha");
        names.add("Lenathea");
        names.add("Lavia");
        names.add("Marsha"); // Duplicate Set element

        print("\nLinked Hash Set: ");
        for (String name: names) {
            print(name + " "); // sequentially
        }
    }

    public static void sortedSet() {
        SortedSet<Person> people = new TreeSet<>(new PersonComparator().reversed());

        people.add(new Person("Marsha"));
        people.add(new Person("Lenathea"));
        people.add(new Person("Lavia"));

        print("\nSorted Set: ");
        for (Person person: people) {
            print(person.getName() + " ");
        }
    }

    public static void navigableSet() {
        NavigableSet<String> names = new TreeSet<>();
        names.addAll(Set.of("Marsha", "Lenathea", "Lavia"));

        NavigableSet<String> namesReverse = names.descendingSet();
        NavigableSet<String> untilLenathea = names.headSet("Lenathea", true);
        NavigableSet<String> fromLenathea = names.tailSet("Lenathea", true);

        print("\nNavigable Set: ");
        print("\nHead Set -> ");
        for (String name: untilLenathea) {
            print(name + " ");
        }
        print("\nTail Set -> ");
        for (String name: fromLenathea) {
            print(name + " ");
        }
    }

    public static void enumSet() {
        enum Gender {
            MALE, FEMALE, NOT_MENTION
        }

        EnumSet<Gender> genders = EnumSet.allOf(Gender.class);
        for (Gender gender: genders) {
            print(gender + " ");
        }
    }
}
