## Java Collections
collection or known as **container** is a object that collect some data feature, which we can use to build our app without any additional libraries. 

![2bb730d4896648d45948ec6fce06e80955c945e5716988a844f7d6da0b75858c-image](https://user-images.githubusercontent.com/63696803/167309867-7a0f7bf6-9b9a-4121-87ba-b75dd01cff12.png)


All collection class are generic class, so we can use them with any data type.

#

### **Iterable**
iterable is parent of all collection in java, except Map implementation, that support us to do **for-each loop**.

```
Iterable<String> names = List.of("Marsha", "Lenathea", "Lavia");

for (String name: names) {
  System.out.println(name);
}
```

#

### **List**
list has some characters :
- duplicate (we can use add duplicate data value)
- sequentially (sorted by index)
- composed by index (we can use index to manipulate data, like add or remove)

List interface was implemented by ArrayList and LinkedList.

The **LinkedList** class is a collection which can contain many objects of the same type, just like the **ArrayList**.

The **LinkedList** class has all of the same methods as the **ArrayList** class because they both implement the List interface. This means that you can add items, change items, remove items and clear the list in the same way.

However, while the ArrayList class and the LinkedList class can be used in the same way, they are built very differently.

❓ **How the ArrayList works**  
The ArrayList class has a regular array inside it. When an element is added, it is placed into the array. If the array is not big enough, a new, larger array is created to replace the old one and the old one is removed.

❓ **How the LinkedList works**  
The LinkedList stores its items in "containers." The list has a link to the first container and each container has a link to the next container in the list. To add an element to the list, the element is placed into a new container and that container is linked to one of the other containers in the list.

⚠️ **Use an ArrayList for storing and accessing data, and LinkedList to manipulate data.**

```
// arraylist default length is 10
// set length as 100
List<String> names = new ArrayList<>(100);
  names.add("Marsha");
  names.addAll(List.of("Lenathea", "Lavia"));
  names.set(0, "Lenathea");
  System.out.println(names.get(0)); // Lenathea
  names.remove(0); // [Lenathea, Lavia]

List<String> names = new LinkedList<>();
```

#

### **Set**
list has some characters :
- unduplicate (contains unique data that has no index, but is a unique key)
- not in order (has no index, but is a unique key)
- use native function from Iterable & Collection interface (has no addon like List)

List interface was implemented by EnumSet, HashSet, LinkedHashSet and SortedSet.

✳️ **EnumSet**
```
enum Gender {
  MALE, FEMALE, NOT_MENTION
}

EnumSet<Gender> genders = EnumSet.allOf(Gender.class);
  for (Gender gender: genders) {
    print(gender + " ");
  }
```

✳️ **HashSet**
```
HashSet<String> names = new HashSet<>();
  names.add("Marsha");
  names.add("Lenathea");
  names.add("Lavia");
  names.add("Marsha"); // Duplicate Set element

  for (String name: names) {
    print(name + " "); // not in order
  }

  // set as immutable, so data return can't be modified
  return Collections.unmodifiableSet(names);
```

✳️ **LinkedHashSet**
```
LinkedHashSet<String> names = new LinkedHashSet<>();
  names.add("Marsha");
  names.add("Lenathea");
  names.add("Lavia");
  names.add("Marsha"); // Duplicate Set element

  for (String name: names) {
    print(name + " "); // sequentially
  }
```

✳️**SortedSet**
```
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

public static void sortedSet() {
  SortedSet<Person> people = new TreeSet<>(new PersonComparator().reversed());

  people.add(new Person("Marsha"));
  people.add(new Person("Lenathea"));
  people.add(new Person("Lavia"));

  print("\nSorted set: ");
    for (Person person: people) {
      print(person.getName() + " ");
    }
  }
```

#

### **Queue**
Queue is implementation of FIFO (First In First Out) data structure.
