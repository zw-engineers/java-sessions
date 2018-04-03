# Java Stream API :smirk:

## What is a Stream?

* Simple Answer
    - A Stream is a Java Types Interface as below:
    ```java
    public interface Stream<T> extends BaseStream<T, Stream<T>> { }
    ``` 
    - It is a new concept in Java.
    - IT IS NOT A `COLLECTION` !

### What does a Stream exactly do?

* It gives ways to efficiently process large amounts of data...and also smaller ones.

### What does efficiently mean?

* It means two things:
    - Data is processed in `parallel`, (why??..)to leverage the computing power of multicore CPUs
    - All the processes are conducted in a `pipeline`, to avoid unnecessary intermediary computations.

### Why can't Collection be a Stream?

* Because Stream is a new concept, and we do not want to change the way the Collection API works.

---

So a Stream is: 

* An `Object` on which one can define operations. (`map()`, `filter()`, `reduce()`)
* An `Object` that does not hold any data.
* An `Object` that should not change the data it processes.
* An `Object` that is able to process data in `one pass`.
    e.g. `.map(n -> n.getNames()).filter(name -> name.startsWith("A").reduce(....)`
* An `Object` optimised from the algorithm point of view, and able to process data in parallel.
    * `What does that mean???`, It means that for each operation performed in a stream, 
    that `operation` should be an optimal operation.

### How can we build a Stream?

- There are many patterns but a simple way to create a Stream would be below:
        
    ```java
    List<Person> persons = ...;
    Stream<Person> stream = persons.stream();
    ```
- So calling `persons.stream()` will open a stream on a `List<Person>`.

### What can we do with it?
- We can call the `forEach(Consumer<T>)` defined e.g. `stream.forEach(p -> System.out.println(p)`.
    - Here that `Consumer<T>` prints out all the elements in the persons `List`. 
    - The `forEach(Consumer<T>)` takes an instance of Consumer as an argument.

### Let's look at the `Consumer<T>` interface

```java
@FunctionalInterface
public interface Consumer<T> {

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(T t);

    /**
     * Returns a composed {@code Consumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code Consumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}
```
- `Consumer<T>` is a _functional interface_.
- Can be implemented by a lambda expression.
    - `Consumer<T> c = p -> System.out.println(p);`
- Also be executed as a method reference as an alternative
    - `Consumer<T> c = p -> System.out::println; //method reference`
- The `default Consumer<T> andThen(Consumer<? super T> after)` method allows us to 
chain consumers!