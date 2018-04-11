# Predicate as a parameter

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
    
    default Predicate<T> and(Predicate<? super T> other) { ... }
    
    default Predicate<T> or(Predicate<? super T> other) { ... }
    
    default Predicate<T> negate() { ... }
}
```

* This has a method `test()` which takes an object as a parameter and returns a `boolean`.
* There are also other default methods in the Predicate interface. This will allow us to
chain on booleans.

```java
Predicate<Integer> p1 = i -> i > 20;
Predicate<Integer> p2 = i -> i < 30;
Predicate<Integer> p3 = i -> i == 0;

Predicate<Integer> p = p1.and(p2).or(p3); // (p1 AND p2) OR p3
Predicate<Integer> p = p3.or(p1).and(p2); // (p3 OR p1) AND p2
```

* So we can chain our Predicates if we wanted to but the priorities of chaining these is 
not handled by methods.

## IsEqual

There is also an `isEqual()` method in the Predicate interface:

```java
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
    
    // default methods
    
    static <T> Predicate<T> isEqual(Object o) { ... } 
}
```

* It creates a new Predicate by comparing the object passed as a parameter as below:

```java
Predicate<String> p = Predicate.isEqual("two") ;
```

* And it can be used to filter out Streams of Strings as the example below:

```java
Predicate<String> p = Predicate.isEqual("two");

Stream<String> stream1 = Stream.of("one", "two", "three");

Stream<String> stream2 = stream1.filter(p);
```
* Here we have `stream1` which contains a Stream of Strings. Above that we have create our
Predicate which we will use to `filter` out the data we need.
* We also have another Stream `stream2` which will filter out `streams1` given the 
Predicate we created. 
* In this case the outcome is that `stream2` will return `two` as this matches our 
Predicate.
* Notice that the `of()` method of `Stream<>` is a static method which allows you to create
Streams in Java.
* Also `stream1` and `stream2` are actually different objects and they are not the same!