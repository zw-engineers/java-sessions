# ForEach Operation

* The _forEach()_ method is a _Terminal Operation_.
* It's a void method that takes a _Consumer_ and does not return anything.
* It has an abstract method `accept(T t)` which takes an argument and performs
an operation on that argument type.
* There is also another method `andThen(Consumer<T> after)` which allows us to chain
another consumer to another consumer and perform an operation on the chained consumer. 

Suppose we wanted to perform an operation of adding elements to a list based on a filter. 
For example, if we had a list of people of different ages and we wanted to have a list of 
people who are over 20 only, we could use the _forEach_ operation to help us achieve that.

## Building and Consuming a Stream

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
     * Returns a composed {@codeconsumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@codeconsumer} that performs in sequence this
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

### Let's chain consumers

```java
List<String> list = new ArrayList<>();

Consumer<String> c1 = s -> list.add(s); // or s -> list::add(s);
Consumer<String> c2 = s -> System.out.println(s); // or s -> System.out::println;

// we can chain both consumers as below:
Consumer<String> c3 = c1.andThen(c2);
```
- Because `forEach()` does not return anything, we can chain consumers using the 
`default` method `andThen()`.
```java
persons.stream()
        .forEach(c1.andThen(c2));
```