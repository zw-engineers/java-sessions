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

## New Method on List
* Method `replaceAll()`

```java

```