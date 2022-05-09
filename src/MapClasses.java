import java.util.*;

import static utils.Output.*;

public class MapClasses {
    public static void main(String[] args) {
        Map<String, String> name = hashMap();
        println(name.get("firstname"));

        // Immutable object is modified
        // name.put("lastname", "Lenathea");

        navigableMap();
    }

    public static Map<String, String> hashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("firstname", "Marsha");
        map.put("lastname", "Lenathea Lavia");

        return Collections.unmodifiableMap(map);
    }

    public static void weakHashMap() {
        Map<Integer, String> map = new WeakHashMap<>();

        // WeakHashMap is like hashMap,
        // but all data in it will remove any garbage collection
        List<String> names = List.of("Marsha", "Lenathea", "Lavia");
        for (String name: names) {
            map.put(names.indexOf(name), name);
        }

        println("size before gc: " + map.size()); // 3
        System.gc();
        println("size after gc: " + map.size()); // will be 0 when data map never use
    }

    public static void linkedHashMap() {
        Map<String, String> map = new LinkedHashMap<>();

        // LinkedHashMap will sort data map as LIFO (in order)
        map.put("firstname", "Marsha");
        map.put("lastname", "Lavia");
        map.put("middlename", "Lenathea");

        Set<String> keys = map.keySet();
        for (String key: keys) {
            println(key); // firstname lastname middlename
        }

        // if we use HashMap instead of LinkedHashMap,
        // data will not in order cause data will sorted by hashCode (generated automatically & unpredictable)
        // firstname middlename lastname
    }

    public static enum Level {
        FREE, STANDARD, PREMIUM, VIP
    }

    public static void enumMap() {
        EnumMap<Level, String> map = new EnumMap<>(Level.class);

        // EnumMap optimized for enum data usage
        map.put(Level.FREE, "Gratis");
        map.put(Level.PREMIUM, "Berbayar");

        println(map.get(Level.FREE));
        println(map.get(Level.PREMIUM));
    }

    public static void sortedMap() {
        SortedMap<String, String> map = new TreeMap<>();

        // automatically sorted by key first char
        map.put("firstname", "Marsha");
        map.put("middlename", "Lenathea");
        map.put("lastname", "Lavia");

        for (String name: map.keySet()) {
            println(name); // firstname, lastname, middlename
        }
    }

    // navigable map is instance of SortedMap
    public static void navigableMap() {
        NavigableMap<String, String> map = new TreeMap<>();

        map.put("firstname", "Marsha");
        map.put("middlename", "Lenathea");
        map.put("lastname", "Lavia");

        for (String name: map.keySet()) {
            println(name); // firstname, lastname, middlename
        }

        println(map.lowerKey("lastname")); // firstname
        println(map.higherKey("lastname")); // middlename


        println(map.lowerEntry("lastname")); // firstname=Marsha
        println(map.higherEntry("lastname")); // middlename=Lenathea
    }
}
