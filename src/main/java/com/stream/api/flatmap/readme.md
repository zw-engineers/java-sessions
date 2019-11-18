# FlatMap Operation

* This is another intermediary operation as it returns another `Stream<T>`.

Let us take a look at the signature of the `flatMap`:

```java
    <R> Stream<R> flatMap(Function<T, Stream<R>> flatMapper);
     
    <R> Stream<R> map(Function<T, R> mapper);
```
* A _flatMap_ takes a _Function_ as an argument, the same kind of _Function_ as a _Map_.
* If you look at the _map_ signature you will see that a _Map_ takes an object and returns another object.
* Whereas a flatMap takes an object and returns a `Stream<T>` of objects.
* A _flatMap_ returns a _stream of streams_ and is flattened, and becomes a stream.

```java
    List<Integer> list1 = Arrays.asList(1, 2, 3);
    List<Integer> list2 = Arrays.asList(4, 5, 6);
    List<Integer> list3 = Arrays.asList(7, 8, 9);
    
    List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);
    
    Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();
    
    return listOfLists.stream()  // Here we create our Stream
                .flatMap(flatMapper) // Here we declare our flatMap() operation which takes in our Function we created.
                .reduce(0, (a, b) -> a + b); // We just use Reduction to add each element to the next.         
```
