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