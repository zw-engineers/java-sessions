# Collection API & HashMap

## New Methods on the Collection API
* Of course, the most important methods added to the *Collection API* were the `stream()` and
`parallelStream()`.
* Also we have a new method which is the `Spliterator()`.
* The `Iterator` is to `Collection`, what the `Spliterator` is to the `Streams`.
* What does this *split* stuff mean?
    * It just means that the `Spliterator` is able to split a *Collection* or a *Stream*
    just because it needs to be able to process that stream/collection in parallel.

## New Method on Iterable
* Method `forEach()`

```java
    public class IterableNewMethod {
    
        public List<String> names() {
            List<String> names = Arrays.asList("Artemas", "Thomas", "Bob");
            List<String> namesInUpperCase = new ArrayList<>();
            names.forEach(name -> namesInUpperCase.add(name.toUpperCase()));
            return namesInUpperCase;
        }
    
    }
```

## New Method on Collection
* Method `removeIf()`, returns a boolean.
* This method takes a `Predicate` which returns true or false.
* In our case the `Predicate` will return true/false based on in the collection has
been modified or not.

```java
    public class CollectionNewMethod {
        public Collection<String> removeElement() {
            // Removes an element on a Predicate.
            Collection<String> strings = Arrays.asList("one", "two", "three", "four");
    
            // Will not work if list in unmodifiable
            Collection<String> list = new ArrayList<>(strings);
    
            // Returns true if list has been modified.
            boolean b = list.removeIf(s -> s.equals("three"));
    
            // Return modified list.
            return list;
        }
    }
```

## New Methods on List
* Method `replaceAll()`
* The method takes a `Function` as a parameter, which is a `Unary Operator`.
* That `Function` takes the elements of that list and returns another list of the same
type.

```java
public class CollectionNewMethod {
    public List<String> toUpperCase(List<String> strings) {
        strings.replaceAll(String::toUpperCase);
        return strings;
    }
}
```

* Method `sort()`
* It sorts the element of the list by providing a `Comparator`.
```java
    public class ListNewMethod {
        public List<String> sortedList() {
            // Removes an element on a predicate
            List<String> strings = Arrays.asList("one", "two", "three", "four");
    
            // will not work if list is unmodifiable
            List<String> list = new ArrayList<>(strings);
    
            // Doesn't return anything
            list.sort(Comparator.naturalOrder());
    
            return list;
        }
    }
```

## New Methods on Comparator
* Method `Comparator.comparing(Function)`

```java
    public class ComparatorNewMethods {
        public List<Person> namesInOrder() {
            List<Person> people = Arrays.asList(
                    new Person("Lemuel", "Muzanenhamo"),
                    new Person("Thomas", "Jefferson"),
                    new Person("Artemas", "Muzanenhamo")
            );
    
            people.sort(Comparator.comparing(Person::getLastName));
    
            return people;
        }
    }
```
* If we want to chain those _Comparators_, we can just use
the `thenComparing()` method.
* So in the example, if the _last names_ are equal then compare 
by their _first names_.

```java
    public class ComparatorNewMethods {
        public List<Person> namesInOrder() {
            List<Person> people = Arrays.asList(
                    new Person("Lemuel", "Muzanenhamo"),
                    new Person("Thomas", "Jefferson"),
                    new Person("Artemas", "Muzanenhamo")
            );
    
            people.sort(
                    Comparator.comparing(Person::getLastName)
                    .thenComparing(Comparator.comparing(Person::getName)));
    
            return people;
        }
    }
```

* How to reverse a given Comparator?

```java
    Comparator<Person> comp = ...;
    
    Comparator<Person> reversedComp = comp.reversed();
```

* We can use the `Comparator.naturalOrder()` to compare
for example _Strings_ in their alphabetical order.
* Suppose we have null values in a list, and we wanted to 
sort the list with null values at the beginning of the list?
* We can use the `Comparator.nullsFirst()` method to handle that
for us.
```java
    // Considers null values lesser than non-null values
    Comparator<String> c = 
        Comparator.nullsFirst(Comparator.natualOrder());
```
* And of course
```java
    // Considers null values greater than non-null values
    Comparator<String> c = 
        Comparator.nullsLast(Comparator.natualOrder());
```

## New Methods of the Number Types
* All primitive numbers have their associated wrapper types.

* New useful methods: sum, max, min:
`long max = Long.max(1L, 2L);`
* Useful to create reduction operations:
```
BinaryOperator<Long> sum = (l1, l2) -> l1 + l2;
                         = Long::sum;
```
* New way to compute hashcode on numbers:
```java
    // JDK 7
    long l = 3141592653589793238L;
    int hash = new Long(l).hashCode(); // -1985256439
```
* Costly boxing/unboxing to compute this hashcode.
```java
    // JDK 8
    long l = 3141592653589793238L;
    int hash = Long.hashCode(l); // - 1985256439
```
* This method is available on 8 wrapper types.

## New Methods on the Map Interface

* Method `forEach()`
* Takes a BiConsumer as a parameter

```java
    public class MapNewMethods {
        public List<Person> retrievePeople() {
            Map<Integer, Person> personMap = new HashMap<>();
            List<Person> people = new ArrayList<>();
    
            personMap.put(1, new Person("Artemas", "Muzanenhamo"));
            personMap.put(2, new Person("John", "Smith"));
    
            personMap.forEach((key, person) -> people.add(person));
    
            return people;
        }
    }
```